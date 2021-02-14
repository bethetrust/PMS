package io.spring.mailsenderbizdem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import io.spring.mailsenderbizdem.dto.MailDraftDto;

@Repository
@Mapper
public interface MailDraftMapper {
    void insertMailDraft(MailDraftDto mailDraft);
    List<MailDraftDto> selectMailDraftAll(MailDraftDto mailDraft);
    int selectMailDraftdAllCount(MailDraftDto mailDraft);
    MailDraftDto selectMailDraftByDraftNo(MailDraftDto mailDraft);
    void updateMailDraft(MailDraftDto mailDraft);
    void deleteMailDraft(int draftNo);
    
}

