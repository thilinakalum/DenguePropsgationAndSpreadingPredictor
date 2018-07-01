/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fyp.denguepropagationandspreadpredictor.service;

import edu.fyp.denguepropagationandspreadpredictor.entity.Moh;
import edu.fyp.denguepropagationandspreadpredictor.repository.MohRepository;
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
public class MohService {

    @Autowired
    private MohRepository mohRepository;
    
    public List<Moh> findAllMohbyDistrict(Integer district) {
        return mohRepository.findByFkDistrict(district);
    }
    
}
