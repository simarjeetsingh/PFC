package org.foobarspam.fpInformatica.forum.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TopicDTO {

    private Long id;
    private String title;
    private String content;
    private String category;
    private LocalDateTime createdDate;
    private String code;
}
