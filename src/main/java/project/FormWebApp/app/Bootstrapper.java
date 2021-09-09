/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import project.FormWebApp.antlr.formscript.DataType;
import project.FormWebApp.app.domain.form.Form;
import project.FormWebApp.app.domain.form.FormAttribute;
import project.FormWebApp.app.repository.FormRepository;

@Configuration
class Bootstrapper {

    private static final Logger log = LoggerFactory.getLogger(Bootstrapper.class);

    @Autowired
    private FormRepository formRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            createAbsenceForm();
            createClientDiscountRequestForm();

            log.info("\nFinished bootstrapping");
        };
    }

    @Transactional
    private void createAbsenceForm() {
        FormAttribute att1 = new FormAttribute("v_1", "Insert the start of your absence (dd-MM-yyyy)", DataType.DATE,
                "");
        FormAttribute att2 = new FormAttribute("v_2", "Insert the end of your absence (dd-MM-yyyy)", DataType.DATE, "");
        FormAttribute att3 = new FormAttribute("v_3", "Insert the absence type(Vacation,Justified,Non-justified)",
                DataType.STRING, "\"Vacation\"|\"Justified\"|\"Non-justified\"");
        FormAttribute att4 = new FormAttribute("v_4", "Insert the justification for your absence", DataType.STRING, "");
        List<FormAttribute> formAttributes = new ArrayList<>(Arrays.asList(att1, att2, att3, att4));
        log.info("Bootstrapping form attributes of absence form ");
        // Set<FormAttribute> actualSet = new
        // LinkedHashSet<>(attRepository.saveAll(formAttributes));
        // log.info("Saved form attributes " + actualSet);
        List<String> grammarRules = Arrays.asList(new String[] { "v_2 > v_1;", "v_1 OBLIGATORY;", "v_2 OBLIGATORY;",
                "v_3 OBLIGATORY;", "IF v_3 = \"Justified\" THEN v_4 OBLIGATORY;" });
        log.info("Bootstrapping form " + formRepository
                .save(new Form("Absence form", "A form for requesting leave of absence", formAttributes, grammarRules))
                .getName());

    }

    @Transactional
    private void createClientDiscountRequestForm() {
        FormAttribute att1 = new FormAttribute("v_1", "Insert the client's internal code", DataType.STRING,
                "\"[a-zA-z]{3}[0-9]{3}\"");
        FormAttribute att2 = new FormAttribute("v_2", "Insert the name of the client", DataType.STRING, "");
        FormAttribute att3 = new FormAttribute("v_3", "Insert the discount type", DataType.STRING, "");
        FormAttribute att4 = new FormAttribute("v_4", "Insert the recurrence(Unique/Until-limit-date)", DataType.STRING,
                "\"Unique\"|\"Until-limit-date\"");
        FormAttribute att5 = new FormAttribute("v_5", "Insert the discount percentage", DataType.INTEGER, "");
        FormAttribute att6 = new FormAttribute("v_6", "Insert discount value", DataType.INTEGER, "");
        FormAttribute att7 = new FormAttribute("v_7", "Insert the receipt id", DataType.INTEGER, "");
        FormAttribute att8 = new FormAttribute("v_8", "Insert limit date (dd-MM-yyyy)", DataType.DATE, "");
        FormAttribute att9 = new FormAttribute("v_9", "Insert request justification", DataType.STRING, "");
        List<FormAttribute> formAttributes = new ArrayList<>(
                Arrays.asList(att1, att2, att3, att4, att5, att6, att7, att8, att9));
        log.info("Bootstrapping form attributes of client discount request ");
        // Set<FormAttribute> actualSet = new
        // LinkedHashSet<>(attRepository.saveAll(formAttributes));
        // log.info("Saved form attributes " + actualSet);

        List<String> grammarRules = Arrays.asList(new String[] { "v_1 OBLIGATORY;", "v_2 OBLIGATORY;",
                "v_3 OBLIGATORY;", "v_4 OBLIGATORY;", "v_9 OBLIGATORY;", "v_5 OBLIGATORY;", "v_6 OBLIGATORY;",
                "IF v_5 = 0 THEN v_6 OBLIGATORY;", "IF v_6 = 0 THEN v_5 OBLIGATORY;" ,"IF v_4 = \"Unique\" THEN v_7 OBLIGATORY;","IF v_4 = \"Until-limit-date\" THEN v_8 OBLIGATORY;"});
        log.info("Bootstrapping form " + formRepository
                .save(new Form("Authorization for applying a discount", "For requesting authorization for applying a discount", formAttributes, grammarRules))
                .getName());

    }

}
