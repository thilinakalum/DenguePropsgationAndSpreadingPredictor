/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fyp.denguepropagationandspreadpredictor.controller;

import edu.fyp.denguepropagationandspreadpredictor.entity.Moh;
import edu.fyp.denguepropagationandspreadpredictor.service.MohService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sandunika
 */
@RestController
@CrossOrigin
@RequestMapping("/api/final-project/dpasp/moh")
public class MohController {
    @Autowired
    private MohService mohService;
            
    @RequestMapping(value = "/find-moh-by-districts/{district}", method = RequestMethod.GET)
    public List<Moh> findAllMohbyDistrict(@PathVariable Integer district) {
        return mohService.findAllMohbyDistrict(district);
    }
    
}
