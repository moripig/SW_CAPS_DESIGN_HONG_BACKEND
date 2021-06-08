package net.skhu.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Response {
    //메시지 및 객체 전달
    String message;
    Object body;
}
