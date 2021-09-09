package project.FormWebApp.antlr.formscript;

/**
 *
 * @author Daniel Carvalho
 */
public enum ErrorType {
    SEMANTIC {
        @Override
        public String toString() {
            return "Semantic error";
        }
    },
    LEXICAL {
        @Override
        public String toString() {
            return "Lexical error";
        }
    },
    SYNTACTICAL {
        @Override
        public String toString() {
            return "Syntactical error";
        }
    };
}
