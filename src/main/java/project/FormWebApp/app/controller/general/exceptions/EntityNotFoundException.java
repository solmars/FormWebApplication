/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app.controller.general.exceptions;

/**
 *
 * @author Daniel Carvalho
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entityName, Long id) {
        super("Could not find " + entityName + " with id " + id);
    }
}
