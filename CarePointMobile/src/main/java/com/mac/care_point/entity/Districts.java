/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.entity;

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
@Table(name = "districts")
public class Districts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "index_no")
    private Integer indexNo;
    
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    
    @Column(name = "no_of_moh")
    private Integer noOfMoh;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkDistrict", fetch = FetchType.EAGER)
//    private List<Moh> mohList;
    
//    @OneToMany(mappedBy = "fkDistrict", fetch = FetchType.EAGER)
//    private List<User> userList;

    public Districts() {
    }

    public Districts(Integer indexNo) {
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

    public Integer getNoOfMoh() {
        return noOfMoh;
    }

    public void setNoOfMoh(Integer noOfMoh) {
        this.noOfMoh = noOfMoh;
    }
}
