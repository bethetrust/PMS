package io.spring.mailsenderbizdem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.mailsenderbizdem.dto.SendRecordDto;
import io.spring.mailsenderbizdem.mapper.SendRecordMapper;

@Service
public class SendRecordServiceImpl implements SendRecordService {

    @Autowired
    SendRecordMapper sendRecordMapper;

    @Override
    public List<SendRecordDto> selectSendRecordAll(SendRecordDto sendRecord) {
        return sendRecordMapper.selectSendRecordAll(sendRecord);
    }

    @Override
    public void insertSendRecord(SendRecordDto sendRecord) {
        sendRecordMapper.insertSendRecord(sendRecord);
    }

    @Override
    public SendRecordDto selectSendRecordBySendRecNo(SendRecordDto sendRecord) {
        return sendRecordMapper.selectSendRecordBySendRecNo(sendRecord);
    }

    @Override
    public int selectSendRecordAllCount(SendRecordDto sendRecord) {
        return sendRecordMapper.selectSendRecordAllCount(sendRecord);
    }
}
