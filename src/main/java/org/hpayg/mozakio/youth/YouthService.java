package org.hpayg.mozakio.youth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YouthService {
	
	@Autowired
	private YouthRepository youthRepo;
	
	public List<Youth> getYouths(){
        List<Youth> youths = youthRepo.findAll();        
        return youths;
    }
	
	public Youth setYouth(Youth youth) {
		return youthRepo.save(youth);
		
	}
	
	public Youth getConditionalYouth(Integer userId){
        return youthRepo.findAllWithFilteredUserId(userId);
    }

}
