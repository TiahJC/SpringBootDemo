package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  
  // List<User> findbyName(String employee_name);
  // List<User> findbyGroup(String employee_group);
}



// package com.bezkoder.spring.jpa.postgresql.repository;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;

// import com.bezkoder.spring.jpa.postgresql.model.Tutorial;

// public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
//   List<Tutorial> findByPublished(boolean published);

//   List<Tutorial> findByTitleContaining(String title);
// }