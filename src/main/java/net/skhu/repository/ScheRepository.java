package net.skhu.repository;

import net.skhu.entity.Sche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheRepository extends JpaRepository<Sche, Integer> {
    List<Sche> findAllByUserid(int userid);
    Sche findByUseridAndIdx(int userid, int idx);
}