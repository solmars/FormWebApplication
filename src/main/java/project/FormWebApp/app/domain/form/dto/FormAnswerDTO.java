package project.FormWebApp.app.domain.form.dto;

import java.util.List;

import lombok.Data;

@Data
public class FormAnswerDTO {
    private List<AnswerDTO> answers;
    
    private Long formId;

    public FormAnswerDTO(final List<AnswerDTO> answers, final Long formId) {
        this.answers = answers;
        this.formId=formId;
    }
}
