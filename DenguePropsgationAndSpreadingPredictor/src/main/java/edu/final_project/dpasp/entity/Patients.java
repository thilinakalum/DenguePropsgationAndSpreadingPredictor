/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.final_project.dpasp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author kalum
 */
@Entity
@Table(name = "patients")
public class Patients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "index_no")
    private Integer indexNo;

    @Size(max = 50)
    @Column(name = "name")
    private String name;

    @Size(max = 500)
    @Column(name = "address")
    private String address;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Size(max = 50)
    @Column(name = "current_gps")
    private String currentGps;

//    @JoinColumn(name = "fk_moh", referencedColumnName = "index_no")
//    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "fk_moh")
    private Integer fkMoh;

    public Patients() {
    }

    public Patients(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCurrentGps() {
        return currentGps;
    }

    public void setCurrentGps(String currentGps) {
        this.currentGps = currentGps;
    }

    public Integer getFkMoh() {
        return fkMoh;
    }

    public void setFkMoh(Integer fkMoh) {
        this.fkMoh = fkMoh;
    }

}
