package io.lab.springsecuritymaster;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {
    private String username;
    private String password;
}
