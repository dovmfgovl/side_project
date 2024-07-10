package com.plum.notice.service;

import com.plum.notice.dto.NoticeDTO;
import com.plum.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public void insert(NoticeDTO noticeDTO) throws IOException {
        if (noticeDTO.getNoticeFiles().get(0).isEmpty()) {
            // 파일 없는 경우
            noticeDTO.setFileCheck(0);
            noticeRepository.insert(noticeDTO);
        } else {
            // 파일 있는 경우
            noticeDTO.setFileCheck(1);
            // notice 먼저 insert
            NoticeDTO insertNotice = noticeRepository.insert(noticeDTO);
            // 파일 처리 후 noticeFile insert
            for (MultipartFile noticeFile : noticeDTO.getNoticeFiles()) {
                String originalFileName = noticeFile
            }
        }
        
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
