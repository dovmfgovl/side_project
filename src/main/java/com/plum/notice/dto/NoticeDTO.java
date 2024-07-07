package com.plum.notice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeDTO {
    private long no;
    private String title;
    private String content;
    private String user;
    private String date;
}
