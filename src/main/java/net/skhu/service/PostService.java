package net.skhu.service;

import net.skhu.entity.Post;
import net.skhu.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public void creatPost(Post post) {
        postRepository.save(post);
    }
    public List<Post> allPost() {
        return postRepository.findAll();
    }
    public List<Post> searchTitle(String title) {
        return postRepository.findAllByTitle(title);
    }

    public List<Post> searchLoca(String loca) {
        return postRepository.findAllByLoca(loca);
    }

    public void changeBody(int id, String body) {
        postRepository.findById(id).setBody(body);
    }


}
