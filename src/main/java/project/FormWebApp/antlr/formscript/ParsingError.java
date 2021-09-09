/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.antlr.formscript;

/**
 * ParsingError class, partially inspired by Federico Tomasetti
 * https://github.com/Strumenta/kolasu To be used by validation classes, if
 * applicable.
 *
 * @author Daniel Carvalho
 */
public class ParsingError {

    private final ErrorType errorType;

    private final String message;

    private final String positionDescription;

    public ParsingError(ErrorType errorType, String message, String positionDescription) {
        this.errorType = errorType;
        this.message = message;
        this.positionDescription = positionDescription;
    }

    @Override
    public String toString() {
        StringBuilder errorBuilder = new StringBuilder();
        errorBuilder.append(errorType.toString()).append(" at: ").append(positionDescription).append(": ").append(message);
        return errorBuilder.toString();
    }

}
