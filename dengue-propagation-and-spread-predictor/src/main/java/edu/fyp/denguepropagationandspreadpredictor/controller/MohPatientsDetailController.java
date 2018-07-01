/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fyp.denguepropagationandspreadpredictor.controller;

import edu.fyp.denguepropagationandspreadpredictor.service.MohPatientsDetailService;
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
@RequestMapping("/api/final-project/dpasp/moh-patients-details")
public class MohPatientsDetailController {

    @Autowired
    private MohPatientsDetailService mohPatientsDetailService;

    @RequestMapping(value = "/find-by-district-and-dates/{districts}/{month}/{week}", method = RequestMethod.GET)
    public List<Object[]> findByDistrictAndDateRange(@PathVariable("districts") Integer districts, @PathVariable("month") String month, @PathVariable("week") Integer week) {
        return mohPatientsDetailService.findByDistrictAndDateRange(districts, month, week);
    }

    @RequestMapping(value = "/predict-risk/{districts}/{moh}/{date}", method = RequestMethod.GET)
    public List<Double> predictRisk(@PathVariable("districts") Integer districts,@PathVariable("moh") Integer moh, @PathVariable("date") String date) {
        return mohPatientsDetailService.predictRisk(districts,moh, date);
    }

}
