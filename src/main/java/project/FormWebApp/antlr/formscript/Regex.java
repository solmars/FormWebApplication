/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.antlr.formscript;

/**
 * Class created just for clarity on the visitors
 * @author Daniel Carvalho
 */
public class Regex {
    public String regex;
    
    public Regex(String regex) {
        this.regex = regex;
    }
    @Override
    public String toString() {
        return this.regex;
    }
}
