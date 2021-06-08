package net.skhu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO implements Serializable {
    private String mem_userid;
    private String mem_email;
    private String mem_password;
    private String mem_username;
    private int mem_gender;
    private String mem_address;
    private int mem_idx;

}
