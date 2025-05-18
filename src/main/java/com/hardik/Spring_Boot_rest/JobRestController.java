package com.hardik.Spring_Boot_rest;

import com.hardik.Spring_Boot_rest.model.JobPost;
import com.hardik.Spring_Boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class JobRestController {

	@Autowired
	private JobService service;
	
	@GetMapping(path = "jobPosts", produces = "application/json")
	@ResponseBody
	public List<JobPost> getAllJobs(){
		return service.getAllJobs();
	}
	
	
	@GetMapping("jobPosts/Keyword/{Keyword}")
	public List<JobPost> searchByKeyword(@PathVariable String Keyword){
		return service.search(Keyword);
	}
	
	
	@GetMapping("jobPost/{PostId}")
	@ResponseBody
	public JobPost getJob(@PathVariable("PostId") int PostId){
		
		return service.getJob(PostId);
	}
	
//	@PostMapping("jobPost")
//	public JobPost addJob(@RequestBody JobPost jobpost){
//		 service.addJob(jobpost);
//		 return  jobpost;
//	}
	
	
	// adding object then fetching it from source
	@PostMapping(path = "jobPost", consumes = {"application/xml"})
	public JobPost addJob(@RequestBody JobPost jobpost){
		service.addJob(jobpost);
		return service.getJob(jobpost.getPostID());
	}
	
	@PutMapping("jobPost")
	public JobPost updatejob(@RequestBody JobPost jobpost){
		 service.updateJob(jobpost);
		 return service.getJob(jobpost.getPostID());
	}
	
	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable  int postId){
		service.deleteJob(postId);
		return "Deleted";
	}
	
	@GetMapping("load")
	public String load(){
		service.load();
		
		return " success";
	}
}

