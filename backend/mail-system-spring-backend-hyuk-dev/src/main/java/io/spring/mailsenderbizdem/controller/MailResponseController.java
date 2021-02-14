package io.spring.mailsenderbizdem.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.spring.mailsenderbizdem.dto.MailResponseDto;
import io.spring.mailsenderbizdem.dto.SendRecordDto;
import io.spring.mailsenderbizdem.dto.UserAccountDto;
import io.spring.mailsenderbizdem.mapper.UserAccountMapper;
import io.spring.mailsenderbizdem.message.ResponseMessage;
import io.spring.mailsenderbizdem.message.StatusEnum;
import io.spring.mailsenderbizdem.service.MailResponseService;
import io.spring.mailsenderbizdem.service.SendRecordService;
import io.spring.mailsenderbizdem.util.AddressInfo;

@RestController
@CrossOrigin("*")
public class MailResponseController {
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private MailResponseService mailResponseService;

    @Autowired
    private SendRecordService sendRecordService;

    public UserAccountDto getUser(String userId) {
        return userAccountMapper.selectOneByUserById(userId);
    }

    //selectAll
    @Transactional
    @PostMapping("/user/selectMailResponseAll")
    public ResponseMessage selectMailResponseAll(@RequestBody Map<String,String> mailResponseInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      

            // int userNo = user.getUserNo();
            int sendRecNo = (mailResponseInfo.containsKey("sendRecNo") ) ? Integer.parseInt(mailResponseInfo.get("sendRecNo")) : 0;
            String receiverEmail = (mailResponseInfo.containsKey("receiverEmail")) ? mailResponseInfo.get("receiverEmail").toString() : null;
            int pageStart =  (mailResponseInfo.containsKey("pageStart") ) ? Integer.parseInt(mailResponseInfo.get("pageStart")) : 0;

            MailResponseDto mailResponse = MailResponseDto.builder()
                                    .sendRecNo(sendRecNo)
                                    .receiverEmail(receiverEmail)
                                    .build();

            int pageCount =  (mailResponseInfo.containsKey("pageCount") ) ? Integer.parseInt(mailResponseInfo.get("pageCount")) : 10;
            mailResponse.setPageStart(pageStart * pageCount);
            mailResponse.setPageCount(pageCount);

            List<MailResponseDto> mailResponseList = mailResponseService.selectMailResponseAll(mailResponse);
            
            if(mailResponseList.size() > 0) {
                MailResponseDto mResp = mailResponseList.get(0);
                int recordCount = mailResponseService.selectMailResponseAllCount(mailResponse);
                mResp.setRecordCount(recordCount);
                mailResponseList.set(0, mResp);
            }

            message.setData(mailResponseList);
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
            message.setMessage("오류가 발생했습니다.");
            message.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
>>>>>>> testbranch
            return message;
        }

        message.setMessage("조회 완료");
        message.setStatus(StatusEnum.OK);
        return message;
    }

    @Transactional
    @PostMapping("/all/insertMailResponse/{sendRecNo}")
    public ResponseMessage insertMailResponse(@PathVariable("sendRecNo") String sendRecNo,   
    @RequestBody Map<String,String> mailResponseInfo) {
        ResponseMessage message = new ResponseMessage();

        ObjectMapper mapper = new ObjectMapper();
        AddressInfo[] addressInfos = null;
        AddressInfo[] ccInfos = null;
        Map<String, AddressInfo> emailMap = new HashMap<>();

        try {
            int parsedsendRecNo = Integer.parseInt(sendRecNo);
            String receiverEmail = (mailResponseInfo.containsKey("receiverEmail")) ? mailResponseInfo.get("receiverEmail").toString() : null;
            String receiverName = (mailResponseInfo.containsKey("receiverName")) ? mailResponseInfo.get("receiverName").toString() : null;
            String receiverPhone = (mailResponseInfo.containsKey("receiverPhone")) ? mailResponseInfo.get("receiverPhone").toString() : null;
            Date regDate = new Date();
            
            SendRecordDto sendRecord = SendRecordDto.builder()
                                    .sendRecNo(parsedsendRecNo)
                                    .build();
            sendRecord = sendRecordService.selectSendRecordBySendRecNo(sendRecord);

            // 초대 메일 탐색
            if(sendRecord != null) {
                addressInfos = mapper.readValue(sendRecord.getSendRecReceiver(), AddressInfo[].class);
<<<<<<< HEAD
                ccInfos =  mapper.readValue(sendRecord.getSendRecRefference(), AddressInfo[].class);
                for(AddressInfo addr : addressInfos) {
                    if(emailMap.containsKey(addr.getAddrEmail())==false) emailMap.put(addr.getAddrEmail(), addr);
                }
                for(AddressInfo addr : ccInfos) {
                    if(emailMap.containsKey(addr.getAddrEmail())==false) emailMap.put(addr.getAddrEmail(), addr);
                }
=======
                // ccInfos =  mapper.readValue(sendRecord.getSendRecRefference(), AddressInfo[].class);
                for(AddressInfo addr : addressInfos) {
                    if(emailMap.containsKey(addr.getAddrEmail())==false) emailMap.put(addr.getAddrEmail(), addr);
                }
                // for(AddressInfo addr : ccInfos) {
                //     if(emailMap.containsKey(addr.getAddrEmail())==false) emailMap.put(addr.getAddrEmail(), addr);
                // }
>>>>>>> testbranch
                
                if(emailMap.containsKey(receiverEmail)==false) throw new NotFoundEmailException();
            }

            MailResponseDto mailResponse = MailResponseDto.builder()
                                    .receiverEmail(receiverEmail)
                                    .receiverName(receiverName)
                                    .receiverPhone(receiverPhone)
                                    .sendRecNo(parsedsendRecNo)
                                    .regDate(regDate)
                                    .build();

            int dupCount = mailResponseService.selectMailResponseAllCount(mailResponse);
            if(dupCount > 0) throw new DuplicateEmailException();
            mailResponseService.insertMailResponse(mailResponse);
            message.setData(mailResponse);
        } catch(NotFoundEmailException ex) {
            message.setMessage("입력한 메일을 초대리스트에서 찾을수 없습니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setData(null);
            return message;
        } catch(DuplicateEmailException ex) {
            message.setMessage("이미 등록된 이메일 입니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setData(null);
            return message;
        }  catch(Exception ex) {
            ex.printStackTrace();
            message.setMessage("저장이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setData(null);
            return message;
        }

        message.setMessage("저장 완료");
        message.setStatus(StatusEnum.OK);
        return message;
    }

    class NotFoundEmailException extends Exception {
         NotFoundEmailException() {}        
    }

    class DuplicateEmailException extends Exception {
        DuplicateEmailException() {}
    }

}
