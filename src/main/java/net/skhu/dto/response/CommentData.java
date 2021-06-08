package net.skhu.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.skhu.entity.Comm;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentData {
    private int idx;

    private String body;

    private String date;

    private int postidx;

    private int writer;

    public CommentData(Comm comm) {
        this.idx = comm.getIdx();
        this.body = comm.getBody();
        this.date = comm.getDate();
        this.postidx = comm.getPostidx();
        this.writer = comm.getWriter();
    }
}
