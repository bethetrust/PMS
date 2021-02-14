package io.spring.mailsenderbizdem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.mailsenderbizdem.dto.MailDraftDto;
import io.spring.mailsenderbizdem.mapper.MailDraftMapper;

@Service
public class MailDraftServiceImpl implements MailDraftService {

    @Autowired
    MailDraftMapper mailDraftMapper;
    @Override
    public void insertMailDraft(MailDraftDto mailDraft) {
        mailDraftMapper.insertMailDraft(mailDraft);

    }

    @Override
    public List<MailDraftDto> selectMailDraftAll(MailDraftDto mailDraft) {
        return mailDraftMapper.selectMailDraftAll(mailDraft);
    }

    @Override
    public int selectMailDraftdAllCount(MailDraftDto mailDraft) {
        return mailDraftMapper.selectMailDraftdAllCount(mailDraft);
    }

    @Override
    public MailDraftDto selectMailDraftByDraftNo(MailDraftDto mailDraft) {
        return mailDraftMapper.selectMailDraftByDraftNo(mailDraft);
    }

    @Override
    public void updateMailDraft(MailDraftDto mailDraft) {
        mailDraftMapper.updateMailDraft(mailDraft);
    }

    @Override
    public void deleteMailDraft(int draftNo) {
        mailDraftMapper.deleteMailDraft(draftNo);
    }
    
}
