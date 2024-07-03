package com.plum.notice.repository;

import com.plum.notice.dto.NoticeDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NoticeRepository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public void insert(NoticeDTO noticeDTO) {
        sqlSessionTemplate.insert("Notice.insert", noticeDTO);
    }
}
