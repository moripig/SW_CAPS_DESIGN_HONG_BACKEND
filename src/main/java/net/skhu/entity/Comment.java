package net.skhu.entity;

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
	int comm_idx;

	String comm_content;
	String comm_date;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "boardId")
	Board board;

	@ManyToOne
	@JoinColumn(name = "memberId")
	Member member;

}