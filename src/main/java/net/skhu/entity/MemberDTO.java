package net.skhu.entity;

import java.util.List;

import lombok.Data;

@Data
public class MemberDTO {

	private int mem_idx;

	private String mem_userid;
	private String mem_email;
	private String mem_password;
	private String mem_username;
	private int mem_gender;
	private String mem_address;
	private List<Schedule> schedules;
	private List<Board> boards;

	private List<String> roles;
}