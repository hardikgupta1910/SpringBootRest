package com.hardik.Spring_Boot_rest.service;


import com.hardik.Spring_Boot_rest.model.JobPost;
import com.hardik.Spring_Boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
	
	@Autowired
	private JobRepo repo;
	
	
	public void addJob(JobPost jobpost){
		 repo.addJob(jobpost);  // this kind of object(jobpost) is called DTO data transfer object as thee are getting transferred between different layers from eg jobpost is being transferred between model then service then repo
	}

	public List<JobPost> getAllJobs(){
		return	repo.getAllJobs();
	}
	
	public JobPost getJob(int PostId) {
		return repo.getJob(PostId);
	}
	
	public void updateJob(JobPost jobpost) {
		 repo.updateJob(jobpost);
	}
	
	public void deleteJob(int postId) {
		 repo.deleteJob( postId);
	}

//	public void setJob(JobPost job) {
//
//		this.job = job;
//	}
}
