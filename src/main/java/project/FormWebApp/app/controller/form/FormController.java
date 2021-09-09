/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app.controller.form;

import java.util.ArrayList;
import project.FormWebApp.app.controller.form.assemblers.FormModelAssembler;
import project.FormWebApp.app.controller.general.exceptions.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.FormWebApp.app.controller.form.services.FormCreationValidationService;
import project.FormWebApp.app.domain.form.Form;
import project.FormWebApp.app.domain.form.dto.FormDTO;

import project.FormWebApp.app.repository.FormRepository;

/**
 *
 * @author Daniel Carvalho
 */
@RestController
public class FormController {

    @Autowired
    private FormRepository repository;

    @Autowired
    private FormModelAssembler assembler;
    @Autowired
    private FormCreationValidationService validator;

    @GetMapping("/forms")
    public CollectionModel<EntityModel<Form>> allForms() {
        List<EntityModel<Form>> forms = this.repository.findAll().stream().map(this.assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(forms, linkTo(methodOn(FormController.class).allForms()).withSelfRel());
    }

    // TODO: link with assembler to actual form
    @GetMapping("/formsDTO")
    public List<FormDTO> allFormsDTO() {
        List<FormDTO> forms = this.repository.findAll().stream().map(FormDTO::new) //
                .collect(Collectors.toList());
        return forms;
    }

    @GetMapping("/forms/{formId}")
    public EntityModel<Form> oneForm(@PathVariable Long formId) {

        Form form = repository.findById(formId).orElseThrow(() -> new EntityNotFoundException("form", formId));
        return assembler.toModel(form);
    }

    @PostMapping("/forms")
    public ResponseEntity<?> addForm(@RequestBody Form newForm) {
        String errors = this.validator.validateFormRules(newForm.getGrammarRules(),
                new ArrayList<>(newForm.getAttributes()));
        if (!errors.isEmpty()) {
            // if error was found, return the error message
            LoggerFactory.getLogger(this.getClass()).warn("Didn't add form due to following grammar errors: " + errors);
            return ResponseEntity.badRequest().body(errors);
        }
        EntityModel<Form> entityModel = assembler.toModel(repository.save(newForm));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/forms/{id}")
    public ResponseEntity<?> deleteForm(@PathVariable Long formId) {
        repository.deleteById(formId);
        return ResponseEntity.noContent().build();
    }

}
