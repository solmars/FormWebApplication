/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app.controller.form;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Daniel Carvalho
 */
@RestController
public class AppController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView defaultErrorMapping() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        return modelAndView;
    }

    @GetMapping(value = {"/about", "howToUse", "formCreation", "answerForm"})
    public ModelAndView sidebarRedirection() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html"); // redirect to index.html, which will then construct DOM through javascript function
        return modelAndView;
    }

}
