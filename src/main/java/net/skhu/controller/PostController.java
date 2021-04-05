package net.skhu.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.Resource.ResponseResource;
import net.skhu.dto.response.PostData;
import net.skhu.dto.response.Response;
import net.skhu.entity.Post;
import net.skhu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


//@ResponseBody
//@Slf4j
//@RequiredArgsConstructor
@Controller
@RequestMapping(path = "/post")
public class PostController {
    @Autowired
    PostService postService;


    //전체
    @GetMapping(path = "/")
    public ResponseEntity<ResponseResource> board() {
        List<Post> list = postService.allPost();
        List<PostData> board = new ArrayList<>();

        for(int i=0; i<list.size(); i++) {
            PostData postData = new PostData(list.get(i));
            board.add(postData);
        }
        Response reponse = Response.builder()
                .message("게시글")
                .body(board)
                .build();
        ResponseResource resource = new ResponseResource(reponse, PostController.class, "all");
        return ResponseEntity.ok().body(resource);
    }

//    @GetMapping(path = "/add")
//    public ResponseEntity<ResponseResource> newPost() {
//
//        return
//    }

    @GetMapping(path = "/title/{title}")
    public ResponseEntity<ResponseResource> searchTitle(@PathVariable("title") String title) {
        List<Post> list = postService.searchTitle(title);
        List<PostData> board = new ArrayList<>();

        for(int i=0; i<list.size(); i++) {
            PostData postData = new PostData(list.get(i));
            board.add(postData);
        }
        Response reponse = Response.builder()
                .message(title + "검색")
                .body(board)
                .build();
        ResponseResource resource = new ResponseResource(reponse, PostController.class, "search");
        return ResponseEntity.ok().body(resource);
    }


}
