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

    //리스트(페이지처리)
    public Page<Post> pagePost(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    //제목으로 검색
    public Page<Post> searchTitle(String title, Pageable pageable) {
        return postRepository.findAllByTitleContaining(title, pageable);
    }

    //생성
    public void creatPost(Post post) {
        post.setId((postRepository.max().intValue())+1);
        postRepository.save(post);
    }

    //게시글 선택 시 화면정보
    public Post searchId(int id) {
        return postRepository.findById(id);
    }


//    public List<Post> searchLoca(String loca) {
//        return postRepository.findAllByLoca(loca);
//    }

//    public Page<Post> searchPage(Pageable page) {
//        return postRepository.findAll(page);
//    }


    //글 수정서비스
    public void changePost(Post post) {
        postRepository.save(post);
        //Post findPost = postReposiitory.findbyId(post.getId())
        //findpost.set(~~~)

//        기존
//        postRepository.findById(post.getId()).setTitle(post.getTitle());
//        postRepository.findById(post.getId()).setBody(post.getBody());
//        postRepository.findById(post.getId()).setStart(post.getStart());
//        postRepository.findById(post.getId()).setEnd(post.getEnd());
//        postRepository.findById(post.getId()).setLoca(post.getLoca());
//        postRepository.findById(post.getId()).setMember(post.getMember());
    }

    //삭제
    public void deltePost(int id) {
        postRepository.delete(postRepository.findById(id));
    }

}
