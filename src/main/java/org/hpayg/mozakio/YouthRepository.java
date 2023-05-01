package org.hpayg.mozakio;

import java.util.List;

import org.hpayg.mozakio.models.Youth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface YouthRepository extends JpaRepository<Youth, Integer> {
	
	@Query("select a from Youth a where a.userid = :userId")
    Youth findAllWithFilteredUserId(@Param("userId") Integer userId);
	

}
