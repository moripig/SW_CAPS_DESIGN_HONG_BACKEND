package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Board;
import net.skhu.entity.Comment;
import net.skhu.entity.Member;
import net.skhu.repository.BoardRepository;
import net.skhu.repository.CommentRepository;
import net.skhu.repository.MemberRepository;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	CommentRepository commentRepository;

	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("members", memberRepository.findAll());
		model.addAttribute("boards", boardRepository.findAll());
		return "board/list";
	}
	@GetMapping("content")
	public String content(Model model,@RequestParam("idx") int idx) {
		Board board = boardRepository.findById(idx).get();
		List<Comment> comments = commentRepository.findAll();
		model.addAttribute("board",board);
		model.addAttribute("comments",comments);
		return "board/content";
	}
	@PostMapping("content")
	public String content(Model model, Comment comment) {
		commentRepository.save(comment);
		return "redirect:content";
	}

	@GetMapping("create")
	public String create(Model model,@RequestParam("idx") int idx) {
		Board board = new Board();
		Member member = memberRepository.findById(idx).get();
		board.setMember(member);
		model.addAttribute("member",member);
		model.addAttribute("board",board);
		return "board/edit";
	}

	@PostMapping("create")
	public String create(Model model, Board board) {
		boardRepository.save(board);
		return "redirect:list";
	}

	@GetMapping("edit")
	public String edit(Model model, @RequestParam("idx") int idx) {
		Board board = boardRepository.findById(idx).get();
		model.addAttribute("board", board);
		model.addAttribute("member",board.getMember());
		return "board/edit";
	}

	@PostMapping("edit")
	public String edit(Model model, Board board) {
		boardRepository.save(board);
		return "redirect:list";
	}

	@RequestMapping("delete")
	public String delete(Model model, @RequestParam("idx") int idx) {
		boardRepository.deleteById(idx);
		return "redirect:list";
	}

}
