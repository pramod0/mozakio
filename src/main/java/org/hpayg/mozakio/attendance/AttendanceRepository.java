package org.hpayg.mozakio.attendance;

import java.util.List;

import org.hpayg.mozakio.youth.Youth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

	@Query("select a from Attendance a where a.youth.id = :id")
	List<Attendance> getAttendanceByYouthId(@Param("id") Integer id);

	@Query("select a from Attendance a where a.wfEvent.id = :id")
	List<Attendance> getAttendanceByWFEId(@Param("id") Integer id);

	@Query("select a.youth youth_id from Attendance a where a.wfEvent.id = :id")
	List<Youth> getYouthListByEventId(@Param("id") Integer id);


}
