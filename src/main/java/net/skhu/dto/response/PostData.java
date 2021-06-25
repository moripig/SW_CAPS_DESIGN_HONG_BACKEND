package net.skhu.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.skhu.entity.Post;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostData {
    private int id;

    private String title;

    private String body;

    private int start;

    private int end;

    private String loca;

    private int member;

    private int date;

    private int writeridx;

    private String cate;

    public PostData(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.body = post.getBody();
        this.start = post.getStart();
        this.end = post.getEnd();
        this.loca = post.getLoca();
        this.member = post.getMember();
        this.date = post.getDate();
        this.writeridx = post.getWriteridx();
        this.cate = post.getCate();
    }

}
