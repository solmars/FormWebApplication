package project.FormWebApp.app.domain.form.dto;

import org.springframework.hateoas.EntityModel;

import project.FormWebApp.app.domain.form.Form;

public class FormDTO extends EntityModel<FormDTO> {

    // lets leave the dto with only these attributes as we will only be needing
    // these, if we need more we will add in the future.
    public String name;

    public String description;

    public long id;
    public FormDTO(Form form) {
        this.id = form.getFormId();
        this.name = form.getName();
        this.description = form.getDescription();
    }
}