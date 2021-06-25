package net.skhu.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Getter
@Setter
public class Post {

    @Id
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

}
