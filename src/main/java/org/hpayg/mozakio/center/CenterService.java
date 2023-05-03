package org.hpayg.mozakio.center;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterService {
	
	@Autowired
	CenterRepository centerRepo;
	
	public List<Center> getCenters(){
		return centerRepo.findAll();
	}

	public Center setCenter(Center center) {
		return centerRepo.save(center);
	}

	public Center getConditionalCenter(Integer id) {
		return centerRepo.findCenter(id);
	}
}
