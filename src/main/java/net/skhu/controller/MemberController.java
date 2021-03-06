package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Member;
import net.skhu.repository.MemberRepository;

@Controller
@RequestMapping("/member")
public class MemberController {
   @Autowired
   MemberRepository memberRepository;

   @RequestMapping("list")
   public String list(Model model) {
      List<Member> members = memberRepository.findAll();
      model.addAttribute("members", members);
      return "member/list";
   }
   @RequestMapping("list1")
   public String list1(Model model) {
	   model.addAttribute("members",memberRepository.findAll());
	   return "member/list1";
   }
   @GetMapping("create")
   public String create(Model model) {
      Member member = new Member();
      model.addAttribute("member", member);
      return "member/edit";
   }

   @PostMapping("create")
	public String create(Model model, Member member) {
		memberRepository.save(member);
		return "redirect:list";
	}

   @GetMapping("edit")
   public String edit(Model model, @RequestParam("idx") int idx) {
      Member member = memberRepository.findById(idx).get();
      model.addAttribute("member", member);
      return "member/edit";
   }

   @PostMapping("edit")
   public String edit(Model model, Member member) {
      memberRepository.save(member);
      return "redirect:list";
   }

   @RequestMapping("delete")
   public String delete(Model model, @RequestParam("idx") int idx) {
      memberRepository.deleteById(idx);
      return "redirect:list";
   }

}