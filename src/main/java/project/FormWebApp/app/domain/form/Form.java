/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app.domain.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author Daniel Carvalho
 */
@XmlRootElement
@Entity
@Data
public class Form implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long formId;

    private String name;

    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}) // necessary cascade
    private final List<FormAttribute> attributes = new ArrayList<>();

    @ElementCollection(fetch = FetchType.LAZY)
    private final List<String> grammarRules = new ArrayList<>();

    protected Form() {
        // ORM
    }

    public Form(final String name,final String description, final List<FormAttribute> formAttributeList, List<String> grammarRules) {
        this.description = description;
        this.name = name;
        this.attributes.addAll(formAttributeList);
        this.grammarRules.addAll(grammarRules);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nForm name: ").append(this.name);
        this.attributes.forEach(attribute -> str.append("\nAttribute").append(attribute.toString()));
        return str.toString();
    }

    public Set<FormAttribute> getAttributes() {
        return new LinkedHashSet<>(attributes);
    }

    public List<String> getGrammarRules() {
        return new ArrayList<>(grammarRules);
    }
    public String scriptString() {
        StringBuilder strBuilder = new StringBuilder();
        this.grammarRules.forEach(rule -> strBuilder.append(rule).append("\n"));
        
        return strBuilder.toString();
    }

}
