package com.hardik.Spring_Boot_rest.repo;


import com.hardik.Spring_Boot_rest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {
	
	List<JobPost> jobs=new ArrayList<>(Arrays.asList(
			new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
					List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
			
			
			new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
					List.of("HTML", "CSS", "JavaScript", "React")),
			
			
			new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
					List.of("Python", "Machine Learning", "Data Analysis")),
			
			
			new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
					List.of("Networking", "Cisco", "Routing", "Switching")),
			
			
			new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
					List.of("iOS Development", "Android Development", "Mobile App"))
			
	));
	
	public List<JobPost> getAllJobs(){
		return jobs;
	}
	
	 public void addJob(JobPost job){
		jobs.add(job);
		 System.out.println(jobs);
	 }
	
	public JobPost getJob(int PostId) {
		for(JobPost job:jobs){
			if(job.getPostID()==PostId){
				return job;
			}
		}
		return null;
	}
	
	public void updateJob(JobPost jobpost) {
		for(JobPost jobpost1:jobs){
			if(jobpost1.getPostID()==jobpost.getPostID()){
				jobpost1.setPostDesc(jobpost.getPostDesc());
				jobpost1.setPostID(jobpost.getPostID());
				jobpost1.setPostProfile(jobpost.getPostProfile());
				jobpost1.setPostTechStack(jobpost.getPostTechStack());
				jobpost1.setReqExperience(jobpost.getReqExperience());
			}
		}
	}
	
	public void deleteJob(int postId) {
	  for(JobPost jobPost:jobs){
		  if(jobPost.getPostID()==postId){
			  jobs.remove(jobPost);
		  }
	  }
	}
}
// In future if you want to use a database you will only change
// this class, Other classes have no idea what you are doing and this
//class is responsible to fetch data from database or some other server
// or maybe from a file