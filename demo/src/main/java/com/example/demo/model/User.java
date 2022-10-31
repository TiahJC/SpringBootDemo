package com.example.demo.model;



import javax.persistence.*;


@Entity
@Table(name = "employee")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long employee_id;

  @Column(name = "employee_name")
  private String employee_name;

  @Column(name = "employee_pw")
  private String employee_pw;

  @Column(name = "employee_group")
  private String employee_group;

  public User(){

  }

  public User(String employee_name, String employee_pw, String employee_group){
    this.employee_name = employee_name;
    this.employee_pw = employee_pw;
    this.employee_group = employee_group;
  }
  public Long getId(){
    return employee_id;
  }

  public String getEmployeeName(){
    return employee_name;
  }
  public void setEmployeeName(String employee_name){
    this.employee_name = employee_name;
  }

  public String getEmpPwd(){
    return employee_pw;
  }
  public void setEmpPwd(String employee_pw){
    this.employee_pw = employee_pw;
  }

  public String getEmpStatus(){
    return employee_group;
  }
  public void setEmpStatus(String employee_group){
    this.employee_group = employee_group;
  }

  public String toString(){
    return "Tutorial [employee_id=" + employee_id + ", empname=" + employee_name + ", group=" + employee_group +"]"; 
  }
}
