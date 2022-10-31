package com.example.demo.controller;
import java.util.List;


// import org.apache.commons.lang3.time.DateUtils;
// import java.time.LocalDate;
// import java.time.ZoneId;
// import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.exception.ResourceNotFoundException;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")
public class userController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/users")
  public List<User> getAllUsers(){
    return userRepository.findAll();
  }

  @PostMapping("/userspost")
  public User createUser(@RequestBody User employee){
    return userRepository.save(employee);
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<User> getUserbyid(@PathVariable Long id){
    User employee = userRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("asset not exist with id"+ id));
    return ResponseEntity.ok(employee);
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
    User employee = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("asset not exist with id"+ id));
    
    employee.setEmployeeName(userDetails.getEmployeeName());
    employee.setEmpPwd(userDetails.getEmpPwd());
    employee.setEmpStatus(userDetails.getEmpStatus());

    User updatedUser = userRepository.save(employee);
    return ResponseEntity.ok(updatedUser);
  }
}
