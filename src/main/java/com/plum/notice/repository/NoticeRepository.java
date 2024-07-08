package com.plum.notice.repository;

import com.plum.notice.dto.NoticeDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeRepository {
    private final SqlSessionTemplate sqlSessionTemplate;

    public void insert(NoticeDTO noticeDTO) {
        sqlSessionTemplate.insert("Notice.insert", noticeDTO);
    }

    public List<NoticeDTO> noticeFullList() {
        return sqlSessionTemplate.selectList("Notice.noticeFullList");
    }

    public NoticeDTO detailView(int no) {
        return sqlSessionTemplate.selectOne("Notice.detailView", no);
    }

    public void delete(int no) {
        sqlSessionTemplate.delete("Notice.delete", no);
    }

    public void modify(NoticeDTO noticeDTO) {
        sqlSessionTemplate.update("Notice.update", noticeDTO);
    }
}
