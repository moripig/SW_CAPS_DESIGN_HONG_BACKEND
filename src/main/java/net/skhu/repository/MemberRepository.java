package net.skhu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {


}
