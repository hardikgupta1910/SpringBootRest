package com.hardik.Spring_Boot_rest.service;


import com.hardik.Spring_Boot_rest.model.JobPost;
import com.hardik.Spring_Boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
	
	
	
	
	@Autowired
	private JobRepo repo;
	
	
	public void addJob(JobPost jobpost){
		 repo.save(jobpost);  // this kind of object(jobpost) is called DTO data transfer object as thee are getting transferred between different layers from eg jobpost is being transferred between model then service then repo
	}

	public List<JobPost> getAllJobs(){
		return	repo.findAll();
	}
	
	public JobPost getJob(int PostId) {
//		int num=10/0;
		return repo.findById(PostId).orElse(new JobPost());
	}
	
	public void updateJob(JobPost jobpost) {
		 repo.save(jobpost);
	}
	
	public void deleteJob(int postId) {
		 repo.deleteById(postId);
	}
	
	public void load() {
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
		repo.saveAll(jobs);
	}
	
	
	public List<JobPost> search(String Keyword) {
	 return  repo.findByPostProfileContainingOrPostDescContaining(Keyword,Keyword);
	}
}
