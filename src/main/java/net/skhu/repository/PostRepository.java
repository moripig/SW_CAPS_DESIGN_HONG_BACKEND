package net.skhu.repository;

import net.skhu.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByTitle(String post_title);
    List<Post> findAllByLoca(String post_loca);
    Post findById(int id);

}
