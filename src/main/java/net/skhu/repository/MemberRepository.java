package net.skhu.repository;

import net.skhu.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
//    Member findMemberByMem_useridAndAndMem_idx(String mem_userid, int mem_idx);
    //오류로 주석처리
}
