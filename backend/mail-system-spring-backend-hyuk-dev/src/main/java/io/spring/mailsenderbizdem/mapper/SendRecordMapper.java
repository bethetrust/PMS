package io.spring.mailsenderbizdem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import io.spring.mailsenderbizdem.dto.SendRecordDto;

@Repository
@Mapper
public interface SendRecordMapper {
    List<SendRecordDto> selectSendRecordAll(SendRecordDto sendRecord);
    SendRecordDto selectSendRecordBySendRecNo(SendRecordDto sendRecord);
    int selectSendRecordAllCount(SendRecordDto sendRecord);
    void insertSendRecord(SendRecordDto sendRecord);
}
