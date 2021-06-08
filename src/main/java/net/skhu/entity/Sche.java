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
public class Sche {
    @Id
    int idx;

    String where;

    int start;

    int end;

    int userid;

}
