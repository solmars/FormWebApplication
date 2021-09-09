/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app.domain.form;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author Daniel Carvalho
 */
@Data
@Entity
public class FormAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    private final Set<Answer> answers = new HashSet<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar creationDate;

    protected FormAnswer() {
    }

    public FormAnswer(List<Answer> answers) {
        this.answers.addAll(answers);
        this.creationDate = Calendar.getInstance();
    }

    public Set<Answer> answers() {
        return new HashSet<>(answers);
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        this.answers.forEach(answer -> strBuilder.append(answer.toString()));
        return strBuilder.toString();
    }

}
