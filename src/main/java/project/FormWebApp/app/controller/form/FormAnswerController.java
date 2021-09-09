/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app.controller.form;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.FormWebApp.app.controller.form.assemblers.FormAnswerModelAssembler;
import project.FormWebApp.app.controller.form.services.FormAnswerValidationService;
import project.FormWebApp.app.controller.general.exceptions.EntityNotFoundException;
import project.FormWebApp.app.domain.form.Answer;
import project.FormWebApp.app.domain.form.Form;
import project.FormWebApp.app.domain.form.FormAnswer;
import project.FormWebApp.app.domain.form.dto.FormAnswerDTO;
import project.FormWebApp.app.repository.FormAnswerRepository;
import project.FormWebApp.app.repository.FormAttributeRepository;
import project.FormWebApp.app.repository.FormRepository;

/**
 *
 * @author Daniel Carvalho
 */
@RestController
public class FormAnswerController {
    @Autowired
    private FormAttributeRepository attRepository;

    @Autowired
    private FormAnswerRepository repository;

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private FormAnswerModelAssembler assembler;

    @Autowired
    private FormAnswerValidationService validationService;

    @GetMapping("/formAnswer")
    public CollectionModel<EntityModel<FormAnswer>> allFormAnswers() {
        List<EntityModel<FormAnswer>> forms = this.repository.findAll().stream() //
                .map(this.assembler::toModel) //
                .collect(Collectors.toList());
        return CollectionModel.of(forms, linkTo(methodOn(FormAnswerController.class).allFormAnswers()).withSelfRel());
    }
    // Single item

    @GetMapping("/formAnswer/{formAnswerId}")
    public EntityModel<FormAnswer> oneFormAnswer(@PathVariable Long formAnswerId) {

        FormAnswer formAnswer = repository.findById(formAnswerId)
                .orElseThrow(() -> new EntityNotFoundException("Form answer", formAnswerId));
        return assembler.toModel(formAnswer);
    }

    @PostMapping("/formAnswer")
    public ResponseEntity<?> addFormAnswer(@RequestBody FormAnswerDTO formAnswerDTO) {
        Form form = this.formRepository.findById(formAnswerDTO.getFormId())
                .orElseThrow(() -> new EntityNotFoundException("Form", formAnswerDTO.getFormId()));
        List<Answer> answers = formAnswerDTO.getAnswers().stream()
                .map(t -> new Answer(t.getAnswer(),
                        attRepository.findById(t.getVariableId())
                                .orElseThrow(() -> new EntityNotFoundException("FormAttribute", t.getVariableId()))))
                .collect(Collectors.toList());
        String errors = this.validationService.validateAnswers(answers, form);
        if (!errors.isEmpty()) {
            // if error was found, return the error message
            LoggerFactory.getLogger(this.getClass()).warn("\nDidn't form answers due to following errors: " + errors);
            return ResponseEntity.badRequest().body(errors);
        }
        FormAnswer newForm = new FormAnswer(answers);
        EntityModel<FormAnswer> entityModel = assembler.toModel(repository.save(newForm));
        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/formAnswer/{id}")
    public ResponseEntity<?> deleteFormAnswer(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
