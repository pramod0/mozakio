package org.hpayg.mozakio.youth;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/mozakio")
public class YouthController {
	@Autowired
    private YouthService youthService;

	
    @GetMapping("/allYouths")
    @ResponseBody()
    public List<Youth> getAllYouths(){
        List<Youth> youths =  youthService.getYouths();       
        return youths;
    }
    
    @GetMapping("/filter")
    @ResponseBody()
    public Youth getYouthWithCondition(@RequestParam Integer userId){
        return youthService.getConditionalYouth(userId);
    }
    
    @GetMapping("/youth/{id}")
    @ResponseBody()
    public Youth getYouth(@PathVariable("id") Integer id){
        return youthService.getConditionalYouth(id);
    }
    
    @PostMapping("/registerYouth")    
    public Youth registerYouth(@RequestBody Youth youth) {
    	System.out.println(youth);
    	Youth y =  youthService.setYouth(youth);
    	if(y == null) return null;
    	
    	return y;
    }
}