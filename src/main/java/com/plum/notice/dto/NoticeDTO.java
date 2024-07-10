package com.plum.notice.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeDTO {
    private int no;
    private String title;
    private String content;
    private String user;
    private String date;
    // 사진 파일 업로드를 위해 추가된 필드
    private int fileCheck;
    private List<MultipartFile> noticeFiles;
}
