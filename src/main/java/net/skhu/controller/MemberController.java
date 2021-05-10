//package net.skhu.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import net.skhu.dto.Resource.ResponseResource;
//import net.skhu.dto.response.MemberData;
//import net.skhu.dto.response.Response;
//import net.skhu.service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import net.skhu.entity.Member;
//import net.skhu.repository.MemberRepository;
//
//
//@Controller
//@RequestMapping("/member")
//public class MemberController {
//
////   @Autowired
////   MemberService memberService;
////
////   @Autowired
////   MemberRepository memberRepository;
//
//
//   //첫 화면용 test 쓸모x?
//   @RequestMapping("signup")
//   public String start() {
//      return "member/startpage";
//   }
//
//   //index입력 받고 있는데 수정 필요함, 지금 어떻게 인덱스 매기고 있는지??? 알아야할듯
//   @PostMapping(path = "/create")
//   public String addMamber(Member member) {
//      memberService.createMember(member);
//      return "member/startpage";    //create랑 delete 둘 다 리턴을 메시지로 수정 필요(성공여부 등)
//   }
//
//   //작동은 하는데 화면 구현 안해서 creat form변경 및 인덱스 입력받아야 하는데 필드값 저절로 받는 방식으로 수정필요
//   @PostMapping(path = "/delete")
//   public String deleteMamber(Member member) {
//      memberService.deleteMember(member.getMem_idx());
//      return "member/startpage";
//   }
//
//   @GetMapping(path = "/show")
//   public ResponseEntity<ResponseResource> list() {
//      List<Member> memberList = memberRepository.findAll();
//      List<MemberData> list = new ArrayList<>();   //메서드 실행 불가능한 객체
//
//      for(int i=0; i<memberList.size(); i++) {
//         MemberData memberData = new MemberData(memberList.get(i));
//         list.add(memberData);
//      }
//      Response response = Response.builder()
//              .message("회원목록")
//              .body(list)
//              .build();
//      ResponseResource resource = new ResponseResource(response, MemberController.class,"list");
//      return ResponseEntity.ok().body(resource);
//   }
//
//   @GetMapping(path = "/myinfo")
//   public ResponseEntity<ResponseResource> mypage(String userid) {
//      Member member = memberRepository.findAll().get(0);    //repository오류때문에 아무나 넣음
//      MemberData memberData = new MemberData(member);
//
//      Response response = Response.builder()
//              .message("내정보")
//              .body(memberData)
//              .build();
//      ResponseResource resource = new ResponseResource(response, MemberController.class,"list");
//      return ResponseEntity.ok().body(resource);
//   }
//}