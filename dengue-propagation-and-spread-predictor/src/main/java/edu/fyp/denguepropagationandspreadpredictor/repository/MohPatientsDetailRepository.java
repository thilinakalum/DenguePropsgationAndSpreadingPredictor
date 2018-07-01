/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fyp.denguepropagationandspreadpredictor.repository;

import edu.fyp.denguepropagationandspreadpredictor.entity.MohPatientsDetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author sandunika
 */
public interface MohPatientsDetailRepository extends JpaRepository<MohPatientsDetails, Integer> {

    @Query(value = "select moh.name,\n"
            + " moh_patients_details.patients_per_this_week, \n"
            + " moh_patients_details.patients_per_last_week \n"
            + "	from moh_patients_details \n"
            + "	left join moh on moh.index_no = moh_patients_details.fk_moh \n"
            + "	where moh.fk_district = :districts \n"
            + "	and (Date(moh_patients_details.month) = DATE(:month) or DATE(:month) is null) \n"
            + "	and moh_patients_details.week = :week ", nativeQuery = true)
    public List<Object[]> findByDistrictAndDateRange(@Param("districts") Integer districts, @Param("month") String month, @Param("week") Integer week);

    @Query(value = "select moh.name, \n"
            + " sum(moh_patients_details.patients_per_this_week)as this_week\n"
            + " from moh_patients_details\n"
            + " left join moh on moh.index_no = moh_patients_details.fk_moh \n"
            + " where moh.fk_district = :districts \n"
            + "	and (Date(moh_patients_details.month) = DATE(:month) or DATE(:month) is null) \n"
            + " group by moh.name", nativeQuery = true)
    public List<Object[]> findByDistrictAndDateRange(@Param("districts") Integer districts, @Param("month") String month);

    @Query(value = "select sum(moh_patients_details.patients_per_this_week) as patient\n"
            + "from moh_patients_details\n"
            + "left join moh on moh.index_no = moh_patients_details.fk_moh \n"
            + "where moh.fk_district = :districts \n"
            + "and moh_patients_details.fk_moh = :moh \n"
            + "and moh_patients_details.month <= :date", nativeQuery = true)
    public Integer getPatientsCount(@Param("districts") Integer districts, @Param("moh") Integer moh, @Param("date") String date);

    @Query(value = "select sum(moh.total_population)as tot\n"
            + "from moh\n"
            + "left join districts on districts.index_no = moh.fk_district \n"
            + "where moh.fk_district = :districts \n"
            + "and moh.index_no = :moh ", nativeQuery = true)
    public Integer getPopulationCount(@Param("districts") Integer districts, @Param("moh") Integer moh);

    @Query(value = "select count(gps.fk_petients)\n"
            + "from gps\n"
            + "where gps.date >= :date \n"
            + "and gps.fk_change_moh = :moh ", nativeQuery = true)
    public Integer changeGpsCount(@Param("moh") Integer moh, @Param("date") String date);
}
