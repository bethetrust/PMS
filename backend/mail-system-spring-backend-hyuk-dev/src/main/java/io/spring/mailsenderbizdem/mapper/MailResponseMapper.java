package io.spring.mailsenderbizdem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import io.spring.mailsenderbizdem.dto.MailResponseDto;

@Repository
@Mapper
public interface MailResponseMapper {
    void insertMailResponse(MailResponseDto mailResponse);
    List<MailResponseDto> selectMailResponseAll(MailResponseDto mailResponse);
    int selectMailResponseAllCount(MailResponseDto mailResponse);
}
