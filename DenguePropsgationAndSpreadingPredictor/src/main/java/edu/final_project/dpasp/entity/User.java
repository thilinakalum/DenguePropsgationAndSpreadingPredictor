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
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "index_no")
    private Integer indexNo;
    
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;
    
    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;
    
    @Size(max = 50)
    @Column(name = "user_name")
    private String userName;
    
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    
    @Size(max = 50)
    @Column(name = "mobile")
    private String mobile;
    
//    @JoinColumn(name = "fk_district", referencedColumnName = "index_no")
//    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "fk_district")
    private Integer fkDistrict;
    
    public User() {
    }

    public User(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getFkDistrict() {
        return fkDistrict;
    }

    public void setFkDistrict(Integer fkDistrict) {
        this.fkDistrict = fkDistrict;
    }
    
}
