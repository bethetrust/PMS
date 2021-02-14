package io.spring.mailsenderbizdem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import io.spring.mailsenderbizdem.dto.MailTemplateDto;

@Repository
@Mapper
public interface MailTemplateMapper {
    @Options(useGeneratedKeys = true, keyProperty = "tplNo")
    void insertMailTemplate(MailTemplateDto mailTemplate);
    void updateMailTemplate(MailTemplateDto mailTemplate);
    void deleteMailTemplate(int tplNo);
    MailTemplateDto selectOneMailTemplate(int tplNo);

    List<MailTemplateDto> selectMailTemplateAll(MailTemplateDto mailTemplate);
    int selectMailTemplateCount(MailTemplateDto mailTemplate);
    List<MailTemplateDto> selectDetailMailTemplate(MailTemplateDto mailTemplate);
}
