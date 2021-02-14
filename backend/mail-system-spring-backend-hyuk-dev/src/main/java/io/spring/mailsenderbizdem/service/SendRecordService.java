package io.spring.mailsenderbizdem.service;

import java.util.List;

import io.spring.mailsenderbizdem.dto.SendRecordDto;

public interface SendRecordService {
    List<SendRecordDto> selectSendRecordAll(SendRecordDto sendRecord);
    SendRecordDto selectSendRecordBySendRecNo(SendRecordDto sendRecord);
    int selectSendRecordAllCount(SendRecordDto sendRecord);
    void insertSendRecord(SendRecordDto sendRecord);
}
