package org.hpayg.mozakio.weeklyForumEvent;

import java.util.List;

import org.hpayg.mozakio.center.Center;
import org.hpayg.mozakio.center.CenterService;
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
public class WeeklyForumEventController {
	
	@Autowired
	WeeklyForumEventService	wfeService;
	
	@Autowired
	CenterService centerService;
	
	@GetMapping("allWFEvents")
	public List<WeeklyForumEvent> getEvents(){
		return wfeService.getWFEvents();		
	}
	
	@PostMapping("createWFEvent")
	public WeeklyForumEvent createEvent(@RequestBody WeeklyForumEvent wfEvent,Integer centerId) {
		Center center = centerService.getCenterById(centerId);
	    wfEvent.setCenter(center);
	    return wfeService.save(wfEvent);
	}
	
}
