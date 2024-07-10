package com.plum.notice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeFileDTO {
    private int no;
    private int noticeNo;
    private String originalFileName;
    private String savedFileName;
}
