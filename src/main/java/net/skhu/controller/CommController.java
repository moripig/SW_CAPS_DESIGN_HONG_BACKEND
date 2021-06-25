package net.skhu.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.response.CommentData;
import net.skhu.entity.Comm;
import net.skhu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@ResponseBody
@Slf4j
//@RequiredArgsConstructor
//@Controller
@RestController
@RequestMapping(path = "/comment")
public class CommController {
    @Autowired
    CommentService commentService;

    @GetMapping(path = "/all/{postidx}")
    public List<CommentData> commentList(@PathVariable("postidx") int postidx) {
        List<Comm> list = commentService.findComment(postidx);
        List<CommentData> commentDataList = new ArrayList<>();

        for(int i=0; i<list.size(); i++) {
            CommentData commentData = new CommentData(list.get(i));
            commentDataList.add(commentData);
        }
        return commentDataList;
    }
    @PostMapping(path = "/create")
    public void createComment(@RequestBody Comm comm) {
        commentService.createComment(comm);
    }

//    @PostMapping(path = "/edit")
//    public void createComment(@RequestBody Comm comm) {
//        commentService.createComment(comm);
//    }
    
}
