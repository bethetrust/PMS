package io.spring.mailsenderbizdem.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.spring.mailsenderbizdem.dto.SendRecordDto;
import io.spring.mailsenderbizdem.dto.UserAccountDto;
import io.spring.mailsenderbizdem.mapper.UserAccountMapper;
import io.spring.mailsenderbizdem.message.ResponseMessage;
import io.spring.mailsenderbizdem.message.StatusEnum;
import io.spring.mailsenderbizdem.service.SendRecordService;

@RestController
@CrossOrigin("*")
public class SendRecordController {
    
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private SendRecordService sendRecordService;

    public UserAccountDto getUser(String userId) {
        return userAccountMapper.selectOneByUserById(userId);
    }

    //selectAll
    @Transactional
    @PostMapping("/user/selectSendRecordAll")
    public ResponseMessage selectSendRecordAll(@RequestBody Map<String,String> sendRecordInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      

            int userNo = user.getUserNo();
            String sendRecTitle = (sendRecordInfo.containsKey("sendRecTitle")) ? sendRecordInfo.get("sendRecTitle").toString() : null;
            String sendRecContent =  (sendRecordInfo.containsKey("sendRecContent") ) ? sendRecordInfo.get("sendRecContent").toString() : null;
            String sendRecReceiver =  (sendRecordInfo.containsKey("sendRecReceiver") ) ? sendRecordInfo.get("sendRecReceiver").toString() : null;
            String sendRecRefference =  (sendRecordInfo.containsKey("sendRecRefference") ) ? sendRecordInfo.get("sendRecRefference").toString() : null;
            String startDate =  (sendRecordInfo.containsKey("startDate") ) ? sendRecordInfo.get("startDate").toString() : null;
            String endDate =  (sendRecordInfo.containsKey("endDate")) ? sendRecordInfo.get("endDate").toString() : null;
            int pageStart =  (sendRecordInfo.containsKey("pageStart") ) ? Integer.parseInt(sendRecordInfo.get("pageStart")) : 0;

<<<<<<< HEAD
            System.out.println(sendRecTitle+"k");
=======
>>>>>>> testbranch
            if(startDate.equals("")) startDate = null;
            if(endDate==null || endDate.equals("")) {
                endDate = dateFormat.format(new Date());
            }
            endDate += " 23:59:59";

            // String regDate =  (sendRecordInfo.containsKey("regDate") ) ? sendRecordInfo.get("regDate").toString() : null;
            SendRecordDto sendRecord = SendRecordDto.builder()
                                    .sendRecTitle(sendRecTitle)
                                    .sendRecContent(sendRecContent)
                                    .sendRecReceiver(sendRecReceiver)
                                    .sendRecSenderNo(userNo)
                                    .sendRecRefference(sendRecRefference)
                                    .startDate(startDate)
                                    .endDate(endDate)
                                    .build();

            int pageCount =  (sendRecordInfo.containsKey("pageCount") ) ? Integer.parseInt(sendRecordInfo.get("pageCount")) : 10;
            sendRecord.setPageStart(pageStart * pageCount);
            sendRecord.setPageCount(pageCount);

            List<SendRecordDto> sendRecordList = sendRecordService.selectSendRecordAll(sendRecord);
            
            if(sendRecordList.size() > 0) {
                SendRecordDto sendRec = sendRecordList.get(0);
                int recordCount = sendRecordService.selectSendRecordAllCount(sendRecord);
                sendRec.setRecordCount(recordCount);
                sendRecordList.set(0, sendRec);
            }

            message.setData(sendRecordList);
<<<<<<< HEAD
        } catch(Exception ex) {
            ex.printStackTrace();
            message.setMessage("해당 아이디로 조회가 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setData(null);
            return message;
        }

=======
        } catch (NullPointerException ex) {
            message.setMessage("해당 아이디로 등록이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            return message;

        } catch (Exception ex) {
            message.setMessage("오류가 발생했습니다..");
            message.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
            return message;
        }
>>>>>>> testbranch
        message.setMessage("조회 완료");
        message.setStatus(StatusEnum.OK);
        return message;
    }

    @Transactional
    @PostMapping("/user/selectSendRecordBySendRecNo")
    public ResponseMessage selectSendRecordBySendRecNo(@RequestBody Map<String,String> sendRecordInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            int sendRecNo = (sendRecordInfo.containsKey("sendRecNo")) ? Integer.parseInt(sendRecordInfo.get("sendRecNo").toString()) : 0;
            int userNo = user.getUserNo();
            SendRecordDto sendRecord = SendRecordDto.builder()
                                    .sendRecSenderNo(userNo)
                                    .sendRecNo(sendRecNo)
                                    .build();
            sendRecord = sendRecordService.selectSendRecordBySendRecNo(sendRecord);
            message.setData(sendRecord);
<<<<<<< HEAD
        } catch(Exception ex) {
            ex.printStackTrace();
            message.setMessage("해당 아이디로 조회가 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setData(null);
=======
        } catch (NullPointerException ex) {
            message.setMessage("해당 아이디로 등록이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            return message;

        } catch (Exception ex) {
            message.setMessage("오류가 발생했습니다..");
            message.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
>>>>>>> testbranch
            return message;
        }

        message.setMessage("조회 완료");
        message.setStatus(StatusEnum.OK);
        return message;
    }
}
