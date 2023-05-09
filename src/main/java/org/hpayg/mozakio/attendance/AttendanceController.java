package org.hpayg.mozakio.attendance;

import java.util.List;
import java.util.Optional;

import org.hpayg.mozakio.weeklyForumEvent.WeeklyForumEvent;
import org.hpayg.mozakio.weeklyForumEvent.WeeklyForumEventService;
import org.hpayg.mozakio.youth.Youth;
import org.hpayg.mozakio.youth.YouthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/mozakio")
public class AttendanceController {
	
	@Autowired
	AttendanceService attendanceService;
	
	@Autowired
	YouthService youthService;
	
	@Autowired
	WeeklyForumEventService wfeService;
	
	@GetMapping("/attendances")
	public List<Attendance> getAllAttendances(){
		return attendanceService.getAttendances();
	}
	
	@PostMapping("/markAttendance")
	public Attendance markAttendance(@RequestBody Attendance attendance, 
			@RequestParam("youth_id") Integer youth_id,
			@RequestParam("weekly_forum_event_id") Integer weekly_forum_event_id) {
		
		Youth youth = youthService.getConditionalYouth(youth_id);
		WeeklyForumEvent wfEvent = wfeService.getWFEventById(weekly_forum_event_id);
		
		attendance.setYouth(youth);
		attendance.setWfEvent(wfEvent);
		return attendanceService.markAttendance(attendance);
	}
}
