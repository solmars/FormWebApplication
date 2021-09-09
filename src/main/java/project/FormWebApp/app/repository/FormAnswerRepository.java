/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import project.FormWebApp.app.domain.form.FormAnswer;

/**
 *
 * @author Daniel Carvalho
 */
public interface FormAnswerRepository extends JpaRepository<FormAnswer, Long> {
}
