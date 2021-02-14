package io.spring.mailsenderbizdem.service;

import java.util.List;

import io.spring.mailsenderbizdem.dto.MailResponseDto;

public interface MailResponseService {
    void insertMailResponse(MailResponseDto mailResponse);
    List<MailResponseDto> selectMailResponseAll(MailResponseDto mailResponse);
    int selectMailResponseAllCount(MailResponseDto mailResponse);
}
