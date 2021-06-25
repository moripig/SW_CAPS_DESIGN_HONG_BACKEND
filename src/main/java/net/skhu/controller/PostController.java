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
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//@ResponseBody
@Slf4j
//@RequiredArgsConstructor
//@Controller
@RestController
@RequestMapping(path = "/post")
public class PostController {
    @Autowired
    PostService postService;

    //리스트(페이지처리)
    @GetMapping(path = "/{page}")
    public List<PostData> board(@PathVariable("page") int page) {
        Page<Post> list = postService.pagePost(PageRequest.of(page,6, Sort.by("id").descending()));
        List<PostData> board = new ArrayList<>();

        for(int i=0; i<list.getNumberOfElements(); i++) {
            PostData postData = new PostData(list.getContent().get(i));
            board.add(postData);
        }
        return board;
    }

    //제목으로 검색 시
    @GetMapping(path = "/title/{title}/{page}")
    public List<PostData> searchTitle(@PathVariable("title") String title, @PathVariable("page") int page) {
        Page<Post> list = postService.searchTitle(title,PageRequest.of(page,6,Sort.by("id").descending()));
        List<PostData> board = new ArrayList<>();

        for(int i=0; i<list.getNumberOfElements(); i++) {
            PostData postData = new PostData(list.getContent().get(i));
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

    @PostMapping(path = "/create")
    public void test(@RequestBody Post post) {
        postService.creatPost(post);
    }

    @PostMapping("/edit")
    public void editPost(@RequestBody Post post) {
        postService.changePost(post);
    }

    @PostMapping("/delete")
    public void deletePost(@RequestBody int id) {
        postService.deltePost(id);
    }

}