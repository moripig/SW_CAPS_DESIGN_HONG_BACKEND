package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Member;
import net.skhu.entity.Schedule;
import net.skhu.repository.MemberRepository;
import net.skhu.repository.ScheduleRepository;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	ScheduleRepository scheduleRepository;

	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("members", memberRepository.findAll());
		return "schedule/list";
	}

	@GetMapping("create")
	public String create(Model model,@RequestParam("mem_idx") int mem_idx) {
		Schedule schedule = new Schedule();
		Member member = memberRepository.findById(mem_idx).get();
		schedule.setMember(member);
		model.addAttribute("member",member);
		model.addAttribute("schedule",schedule);
		return "schedule/edit";
	}

	@PostMapping("create")
	public String create(Model model, Schedule schedule) {
		scheduleRepository.save(schedule);
		return "redirect:list";
	}

	@GetMapping("edit")
	public String edit(Model model, @RequestParam("sche_idx") int sche_idx) {
		Schedule schedule = scheduleRepository.findById(sche_idx).get();
		model.addAttribute("schedule", schedule);
		return "schedule/edit";
	}

	@PostMapping("edit")
	public String edit(Model model, Schedule schedule) {
		scheduleRepository.save(schedule);
		return "redirect:list";
	}

	@RequestMapping("delete")
	public String delete(Model model, @RequestParam("shce_idx") int sche_idx) {
		scheduleRepository.deleteById(sche_idx);
		return "redirect:list";
	}

}
