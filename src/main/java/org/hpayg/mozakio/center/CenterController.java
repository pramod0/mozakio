package org.hpayg.mozakio.center;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/mozakio")
public class CenterController {
	
	@Autowired
	CenterService centerService;

	@GetMapping("allCenters")
	public List<Center> getCenters(){
		return centerService.getCenters();		
	}
	
	@GetMapping("center/{id}")
	public Center getCenter(@PathVariable Integer id) {
		return centerService.getCenterById(id);
	}
	
	@PostMapping("createCenter")
	public Center registerCenter(@RequestBody Center center) {
		return centerService.setCenter(center);
	}
}
