package com.plum.notice.controller;

import com.plum.notice.dto.NoticeDTO;
import com.plum.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/insert")
    public String insert() {
        return "insert";
    }

    @PostMapping("/insert")
    public void insert(NoticeDTO noticeDTO) {
        noticeService.insert(noticeDTO);
    }
}
