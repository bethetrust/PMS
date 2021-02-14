package io.spring.mailsenderbizdem.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

<<<<<<< HEAD
=======
import javax.mail.MessagingException;

>>>>>>> testbranch
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

import org.springframework.mail.MailException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.spring.mailsenderbizdem.dto.MailDto;
import io.spring.mailsenderbizdem.dto.SendRecordDto;
import io.spring.mailsenderbizdem.dto.UserAccountDto;
import io.spring.mailsenderbizdem.mapper.UserAccountMapper;
import io.spring.mailsenderbizdem.message.ResponseMessage;
import io.spring.mailsenderbizdem.message.StatusEnum;
import io.spring.mailsenderbizdem.service.MailSendService;
import io.spring.mailsenderbizdem.service.SendRecordService;
import io.spring.mailsenderbizdem.util.AddressInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RestController
@AllArgsConstructor
<<<<<<< HEAD
@Transactional
@CrossOrigin("*")
=======
@CrossOrigin("*")
@Transactional
>>>>>>> testbranch
public class MailSendController {

    private final MailSendService mailSendService;
    private final SendRecordService sendRecordService;
    private UserAccountMapper userAccountMapper;

    public UserAccountDto getUser(String userId) {
        return userAccountMapper.selectOneByUserById(userId);
    }

<<<<<<< HEAD
    @Transactional
    @PostMapping("/user/mail")
    public ResponseMessage execMail(
            @RequestParam("address") String address, 
            @RequestParam("ccs") String ccs,
=======

    @Transactional(rollbackFor = {MailException.class, MessagingException.class, NullPointerException.class, Exception.class} )
    @PostMapping("/user/mail")
    public ResponseMessage execMail(
            @RequestParam("address") String address, 
            // @RequestParam("ccs") String ccs,
>>>>>>> testbranch
            @RequestParam("title") String title,
            @RequestParam("tplNo") String tplNo,
            @RequestParam("message") String message, @RequestParam("htmlTemplate") MultipartFile htmlTemplate, Principal principal) {

        ResponseMessage responseMessage = new ResponseMessage();
        ObjectMapper mapper = new ObjectMapper();
        AddressInfo[] addressInfos = null;
<<<<<<< HEAD
        AddressInfo[] ccInfos = null;
=======
        // AddressInfo[] ccInfos = null;
>>>>>>> testbranch

        MailDto mailDto = new MailDto();
        mailDto.setTitle(title.equals("")? "(제목 없음)": title);
        mailDto.setMessage(message);
        File htmlFile =  new File(htmlTemplate.getOriginalFilename());
        FileOutputStream fos = null;
        try {
            UserAccountDto user = getUser(principal.getName());
            fos =  new FileOutputStream(htmlFile);
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }
            
            htmlFile.createNewFile();
            fos.write(htmlTemplate.getBytes());
            mailDto.setHtmlTemplate(htmlFile);
		    System.out.println("execMail 들어옴");
            
            addressInfos = mapper.readValue(address, AddressInfo[].class);
<<<<<<< HEAD
            ccInfos =  mapper.readValue(ccs, AddressInfo[].class);
            String[] ccsArr = new String[ccInfos.length];
            List<AddressInfo> list = Arrays.asList(ccInfos);
            list.stream().map(addrInfo->addrInfo.getAddrEmail()).collect(Collectors.toList()).toArray(ccsArr);          
            mailDto.setCcs(ccsArr);
            
=======
            // ccInfos =  mapper.readValue(ccs, AddressInfo[].class);
            // String[] ccsArr = new String[ccInfos.length];
            // List<AddressInfo> list = Arrays.asList(ccInfos);
            // list.stream().map(addrInfo->addrInfo.getAddrEmail()).collect(Collectors.toList()).toArray(ccsArr);          
            // mailDto.setCcs(ccsArr);
>>>>>>> testbranch

            SendRecordDto sendRecord = SendRecordDto.builder()
                                    .sendRecTitle(title)
                                    .sendRecContent(new String(htmlTemplate.getBytes()))
                                    .sendRecReceiver(address)
                                    .sendRecSenderNo(user.getUserNo())
<<<<<<< HEAD
                                    .sendRecRefference(ccs)
=======
                                    // .sendRecRefference(ccs)
>>>>>>> testbranch
                                    .regDate(new Date())
                                    .regId(user.getUserNo())
                                    .sendRecTplNo(Integer.parseInt(tplNo))
                                    .build();
            sendRecordService.insertSendRecord(sendRecord);
<<<<<<< HEAD

            mailDto.setSendRecNo(sendRecord.getSendRecNo());
=======
            mailDto.setSendRecNo(sendRecord.getSendRecNo());

>>>>>>> testbranch
            for(int i=0; i<addressInfos.length; i++) {
                mailDto.setAddress(addressInfos[i].getAddrEmail());
                mailSendService.mailSend(mailDto);
            }

            responseMessage.setMessage("메일 송신 성공");
            responseMessage.setStatus(StatusEnum.OK);
<<<<<<< HEAD
            responseMessage.setData(null);
            return responseMessage;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        } catch(MailException ex) {
            ex.printStackTrace();
        } catch(Exception ex) {
=======
        } catch(SQLException ex) {
            responseMessage.setMessage("해당 아이디로 등록이 불가능 합니다.");
            responseMessage.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
            ex.printStackTrace();
        } catch (JsonProcessingException ex) {
            responseMessage.setMessage("해당 템플릿에 오류가 발생했습니다.");
            responseMessage.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
            ex.printStackTrace();
        } catch(MailException ex) {
            responseMessage.setMessage("메일 서버와 연결이 불안정합니다.");
            responseMessage.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
            throw new RuntimeException();
        } catch(MessagingException ex) {
            responseMessage.setMessage("메시지를 보낼 수 없습니다.");
            responseMessage.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
            throw new RuntimeException();
        } catch(NullPointerException ex) {
            responseMessage.setMessage("해당 아이디로 등록이 불가능 합니다.");
            responseMessage.setStatus(StatusEnum.NOT_FOUND);
            ex.printStackTrace();
        } catch(RuntimeException ex) {
            responseMessage.setMessage("오류가 발생했습니다.");
            responseMessage.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
            ex.printStackTrace();
        } catch(Exception ex) {
            responseMessage.setMessage("오류가 발생했습니다.");
            responseMessage.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
>>>>>>> testbranch
            ex.printStackTrace();
        } finally {
            try {
                if(fos != null) fos.close();
            } catch (IOException e) {
<<<<<<< HEAD
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        responseMessage.setMessage("해당 아이디로 등록이 불가능 합니다.");
        responseMessage.setStatus(StatusEnum.NOT_FOUND);
        responseMessage.setData(null);
=======
                e.printStackTrace();
            }
            responseMessage.setData(null);
        } 
>>>>>>> testbranch
        return responseMessage;
    } 
}
