package com.jr.fleet.main.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FleetRepo extends JpaRepository<Cars, Long> {
	
	 @Query(value = "SELECT * from cars WHERE d_engine_size = ?1", nativeQuery = true)
	    List<Cars> findByEngineSize(int engineSize);
	 
	 @Query(value = "SELECT * from cars WHERE b_model = ?1", nativeQuery = true)
	 	List<Cars> findByModel(String str);
	 
	 @Query("SELECT c from Cars c WHERE c.make = ?1")
	    List<Cars> findByMake(String str);
	 
//	 @Query(value = "SELECT * from cars WHERE a_make = ?1", nativeQuery = true)
//	 	List<Cars> findByMake(String makeName);


}
