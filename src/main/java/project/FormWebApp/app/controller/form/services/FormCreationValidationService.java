/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app.controller.form.services;

import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Service;
import project.FormWebApp.antlr.formscript.FormScript;
import project.FormWebApp.antlr.formscript.visitors.FormValidationScriptVisitor;
import project.FormWebApp.app.domain.form.FormAttribute;

/**
 *
 * @author Utilizador
 */
@Service
public class FormCreationValidationService {

    public String validateFormRules(List<String> grammarRules, List<FormAttribute> attributesSet) {
        if (grammarRules.isEmpty()) {
            return "";
        }
        StringBuilder scriptBuilder = new StringBuilder();
        grammarRules.forEach(rule -> {
            scriptBuilder.append(rule);
            if (rule.charAt(rule.length() - 1) == ';') {
                scriptBuilder.append("\n");
            } else {
                scriptBuilder.append(";\n");
            }
        });
        FormScript script = new FormScript(scriptBuilder.toString());
        if (!script.errorString().isEmpty()) {
            return script.errorString();
        }
        ParseTree tree = script.start();
        if (!script.errorString().isEmpty()) {
            return script.errorString();
        }

        FormValidationScriptVisitor scriptV = new FormValidationScriptVisitor(attributesSet);
        try {
            scriptV.visit(tree);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return "";
    }

}
