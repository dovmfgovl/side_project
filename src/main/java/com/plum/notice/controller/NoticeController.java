package com.plum.notice.controller;

import com.plum.notice.dto.NoticeDTO;
import com.plum.notice.dto.NoticeFileDTO;
import com.plum.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public String insert(NoticeDTO noticeDTO, @RequestParam("files") List<MultipartFile> files) {
        noticeDTO.setNoticeFiles(files);
        System.out.println("Files: " + files);
        try {
            noticeService.insert(noticeDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/list";
    }

    @GetMapping("/list")
    public String noticeFullList(Model model) {
        model.addAttribute("noticeList", noticeService.noticeFullList());
        return "list";
    }

    @GetMapping("/{no}")
    public String detailView(@PathVariable("no") int no, Model model) {
        // 상세보기
        NoticeDTO noticeDTO = noticeService.detailView(no);
        model.addAttribute("notice", noticeDTO);
        // 파일 첨부
        if (noticeDTO.getFileCheck() == 1) {
            List<NoticeFileDTO> noticeFileDTOs = noticeService.findFile(no);
            model.addAttribute("noticeFileDTOs", noticeFileDTOs);
        }
        return "detail";
    }

    @GetMapping("/delete/{no}")
    public String delete(@PathVariable("no") int no) {
        noticeService.delete(no);
        return "redirect:/list";
    }

    // 수정 페이지로 이동
    @GetMapping("/modify/{no}")
    public String modify(@PathVariable("no") int no, Model model) {
        model.addAttribute("notice", noticeService.detailView(no));
        return "modify";
    }

    // 수정한 내용 DB 저장
    @PostMapping("/modify/{no}")
    public String modify(NoticeDTO noticeDTO, Model model) {
        // DB 저장 요청
        noticeService.modify(noticeDTO);
        // 수정 내용 다시 조회
        model.addAttribute("notice", noticeService.detailView((int) noticeDTO.getNo()));
        return "detail";
    }
}
