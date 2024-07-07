package com.plum.notice.controller;

import com.plum.notice.dto.NoticeDTO;
import com.plum.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/insert")
    public String insert() {
        return "insert";
    }

    @PostMapping("/insert")
    public String insert(NoticeDTO noticeDTO) {
        noticeService.insert(noticeDTO);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String noticeFullList(Model model) {
        model.addAttribute("noticeList", noticeService.noticeFullList());
        return "list";
    }

    @GetMapping("/{no}")
    public String detailView(@PathVariable("no") int no, Model model) {
        model.addAttribute("notice", noticeService.detailView(no));
        return "detail";
    }

    @GetMapping("/delete/{no}")
    public String delete(@PathVariable("no") int no) {
        noticeService.delete(no);
        return "redirect:/list";
    }
}
