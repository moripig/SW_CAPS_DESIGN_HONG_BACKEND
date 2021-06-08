package net.skhu.service;

import net.skhu.entity.Sche;
import net.skhu.repository.ScheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheRepository scheRepository;

    public List<Sche> searchSchedule(int userid) {
        return scheRepository.findAllByUserid(userid);
    }

    public void createSchedule(Sche sche) {
        scheRepository.save(sche);
    }

    public void deleteSchedule(int userid, int idx) {
        scheRepository.delete(scheRepository.findByUseridAndIdx(userid,idx));
    }
}
