package net.skhu.dto.request;

import net.skhu.entity.Post;

public class PostRequest {
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

    public PostRequest(Post post) {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setLoca(String loca) {
        this.loca = loca;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setWriteridx(int writeridx) {
        this.writeridx = writeridx;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getLoca() {
        return loca;
    }

    public int getMember() {
        return member;
    }

    public int getDate() {
        return date;
    }

    public int getWriteridx() {
        return writeridx;
    }

    public String getCate() {
        return cate;
    }
}
