
package com.excel.demo.repository;

import java.util.List;
import com.excel.demo.model.TelecomAdSpend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeleComRepository extends JpaRepository<TelecomAdSpend, Integer>{
    
    @Query(value="Select json_string from telecom_ad_spend",nativeQuery = true)
    List<Object> findAllJsons();
   
}
