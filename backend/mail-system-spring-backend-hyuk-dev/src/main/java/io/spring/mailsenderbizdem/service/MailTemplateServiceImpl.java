package io.spring.mailsenderbizdem.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.mailsenderbizdem.dto.MailTemplateDto;
import io.spring.mailsenderbizdem.mapper.MailTemplateMapper;

@Service
public class MailTemplateServiceImpl implements MailTemplateService {

    @Autowired
    private MailTemplateMapper mailTemplateMapper;

    @Override
    public void insertMailTemplate(MailTemplateDto mailTemplate) {
        mailTemplateMapper.insertMailTemplate(mailTemplate);
    }

    @Override
    public void updateMailTemplate(MailTemplateDto mailTemplate) {
        mailTemplateMapper.updateMailTemplate(mailTemplate);

    }

    @Override
    public MailTemplateDto selectOneMailTemplate(int tplNo) {
        return mailTemplateMapper.selectOneMailTemplate(tplNo);
    }

    @Override
    public void deleteMailTemplate(int tplNo) {
        mailTemplateMapper.deleteMailTemplate(tplNo);
    }

    @Override
    public List<MailTemplateDto> selectMailTemplateAll(MailTemplateDto mailTemplate) {
        return mailTemplateMapper.selectMailTemplateAll(mailTemplate);
    }

    @Override
    public int selectMailTemplateCount(MailTemplateDto mailTemplate) {
        return mailTemplateMapper.selectMailTemplateCount(mailTemplate);
    }

    @Override
    public List<MailTemplateDto> selectDetailMailTemplate(MailTemplateDto mailTemplate) {
        return mailTemplateMapper.selectDetailMailTemplate(mailTemplate);
    }

    
}
