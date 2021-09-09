package project.FormWebApp.antlr.formscript;

import project.FormWebApp.antlr.formscript.generated.FormScriptGrammarParser;
import project.FormWebApp.antlr.formscript.generated.FormScriptGrammarErrorListener;
import project.FormWebApp.antlr.formscript.generated.FormScriptGrammarLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author Daniel Carvalho
 */
public class FormScript {
    
    private FormScriptGrammarLexer lexer;
    private FormScriptGrammarErrorListener errorListener;
    private FormScriptGrammarParser parser;
    
    private FormScript() { // don't allow non contextual instantiation
    }
    
    public FormScript(String input) {
        errorListener = new FormScriptGrammarErrorListener();
        lexer = new FormScriptGrammarLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new FormScriptGrammarParser(tokens);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        
    }
    
    public String errorString() {
        return this.errorListener.toString();
    }
    
    public void clearErrors() {
        this.errorListener.errorList().clear();
    }
    
    public ParseTree start() {
        this.clearErrors();
        return this.parser.start();
    }
}
