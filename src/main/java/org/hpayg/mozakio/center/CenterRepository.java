package org.hpayg.mozakio.center;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CenterRepository extends JpaRepository<Center, Integer>{

	@Query("select a from Center a where a.id = :id")
	Center findCenter(@Param("id") Integer id);


}
