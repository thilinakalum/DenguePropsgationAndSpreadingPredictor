/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fyp.denguepropagationandspreadpredictor.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sandunika
 */
@Entity
@Table(name = "moh_patients_details")
public class MohPatientsDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "index_no")
    private Integer indexNo;

    @Column(name = "patients_per_this_week")
    private Integer patientsPerThisWeek;
    
    @Column(name = "patients_per_last_week")
    private Integer patientsPerLastWeek;

    @Column(name = "probability")
    private Float probability;

    @Column(name = "month")
    private Date month;

    @Column(name = "week")
    private Integer week;

    @Column(name = "fk_moh")
    private Integer fkMoh;

    public MohPatientsDetails() {
    }

    public MohPatientsDetails(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public Float getProbability() {
        return probability;
    }

    public void setProbability(Float probability) {
        this.probability = probability;
    }
    public Integer getFkMoh() {
        return fkMoh;
    }

    public void setFkMoh(Integer fkMoh) {
        this.fkMoh = fkMoh;
    }

    public Integer getPatientsPerThisWeek() {
        return patientsPerThisWeek;
    }

    public void setPatientsPerThisWeek(Integer patientsPerThisWeek) {
        this.patientsPerThisWeek = patientsPerThisWeek;
    }

    public Integer getPatientsPerLastWeek() {
        return patientsPerLastWeek;
    }

    public void setPatientsPerLastWeek(Integer patientsPerLastWeek) {
        this.patientsPerLastWeek = patientsPerLastWeek;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

}
