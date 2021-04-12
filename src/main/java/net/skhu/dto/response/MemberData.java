package net.skhu.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.skhu.entity.Member;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberData {
    //메서드 사용 불가능한 객체를 보내기 위한 클래스

    private String mem_userid;
    private String mem_email;
    private String mem_password;
    private String mem_username;
    private int mem_gender;
    private String mem_address;
    private int mem_idx;


    public MemberData(Member member) {
        this.mem_userid = member.getMem_userid();
        this.mem_email = member.getMem_email();
        this.mem_password = member.getMem_password();
        this.mem_username = member.getMem_username();
        this.mem_gender = member.getMem_gender();
        this.mem_address = member.getMem_address();
        this.mem_idx = member.getMem_idx();
    }
}
