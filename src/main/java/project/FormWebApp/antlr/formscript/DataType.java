package project.FormWebApp.antlr.formscript;

import project.FormWebApp.antlr.formscript.generated.FormScriptGrammarLexer;

/**
 *
 * @author Daniel Carvalho
 */
public enum DataType {
    INTEGER(FormScriptGrammarLexer.INTEGER) {
        @Override
        public String toString() {
            return "Integer";
        }
    },
    STRING(FormScriptGrammarLexer.STRING) {
        @Override
        public String toString() {
            return "String";
        }
    },
    BOOLEAN(FormScriptGrammarLexer.BOOLEAN) {
        @Override
        public String toString() {
            return "Boolean";
        }
    },
    DATE(FormScriptGrammarLexer.DATE) {
        @Override
        public String toString() {
            return "Date";
        }
    },
    FILE(FormScriptGrammarLexer.FILE) {
        @Override
        public String toString() {
            return "File";
        }
    };

    private final Integer associatedLexerValue;

    DataType(Integer lexerValue) {
        this.associatedLexerValue = lexerValue;
    }

    public Integer lexerValue() {
        return this.associatedLexerValue;
    }
}
