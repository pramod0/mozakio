package org.hpayg.mozakio.attendance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
	@Autowired
	AttendanceRepository attendanceRepo;
	
	public List<Attendance> getAttendances(){
		return attendanceRepo.findAll();
	}

	public Attendance markAttendance(Attendance attendance) {
		return attendanceRepo.save(attendance);
	}
	
	
}
