package net.skhu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comm_idx")
	int idx;

	@Column(name = "comm_content")
	String content;

	@Column(name = "comm_date")
	String date;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "boardId")
	Board board;

	@ManyToOne
	@JoinColumn(name = "memberId")
	Member member;

}