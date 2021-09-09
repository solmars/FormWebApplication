/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app.domain.form;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import project.FormWebApp.antlr.formscript.DataType;

/**
 * This class is an Entity and an AggregateRoot purely for DDD reasons, so the
 * value Object Answer in the entity FormAnswers can reference a FormAttribute
 * without breaking DDD
 *
 * @author Daniel Carvalho
 */
@Entity
@Data
public class FormAttribute {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attributeId;

    private String variableName;
    private String description; // description FOR HELPING to understand the attribute when answering the form.
    @Enumerated(EnumType.STRING)
    private DataType dataType;
    private String regularExp;

    public FormAttribute(final String variableName, final String helpDescription,
            final DataType dataType, final String expRegular) {
        this.variableName = variableName;
        this.description = helpDescription;
        this.dataType = dataType;
        this.regularExp = expRegular;
    }
    protected FormAttribute() {
        
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nAttribute variable name: ").append(this.variableName);
        str.append("\nAttribute help description: ").append(this.description);
        str.append("\nAttribute data type: ").append(this.dataType);
        str.append("\nAttribute regular expression: ").append(this.regularExp);
        return str.toString();
    }


}
