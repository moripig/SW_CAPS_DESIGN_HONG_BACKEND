package net.skhu.entity;

import java.util.Date;

import javax.persistence.Column;
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
   @Column(name = "sche_idx")
   int idx;

   @Column(name = "sche_start")
   Date start;

   @Column(name = "sche_end")
   Date end;

   @Column(name = "sche_loca")
   String loca;

   @Column(name = "sche_num")
   int num;

   @ManyToOne
   @JoinColumn(name = "memberId", referencedColumnName="mem_idx")
   Member member;



}