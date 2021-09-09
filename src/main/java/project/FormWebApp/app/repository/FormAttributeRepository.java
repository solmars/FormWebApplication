/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.FormWebApp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.FormWebApp.app.domain.form.FormAttribute;

/**
 *
 * @author Daniel Carvalho
 */
@Repository
public interface FormAttributeRepository extends JpaRepository<FormAttribute,Long> {
    
}
