package net.skhu.entity;

import java.util.List;

import javax.persistence.CascadeType;
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
   int mem_idx;

   String mem_userid;
   String mem_email;
   String mem_password;
   String mem_username;
   int mem_gender;
   String mem_address;

   @OneToMany(mappedBy="member",cascade=CascadeType.ALL)
   List<Schedule> schedules;

   @OneToMany(mappedBy="member",cascade=CascadeType.ALL)
   List<Board> boards;
}