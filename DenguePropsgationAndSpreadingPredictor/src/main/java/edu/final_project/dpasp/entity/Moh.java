/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.final_project.dpasp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author kalum
 */
@Entity
@Table(name = "moh")
public class Moh implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "index_no")
    private Integer indexNo;
    
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    
    @Column(name = "total_population")
    private Integer totalPopulation;
    
//    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @Column(name = "fk_district")
    private Integer fkDistrict;
    
//    @OneToMany(mappedBy = "fkMoh", fetch = FetchType.EAGER)
//    private List<Patients> patientsList;
//    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkMoh", fetch = FetchType.EAGER)
//    private List<MohPatientsDetails> mohPatientsDetailsList;

    public Moh() {
    }

    public Moh(Integer indexNo) {
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

    public Integer getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(Integer totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public Integer getFkDistrict() {
        return fkDistrict;
    }

    public void setFkDistrict(Integer fkDistrict) {
        this.fkDistrict = fkDistrict;
    }

}
