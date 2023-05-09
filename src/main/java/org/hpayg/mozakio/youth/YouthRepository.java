package org.hpayg.mozakio.youth;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface YouthRepository extends JpaRepository<Youth, Integer> {
	
	@Query("select a from Youth a where a.id = :id")
    Youth findAllWithFilteredUserId(@Param("id") Integer userId);
	

}
