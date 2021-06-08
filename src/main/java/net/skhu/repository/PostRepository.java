package net.skhu.repository;

import net.skhu.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {


    //타이틀로 검색
//    List<Post> findAllByTitleContaining(String title);
    Page<Post> findAllByTitleContaining(String title, Pageable pageable);

    //클릭시 사용
    Post findById(int id);

    //아직 사용x
    List<Post> findAllByLoca(String loca);

    @Query(value = "SELECT max(id) From Post")
    public BigDecimal max();



}
