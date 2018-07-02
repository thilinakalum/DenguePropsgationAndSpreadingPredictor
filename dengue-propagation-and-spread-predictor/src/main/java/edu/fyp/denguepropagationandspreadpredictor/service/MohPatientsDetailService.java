/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fyp.denguepropagationandspreadpredictor.service;

import edu.fyp.denguepropagationandspreadpredictor.repository.MohPatientsDetailRepository;
import java.util.ArrayList;
import java.util.Date;
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
public class MohPatientsDetailService {

    @Autowired
    private MohPatientsDetailRepository mohPatientsDetailRepository;

    public List<Object[]> findByDistrictAndDateRange(Integer districts, String month, Integer week) {
        if (week != 5) {
            return mohPatientsDetailRepository.findByDistrictAndDateRange(districts, month, week);
        } else {
            return mohPatientsDetailRepository.findByDistrictAndDateRange(districts, month);
        }
    }

    public List<Double> predictRisk(Integer districts, Integer moh, String date) {
        List<Double> list = new ArrayList<>();

        Integer noOfPatients = mohPatientsDetailRepository.getPatientsCount(districts, moh, date);
        Integer noOfpopulation = mohPatientsDetailRepository.getPopulationCount(districts, moh);

        Double previousProbability = noOfPatients.doubleValue() / noOfpopulation.doubleValue();
        List<Object[]> changeGpsList = mohPatientsDetailRepository.changeGpsCount(moh, date);
        Integer noOfChangeGpsPatients = 0;
        for (int i = 0; i < changeGpsList.size(); i++) {
            noOfChangeGpsPatients++;
        }
        Double p = previousProbability *(noOfpopulation.doubleValue()+noOfChangeGpsPatients.doubleValue())   + previousProbability * noOfChangeGpsPatients.doubleValue();
        Double Newpopulation = noOfpopulation.doubleValue() + noOfChangeGpsPatients.doubleValue();
        Double currentProbability = p/Newpopulation ;

        Double difference = (currentProbability-previousProbability);
        
        System.out.println("p");
        System.out.println(p);
        System.out.println("Newpopulation");
        System.out.println(Newpopulation);
        System.out.println("noOfPatients");
        System.out.println(noOfPatients);
        System.out.println("noOfpopulation");
        System.out.println(noOfpopulation);
        
        list.add(previousProbability);
        list.add(currentProbability);
        list.add(difference);
        System.out.println("noOfChangeGpsPatients");
        System.out.println(noOfChangeGpsPatients);
        System.out.println("previousProbability");
        System.out.println(previousProbability);
        System.out.println("currentProbability");
        System.out.println(currentProbability);
        return list;
    }
}
