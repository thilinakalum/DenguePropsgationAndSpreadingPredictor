/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.final_project.dpasp.repository;

import edu.final_project.dpasp.entity.Moh;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kalum
 */
public interface MohRepository extends JpaRepository<Moh, Integer>{

    public List<Moh> findByFkDistrict(Integer district);
    
}
