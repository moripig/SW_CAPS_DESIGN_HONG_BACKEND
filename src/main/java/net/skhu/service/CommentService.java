package net.skhu.service;

import net.skhu.entity.Comm;
import net.skhu.repository.CommRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommRepository commRepository;

    //목록
    public List<Comm> findComment(int postidx) {
        return commRepository.findAllByPostidx(postidx);
    }

    //생성
    public void createComment(Comm comm) {
        commRepository.save(comm);
    }
}
