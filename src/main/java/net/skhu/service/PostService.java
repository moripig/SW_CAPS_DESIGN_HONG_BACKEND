package net.skhu.service;

import net.skhu.entity.Post;
import net.skhu.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    //전부
    public Page<Post> allPost(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    //검색기능, 제목으로 검색
    public Page<Post> searchTitle(String title, Pageable pageable) {
        return postRepository.findAllByTitleContaining(title, pageable);
    }

    //생성
    public void creatPost(Post post) {
        post.setId((postRepository.max().intValue())+1);
        postRepository.save(post);
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

    @Transactional
    public void changePost(Post post) {
        postRepository.findById(post.getId()).setTitle(post.getTitle());
        postRepository.findById(post.getId()).setBody(post.getBody());
        postRepository.findById(post.getId()).setStart(post.getStart());
        postRepository.findById(post.getId()).setEnd(post.getEnd());
        postRepository.findById(post.getId()).setLoca(post.getLoca());
        postRepository.findById(post.getId()).setMember(post.getMember());
    }

    public void deltePost(int id) {
        postRepository.delete(postRepository.findById(id));
    }

}
