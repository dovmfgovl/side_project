package com.plum.notice.service;

import com.plum.notice.dto.NoticeDTO;
import com.plum.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public void insert(NoticeDTO noticeDTO) {
        noticeRepository.insert(noticeDTO);
    }
}
