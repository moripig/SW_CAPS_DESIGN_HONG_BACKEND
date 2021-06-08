package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Board;
import net.skhu.entity.Comment;
import net.skhu.repository.BoardRepository;
import net.skhu.repository.CommentRepository;
import net.skhu.repository.MemberRepository;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    MemberRepository memberRepository;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("comments",commentRepository.findAll());
        model.addAttribute("boards", boardRepository.findAll());
        return "comment/list";
    }

    @GetMapping("create")
    public String create(Model model,@RequestParam("board_idx") int board_idx) {
        Comment comment = new Comment();
        Board board = boardRepository.findById(board_idx).get();
        comment.setBoard(board);
        comment.setMember(board.getMember());
        model.addAttribute("comment",comment);
        model.addAttribute("board",board);
        model.addAttribute("member",comment.getMember());
        return "comment/edit";
    }

    @PostMapping("create")
    public String create(Model model, Comment comment) {
        commentRepository.save(comment);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("comm_idx") int comm_idx) {
        Comment comment = commentRepository.findById(comm_idx).get();
        model.addAttribute("comment", comment);
        model.addAttribute("board",comment.getBoard());
        return "comment/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Comment comment) {
        commentRepository.save(comment);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("comm_idx") int comm_idx) {
        commentRepository.deleteById(comm_idx);
        return "redirect:list";
    }

}