/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fyp.denguepropagationandspreadpredictor.controller;

import edu.fyp.denguepropagationandspreadpredictor.entity.Patients;
import edu.fyp.denguepropagationandspreadpredictor.service.PatientsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sandunika
 */
@RestController
@CrossOrigin
@RequestMapping("/api/final-project/dpasp/patients")
public class PatientsController {
    
    @Autowired
    private PatientsService patiensService;
    
    @RequestMapping(value = "/find-all-patients", method = RequestMethod.GET)
    public List<Patients> findAllPatients() {
        return patiensService.findAllPatients();
    }
    
}
