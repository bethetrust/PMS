package io.spring.mailsenderbizdem.service;

import java.util.List;

import io.spring.mailsenderbizdem.dto.MailDraftDto;

public interface MailDraftService {
    void insertMailDraft(MailDraftDto mailDraft);
    List<MailDraftDto> selectMailDraftAll(MailDraftDto mailDraft);
    int selectMailDraftdAllCount(MailDraftDto mailDraft);
    MailDraftDto selectMailDraftByDraftNo(MailDraftDto mailDraft);
    void updateMailDraft(MailDraftDto mailDraft);
    void deleteMailDraft(int draftNo);
}
