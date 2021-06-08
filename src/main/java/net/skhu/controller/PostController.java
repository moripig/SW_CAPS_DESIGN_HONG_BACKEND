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
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
    public List<PostData> board(@PageableDefault(size=6,sort="id",direction=Sort.Direction.DESC) Pageable pageable) {
//        List<Post> list = postService.allPost();
        Page<Post> list = postService.allPost(pageable);
        List<PostData> board = new ArrayList<>();


        for(int i=0; i<list.getNumberOfElements(); i++) {
            PostData postData = new PostData(list.getContent().get(i));
            board.add(postData);
        }
        return board;
    }

    //제목으로 검색 시
    @GetMapping(path = "/title/{title}")
    public List<PostData> searchTitle(@PathVariable("title") String title, @PageableDefault(size=6,sort="id",direction=Sort.Direction.DESC) Pageable pageable) {
        //List<Post> list = postService.searchTitle(title);
        Page<Post> list = postService.searchTitle(title,pageable);
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
        System.out.println(post + "\n");
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