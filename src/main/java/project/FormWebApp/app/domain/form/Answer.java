/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app.domain.form;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

import lombok.Data;
import project.FormWebApp.antlr.formscript.DataType;

/**
 *
 * @author Daniel Carvalho
 */
@Embeddable
@Data
public class Answer implements Serializable {

    private String answer;

    @OneToOne
    private FormAttribute formAttribute;

    protected Answer() {
    }

    public Answer(String answer, final FormAttribute attribute) {
        if (!answer.isEmpty() && attribute.getDataType().equals(DataType.STRING) && answer.charAt(0) != '"'
                && answer.charAt(answer.length() - 1) != '"') {
            answer = '"' + answer + '"';
        }
        this.answer = answer;
        this.formAttribute = attribute;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Answer)) {
            return false;
        }

        final Answer that = (Answer) o;
        return this.answer.equals(that.answer) && this.formAttribute.equals(that.formAttribute);
    }

    public String answer() {
        return answer;
    }

    public FormAttribute formAttribute() {
        return formAttribute;
    }

    @Override
    public int hashCode() {
        return this.answer.hashCode() + this.formAttribute.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("\nQuestion: ").append(this.formAttribute.toString());
        strBuilder.append("\nAnswer: ").append(this.answer);
        return strBuilder.toString();
    }
}
