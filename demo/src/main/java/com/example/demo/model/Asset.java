package com.example.demo.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "assets")
public class Asset {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long assets_id;

  @Column(name = "assets_sn")
  private String assets_sn;

  @Column(name = "assets_desc")
  private String assets_desc;

  @Column(name = "assets_cd")
  private Date assets_cd;

  @Column(name = "assets_handover")
  private Date assets_handover;
 
  @Column(name = "assets_status")
  private String assets_status;
  
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "assets_empid", referencedColumnName = "employee_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  //  @JsonIgnore
  private User employee;

  public Asset(){

  }

  public Asset(String assets_sn, String assets_desc, Date assets_cd, Date assets_handover, String assets_status, User employee){
    this.assets_sn = assets_sn;
    this.assets_desc = assets_desc;
    this.assets_cd = assets_cd;
    this.assets_handover = assets_handover;
    this.assets_status = assets_status;
    this.employee=employee;
}
  public Long getId(){
    return assets_id;
  }
  public String getSerialNumber(){
    return assets_sn;
  }
  public void setSerialNumber(String assets_sn){
    this.assets_sn = assets_sn;
  }

  public String getDescription(){
    return assets_desc;
  }
  public void setDescription(String assets_desc){
    this.assets_desc = assets_desc;
  }

  public Date getCreateDate(){
    return assets_cd;
  }
  public void setCreateDate(Date assets_cd){
    this.assets_cd = assets_cd;
  }

  public Date getHandoverDate(){
    return assets_handover;
  }
  public void setHandoverDate(Date assets_handover){
    this.assets_handover = assets_handover;
  }

  public String getStatus(){
    return assets_status;
  }
  public void setStatus(String assets_status){
    this.assets_status = assets_status;
  }

  public User getEmployee(){
    return employee;
  }
  public void setEmployee(User employee){
    this.employee=employee;
  }

  public String toString(){
    return "Tutorial [assets_id=" + assets_id + ", serialNo=" + assets_sn + ", desc=" + assets_desc + ", CreatedDate=" + assets_cd + ", HandoverDate=" + assets_handover +", Status=" + assets_status +"]"; 
  }
}

