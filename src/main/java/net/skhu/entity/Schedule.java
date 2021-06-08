package net.skhu.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Schedule {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int sche_idx;

   Date sche_start;
   Date sche_end;
   String sche_loca;
   int sche_num;

   @ManyToOne
   @JoinColumn(name = "memberId", referencedColumnName="mem_idx")
   Member member;



}