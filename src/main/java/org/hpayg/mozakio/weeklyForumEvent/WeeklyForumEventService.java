package org.hpayg.mozakio.weeklyForumEvent;

import java.util.List;

import org.hibernate.Hibernate;
import org.hpayg.mozakio.center.Center;
import org.hpayg.mozakio.center.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeeklyForumEventService {
	
	@Autowired
	WeeklyForumEventRepository wfeRepo;
	
	@Autowired
    CenterRepository centerRepository;

	public List<WeeklyForumEvent> getWFEvents() {
		List<Center> allCenters = centerRepository.findAll();
		
		
		List<WeeklyForumEvent> wfEvents = wfeRepo.findAll();
        for (WeeklyForumEvent wfEvent : wfEvents) {
            Center center = wfEvent.getCenter();
            if (center != null && !Hibernate.isInitialized(center)) {
                center = centerRepository.getOne(center.getId());
                wfEvent.setCenter(center);
            }
        }
        return wfEvents;
	}

	public WeeklyForumEvent save(WeeklyForumEvent wfEvent) {
		return wfeRepo.save(wfEvent);
	}

}
