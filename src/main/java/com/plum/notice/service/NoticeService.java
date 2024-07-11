package com.plum.notice.service;

import com.plum.notice.dto.NoticeDTO;
import com.plum.notice.dto.NoticeFileDTO;
import com.plum.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public void insert(NoticeDTO noticeDTO) throws IOException {
        System.out.println("NoticeDTO: " + noticeDTO);
        if (noticeDTO.getNoticeFiles() == null) {
            System.out.println("noticeFiles is null");
        } else if (noticeDTO.getNoticeFiles().isEmpty()) {
            System.out.println("noticeFiles is empty");
        }

        // noticeFiles가 null인지 확인
        if (noticeDTO.getNoticeFiles() == null || noticeDTO.getNoticeFiles().isEmpty()) {
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
                String originalFilename = noticeFile.getOriginalFilename();
                String savedFileName = System.currentTimeMillis() + "-" + originalFilename;

                NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
                noticeFileDTO.setOriginalFileName(originalFilename);
                noticeFileDTO.setSavedFileName(savedFileName);
                noticeFileDTO.setNoticeNo(insertNotice.getNo());

                //String uploadDir = "C:/Users/SeulGi/Desktop/Developer/이직준비/notice/src/main/resources/upload_files/";
                String uploadDir = "C:/Users/dovmf/Desktop/project/side_project/src/main/resources/upload_files/";
                String savePath = uploadDir + savedFileName;
                // 파일이 저장되도록 구현하는 코드
                noticeFile.transferTo(new File(savePath));
                noticeRepository.insertFile(noticeFileDTO);
            }
        }        
    }
    
    // DB에 있는 notice_file 테이블에서 파일 데이터를 가져오는 메서드
    public List<NoticeFileDTO> findFile(int no) {
        return noticeRepository.findFile(no);
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
