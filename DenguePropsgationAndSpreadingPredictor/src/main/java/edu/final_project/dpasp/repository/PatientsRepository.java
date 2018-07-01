/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.final_project.dpasp.repository;

import edu.final_project.dpasp.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kalum
 */
public interface PatientsRepository extends JpaRepository<Patients, Integer>{
    
}
