/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app.repository;

/**
 *
 * @author Daniel Carvalho
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.FormWebApp.app.domain.form.Form;

@Repository
public interface FormRepository extends JpaRepository<Form,Long> {
    
}
