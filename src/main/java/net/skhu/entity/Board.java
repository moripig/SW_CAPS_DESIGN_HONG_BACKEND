package net.skhu.entity;

import java.util.List;

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
	int board_idx;

	String board_title;
	String board_content;
	String board_date;


	@ManyToOne
	@JoinColumn(name = "memberId", referencedColumnName = "mem_idx")
	Member member;

	@OneToMany(mappedBy="board",fetch = FetchType.LAZY)
	List<Comment> comments;


}
