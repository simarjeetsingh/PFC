package org.foobarspam.fpInformatica.forum.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnswerDTO {

    private Long id;
    private String content;
    private boolean useful;
    private LocalDateTime createdDate;
    private String code;

}
