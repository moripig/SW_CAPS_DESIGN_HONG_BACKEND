package net.skhu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Member {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "mem_idx")
   int idx;

   @Column(name = "mem_userid")
   String userid;

   @Column(name = "mem_email")
   String email;

   @Column(name = "mem_password")
   String password;

   @Column(name = "mem_username")
   String username;

   @Column(name = "mem_gender")
   int gender;

   @Column(name = "mem_address")
   String address;

   @OneToMany(mappedBy="member")
   List<Schedule> schedules;
}