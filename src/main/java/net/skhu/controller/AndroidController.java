package net.skhu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.skhu.entity.Member;
import net.skhu.repository.MemberRepository;

@Controller
public class AndroidController {

	@Autowired
	MemberRepository memberRepository;



	@RequestMapping(value= "/android", method = {RequestMethod.POST})
	public String androidPage(HttpServletRequest request, Model model) {
		System.out.println("서버에서 안드로이드 접속 요청함");
		try{
				String androidID = request.getParameter("id");
				String androidPW = request.getParameter("pw");
				System.out.println("안드로이드에서 받아온 id : " + androidID);
				System.out.println("안드로이드에서 받아온 pw : " + androidPW);
				Member member = memberRepository.findByUsername(androidID);
				if(member.getMem_password().equals(androidPW))
					model.addAttribute("member", member);
				else {
					return "로그인 오류";
				}

				return "android";
		}catch (Exception e){
				e.printStackTrace();
				return "null";
		}
	}
	@RequestMapping(value= "/android", method = {RequestMethod.GET})
	public String androidPage1(HttpServletRequest request, Model model) {
		System.out.println("서버에서 안드로이드 접속 요청함");
		try{
				String androidID = request.getParameter("id");
				String androidPW = request.getParameter("pw");
				System.out.println("안드로이드에서 받아온 id : " + androidID);
				System.out.println("안드로이드에서 받아온 pw : " + androidPW);
				Member member = memberRepository.findByUsername(androidID);
				if(member.getMem_password()==androidPW)
					model.addAttribute("member", member);
				else {
					return "로그인 오류";
				}

				return "android";
		}catch (Exception e){
				e.printStackTrace();
				return "null";
		}
	}
	@RequestMapping(value= "/androidJoin", method = {RequestMethod.GET, RequestMethod.POST})
	public void androidPage2(HttpServletRequest request, Model model) {
		System.out.println("서버에서 안드로이드 접속 요청함");
		try{
				String androidID = request.getParameter("id");
				String androidPW = request.getParameter("pw");
				String androidNAME = request.getParameter("name");
				String androidEMAIL = request.getParameter("email");
				String androidSEX = request.getParameter("sex");
				String androidADDRESS = request.getParameter("address");
				System.out.println("안드로이드에서 받아온 id : " + androidID);
				System.out.println("안드로이드에서 받아온 pw : " + androidPW);
				Member member = memberRepository.findByUsername(androidID);

				if(member == null) {
					Member newMember = new Member();
					newMember.setMem_userid(androidID);
					newMember.setMem_password(androidPW);
					newMember.setMem_username(androidNAME);
					newMember.setMem_gender(Integer.parseInt(androidSEX));
					newMember.setMem_email(androidEMAIL);
					newMember.setMem_address(androidADDRESS);
					memberRepository.save(member);
				}
				else {
					System.out.println("오류");
				}


		}catch (Exception e){
				e.printStackTrace();
		}
	}
}
