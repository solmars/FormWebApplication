package project.FormWebApp.app.controller.form.services;

import java.util.List;

import org.springframework.stereotype.Service;

import project.FormWebApp.antlr.formscript.FormScript;
import project.FormWebApp.antlr.formscript.visitors.FormAnswerScriptVisitor;
import project.FormWebApp.app.domain.form.Answer;
import project.FormWebApp.app.domain.form.Form;

import org.antlr.v4.runtime.tree.ParseTree;

@Service
public class FormAnswerValidationService {

    
    public String validateAnswers(List<Answer> answerList,Form formToRespondTo) {
        FormScript script = new FormScript(formToRespondTo.scriptString());
        ParseTree tree = script.start();
        FormAnswerScriptVisitor scriptV = new FormAnswerScriptVisitor(answerList);
        boolean isValid = scriptV.visit(tree);
        if (!isValid) {
            StringBuilder errorBuilder = new StringBuilder();
            scriptV.listOfErrors().forEach(error -> errorBuilder.append(error).append("\n"));
            return errorBuilder.toString();
        }

        return "";

    }
}
