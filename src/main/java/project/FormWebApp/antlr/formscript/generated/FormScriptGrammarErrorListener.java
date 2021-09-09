/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.antlr.formscript.generated;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 *
 * @author Utilizador
 */
public class FormScriptGrammarErrorListener extends BaseErrorListener {

    private List<String> errorList = new ArrayList<>();

    public List<String> errorList() {
        return errorList;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object symbol, int line, int charPosition, String message, RecognitionException e) {
        errorList.add("line " + line + ":" + charPosition + " " + message);
    }

    @Override
    public String toString() {
        if (this.errorList().isEmpty()) {
            return "";
        }
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("\nErrors: ");
        this.errorList().forEach(error -> strBuilder.append("\n").append(error));
        return strBuilder.toString();
    }

}
