package org.hpayg.mozakio.attendance;

import java.util.List;

import org.hpayg.mozakio.center.CenterRepository;
import org.hpayg.mozakio.weeklyForumEvent.WeeklyForumEvent;
import org.hpayg.mozakio.weeklyForumEvent.WeeklyForumEventRepository;
import org.hpayg.mozakio.youth.Youth;
import org.hpayg.mozakio.youth.YouthRepository;
import org.hpayg.mozakio.youth.YouthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
	@Autowired
	AttendanceRepository attendanceRepo;
	
	@Autowired
	CenterRepository centerRepository;
	
	@Autowired
	YouthRepository youthRepository;
	
	@Autowired
	WeeklyForumEventRepository wfeRepo;
	
	@Autowired
	YouthService youthService;
	
	public List<Attendance> getAttendances(){
		centerRepository.findAll();
		wfeRepo.findAll();
		youthRepository.findAll();
		return attendanceRepo.findAll();
	}

	public Attendance markAttendance(Attendance attendance) {
		return attendanceRepo.save(attendance);
	}

	public List<Attendance> getAttendanceByYouthId(Integer youth_id) {
		// Youth youth = youthRepository.findAllWithFilteredUserId(youth_id);
		Youth youth = youthService.getConditionalYouth(youth_id);
		centerRepository.findAll();
		wfeRepo.findAll();
		
		return attendanceRepo.getAttendanceByYouthId(youth_id);
	}
	
	
}
