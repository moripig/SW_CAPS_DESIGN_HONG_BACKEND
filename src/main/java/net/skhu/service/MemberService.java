package net.skhu.service;


import net.skhu.entity.Member;
import net.skhu.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public void createMember(Member member) {
        memberRepository.save(member);
    }

    public void deleteMember(int idx) {
        memberRepository.deleteById(idx);
    }

//  내정보 검색 -> 지금 repository에서 오류로 주석처리.
//    public Member searchMember(String id, int idx) {
//        return memberRepository.findMemberByMem_useridAndAndMem_idx(id, idx);
//    }
}
