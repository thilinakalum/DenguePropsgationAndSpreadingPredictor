/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.repository;

import com.mac.care_point.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kalum
 */
public interface PatientsRepository extends JpaRepository<Patients, Integer>{
    
}
