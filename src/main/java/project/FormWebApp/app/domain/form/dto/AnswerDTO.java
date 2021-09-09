package project.FormWebApp.app.domain.form.dto;


import lombok.Data;


@Data
public class AnswerDTO {
    private String answer;
    private Long variableId;

    public AnswerDTO(String answer, Long variableId) {
        this.answer = answer;
        this.variableId = variableId;
    }

}