/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fyp.denguepropagationandspreadpredictor.repository;

import edu.fyp.denguepropagationandspreadpredictor.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sandunika
 */
public interface PatientsRepository extends JpaRepository<Patients, Integer>{
    
}
