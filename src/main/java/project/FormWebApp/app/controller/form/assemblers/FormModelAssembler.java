/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app.controller.form.assemblers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;
import project.FormWebApp.app.controller.form.FormController;
import project.FormWebApp.app.domain.form.Form;

/**
 *
 * @author Daniel Carvalho
 */
@Component
public class FormModelAssembler implements RepresentationModelAssembler<Form, EntityModel<Form>> {

    @Override
    public EntityModel<Form> toModel(Form form) {
        return EntityModel.of(form, linkTo(methodOn(FormController.class).oneForm(form.getFormId())).withSelfRel(),
                linkTo(methodOn(FormController.class).allForms()).withRel("forms"));
    }

}
