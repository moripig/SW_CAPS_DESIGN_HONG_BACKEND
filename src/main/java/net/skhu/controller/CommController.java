package net.skhu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.response.CommentData;
import net.skhu.entity.Comm;
import net.skhu.service.CommentService;

@ResponseBody
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping(path = "/comment")
public class CommController {

    @Autowired
    CommentService commentService;

    @GetMapping(path = "/all/{postidx}")
    public List<CommentData> commentList(@PathVariable("postidx") int postidx) {
        System.out.println(postidx);
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
        System.out.println("생성연결");
        commentService.createComment(comm);
    }

//    @PostMapping(path = "/edit")
//    public void createComment(@RequestBody Comm comm) {
//        commentService.createComment(comm);
//    }

}
