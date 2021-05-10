package net.skhu.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.Resource.ResponseResource;
import net.skhu.dto.request.PostRequest;
import net.skhu.dto.response.PostData;
import net.skhu.dto.response.Response;
import net.skhu.entity.Post;
import net.skhu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@ResponseBody
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping(path = "/post")
public class PostController {
    @Autowired
    PostService postService;

    //전체
    @GetMapping(path = "/")
    public List<PostData> board() {
        List<Post> list = postService.allPost();
        List<PostData> board = new ArrayList<>();

        for(int i=0; i<list.size(); i++) {
            PostData postData = new PostData(list.get(i));
            board.add(postData);
        }
        return board;
    }

    //보드에서 클릭 시
    @GetMapping(path = "/id/{id}")
    public PostData clickPost(@PathVariable("id") int id) {
        Post post = postService.searchId(id);
        PostData board = new PostData(post);

        return board;
    }

    //제목으로 검색 시
    @GetMapping(path = "/title/{title}")
    public List<PostData> searchTitle(@PathVariable("title") String title) {
        List<Post> list = postService.searchTitle(title);
        List<PostData> board = new ArrayList<>();

        for(int i=0; i<list.size(); i++) {
            PostData postData = new PostData(list.get(i));
            board.add(postData);
        }
        return board;
    }
    //생성하기 - 미완성
//    @GetMapping(path = "/create/{id}/{title}/{body}")
//    public void addPost(@PathVariable("id") int id, @PathVariable("title") String title, @PathVariable("body") String body) {
//        Post post = new Post();
//        post.setId(id);
//        post.setTitle(title);
//        post.setBody(body);
//        postService.creatPost(post);
//    }

    @GetMapping(path = "/create/{post}")
    public void addPost(@PathVariable("post") PostRequest postRequest) {
//        Post post = new Post();
//        post.setId(id);
//        post.setTitle(title);
//        post.setBody(body);
//        postService.creatPost(post);
    }

    @PostMapping(path = "/posttest")
    public void test() {
//        System.out.println(postRequest.getTitle());
//        System.out.println(postRequest.getBody());

        System.out.println("연결확인");
    }

}