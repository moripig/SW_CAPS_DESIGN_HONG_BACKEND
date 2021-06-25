package net.skhu.service;

import net.skhu.entity.Post;
import net.skhu.entity.Sche;
import net.skhu.repository.ScheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheRepository scheRepository;

    //List<Sche>타입 리턴
    public List<Sche> searchSchedule(int userid) {
        return scheRepository.findAllByUserid(userid);
    }

    public void createSchedule(Sche sche) {
        scheRepository.save(sche);
    }

    public void deleteSchedule(int idx) {
        scheRepository.delete(scheRepository.findByIdx(idx));
    }

    public void changeSchedule(Sche sche) {
        scheRepository.save(sche);
    }
}
