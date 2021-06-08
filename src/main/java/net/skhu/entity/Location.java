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
public class Location {

    @Id
    private int idx;

    private String dooo;

    private String si;

    private String gu;

    private int x;

    private int y;

}
