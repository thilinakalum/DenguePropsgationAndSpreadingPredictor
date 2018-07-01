/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fyp.denguepropagationandspreadpredictor.service;


import edu.fyp.denguepropagationandspreadpredictor.entity.Patients;
import edu.fyp.denguepropagationandspreadpredictor.repository.PatientsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sandunika
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PatientsService {

    @Autowired
    private PatientsRepository patiensRepository;
    
    public List<Patients> findAllPatients() {
       return patiensRepository.findAll();
    }
    
}
