package com.hardik.Spring_Boot_rest.repo;


import com.hardik.Spring_Boot_rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

	User findByUsername(String username);
}
