package io.spring.mailsenderbizdem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.mailsenderbizdem.dto.MailDraftDto;
import io.spring.mailsenderbizdem.dto.MailResponseDto;
import io.spring.mailsenderbizdem.mapper.MailResponseMapper;

@Service
public class MailResponseServiceImpl implements MailResponseService {

    @Autowired
    MailResponseMapper mailResponseMapper;

    @Override
    public void insertMailResponse(MailResponseDto mailResponse) {
        mailResponseMapper.insertMailResponse(mailResponse);
    }

    @Override
    public List<MailResponseDto> selectMailResponseAll(MailResponseDto mailResponse) {
        return mailResponseMapper.selectMailResponseAll(mailResponse);
    }

    @Override
    public int selectMailResponseAllCount(MailResponseDto mailResponse) {
        return mailResponseMapper.selectMailResponseAllCount(mailResponse);
    }

    
}
