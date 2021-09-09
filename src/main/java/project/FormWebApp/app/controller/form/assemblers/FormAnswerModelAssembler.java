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
import project.FormWebApp.app.controller.form.FormAnswerController;
import project.FormWebApp.app.domain.form.FormAnswer;

/**
 *
 * @author Daniel Carvalho
 */
@Component
public class FormAnswerModelAssembler implements RepresentationModelAssembler<FormAnswer, EntityModel<FormAnswer>> {

    @Override
    public EntityModel<FormAnswer> toModel(FormAnswer entity) {
        return EntityModel.of(entity, //
                linkTo(methodOn(FormAnswerController.class).oneFormAnswer(entity.getId())).withSelfRel(),
                linkTo(methodOn(FormAnswerController.class).allFormAnswers()).withRel("formAnswers"));
    }

}
