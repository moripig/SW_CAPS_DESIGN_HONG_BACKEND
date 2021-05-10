package net.skhu.service;

import net.skhu.entity.Post;
import net.skhu.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    //전부
    public List<Post> allPost() {
        return postRepository.findAll();
    }

    //생성 - 미완
    public void creatPost(Post post) {
        postRepository.save(post);
    }

    //검색기능, 제목으로 검색
    public List<Post> searchTitle(String title) {
        return postRepository.findAllByTitle(title);
    }

    //id로 게시글 불러오기(선택시 사용)
    public Post searchId(int id) {
        return postRepository.findById(id);
    }

    public List<Post> searchLoca(String loca) {
        return postRepository.findAllByLoca(loca);
    }

    public Page<Post> searchPage(Pageable page) {
        return postRepository.findAll(page);
    }

    public void changeBody(int id, String body) {
        postRepository.findById(id).setBody(body);
    }


}
