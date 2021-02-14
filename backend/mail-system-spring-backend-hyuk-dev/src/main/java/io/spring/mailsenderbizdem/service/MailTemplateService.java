package io.spring.mailsenderbizdem.service;

import java.util.List;

import io.spring.mailsenderbizdem.dto.MailTemplateDto;

public interface MailTemplateService {

	void insertMailTemplate(MailTemplateDto mailTemplate);
    void updateMailTemplate(MailTemplateDto mailTemplate);
    void deleteMailTemplate(int tplNo);
    MailTemplateDto selectOneMailTemplate(int tplNo);

    List<MailTemplateDto> selectMailTemplateAll(MailTemplateDto mailTemplate);
    int selectMailTemplateCount(MailTemplateDto mailTemplate);
    List<MailTemplateDto> selectDetailMailTemplate(MailTemplateDto mailTemplate);
}
