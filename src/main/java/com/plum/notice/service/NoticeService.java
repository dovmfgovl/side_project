package com.plum.notice.service;

import com.plum.notice.dto.NoticeDTO;
import com.plum.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public void insert(NoticeDTO noticeDTO) {
        noticeRepository.insert(noticeDTO);
    }

    public List<NoticeDTO> noticeFullList() {
        return noticeRepository.noticeFullList();
    }

    public NoticeDTO detailView(int no) {
        return noticeRepository.detailView(no);
    }

    public void delete(int no) {
        noticeRepository.delete(no);
    }

    public void modify(NoticeDTO noticeDTO) {
        noticeRepository.modify(noticeDTO);
    }
}
