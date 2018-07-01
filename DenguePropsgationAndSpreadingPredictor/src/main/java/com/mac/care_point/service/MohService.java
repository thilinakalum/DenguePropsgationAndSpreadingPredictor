/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.service;

import com.mac.care_point.entity.Moh;
import com.mac.care_point.repository.MohRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kalum
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
