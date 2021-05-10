package net.skhu.repository;

import net.skhu.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    //타이틀로 검색
    List<Post> findAllByTitle(String title);

    List<Post> findAllByLoca(String loca);

    //작성자 id로 검색
    Post findById(int id);

//    Page<Post>
}
