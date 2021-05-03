package net.skhu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.skhu.entity.Member;
public interface MemberRepository extends JpaRepository<Member, Long> {
  @Query(value = "from Member where mem_userid=:mem_userid")
  Member findByUsername(@Param("mem_userid") String username);
}