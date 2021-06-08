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
public class Comm {

    @Id
    private int idx;

    private String body;

    private String date;

    private int postidx;

    private int writer;
}
