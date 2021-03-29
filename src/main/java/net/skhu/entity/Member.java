package net.skhu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   int mem_idx;

   String mem_userid;
   String mem_email;
   String mem_password;
   String mem_username;
   int mem_gender;
   String mem_address;

}