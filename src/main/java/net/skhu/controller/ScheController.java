package net.skhu.controller;

import lombok.extern.slf4j.Slf4j;
import net.skhu.entity.Sche;
import net.skhu.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.stereotype.Controller;
//import net.skhu.entity.Post;
//import lombok.RequiredArgsConstructor;

import java.util.List;

//@ResponseBody
@Slf4j
//@RequiredArgsConstructor
//@Controller
@RestController
@RequestMapping(path = "/schedule")
public class ScheController {
	/*
	@Autowired
    ScheduleService scheduleService;

    @GetMapping(path = "/user/{userid}")
    public List<Sche> schedule(@PathVariable("userid") int userid){
        System.out.println(userid);
//        List<Sche> mysche = scheduleService.searchSchedule(userid);
//        for(int i=0; i<mysche.size(); i++) {
//
//        }
        return scheduleService.searchSchedule(userid);
    }

    @PostMapping(path = "/create")
    public void createSchedule(@RequestBody Sche sche){
        scheduleService.createSchedule(sche);
    }


    @GetMapping(path = "/delete")
    public void deleteSchedule(@RequestBody String response ){
        //userid + idx 한번에 받고 그걸 나눠서 처리하기.
    }
    */
}
