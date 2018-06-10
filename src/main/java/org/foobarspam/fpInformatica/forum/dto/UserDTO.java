package org.foobarspam.fpInformatica.forum.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private String id;
    private String username;
    private String password;
    private String introduction;
    private String phone;
    private LocalDateTime createdDate;

}
