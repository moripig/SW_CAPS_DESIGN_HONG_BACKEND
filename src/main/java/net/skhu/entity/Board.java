package net.skhu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_idx")
	int idx;

	@Column(name = "board_title")
	String title;

	@Column(name = "board_content")
	String content;

	@Column(name = "board_date")
	String date;


	@ManyToOne
	@JoinColumn(name = "memberId", referencedColumnName = "mem_idx")
	Member member;

	@OneToMany(mappedBy="board",fetch = FetchType.LAZY)
	List<Comment> comments;


}
