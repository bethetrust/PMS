package io.spring.mailsenderbizdem.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.lang.Collections;
import io.spring.mailsenderbizdem.dto.MailDraftDto;
import io.spring.mailsenderbizdem.dto.UserAccountDto;
import io.spring.mailsenderbizdem.mapper.UserAccountMapper;
import io.spring.mailsenderbizdem.message.ResponseMessage;
import io.spring.mailsenderbizdem.message.StatusEnum;
import io.spring.mailsenderbizdem.service.MailDraftService;

@RestController
@CrossOrigin("*")
public class MailDraftController {
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private MailDraftService mailDraftService;

    public UserAccountDto getUser(String userId) {
        return userAccountMapper.selectOneByUserById(userId);
    }

    //selectAll
    @Transactional
    @PostMapping("/user/selectMailDraftAll")
    public ResponseMessage selectMailDraftAll(@RequestBody Map<String,String> mailDraftInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      

            int userNo = user.getUserNo();
            String draftTitle = (mailDraftInfo.containsKey("draftTitle")) ? mailDraftInfo.get("draftTitle").toString() : null;
            String startDate =  (mailDraftInfo.containsKey("startDate") ) ? mailDraftInfo.get("startDate").toString() : null;
            String endDate =  (mailDraftInfo.containsKey("endDate")) ? mailDraftInfo.get("endDate").toString() : null;
            int pageStart =  (mailDraftInfo.containsKey("pageStart") ) ? Integer.parseInt(mailDraftInfo.get("pageStart")) : 0;

            if(startDate != null) {
                if(startDate.equals("")) startDate = null;
            }
            if(endDate==null || endDate.equals("")) {
                if(startDate != null && !startDate.equals("")) {
                    String [] splitedString = startDate.split("-"); 
                    Integer[] startDateArr = new Integer[splitedString.length];
                    Arrays.asList(splitedString).stream().map(str->Integer.parseInt(str)).collect(Collectors.toList()).toArray(startDateArr);
                    cal.set(startDateArr[0],startDateArr[1]-1,1);
                    endDate = (startDate +"-"+cal.getActualMaximum(Calendar.DAY_OF_MONTH)); 
                    startDate += "-01 00:00:00";
                } else {
                    endDate = dateFormat.format(new Date());
                }
            }
            endDate += " 23:59:59";

            // String regDate =  (sendRecordInfo.containsKey("regDate") ) ? sendRecordInfo.get("regDate").toString() : null;
            MailDraftDto mailDraft = MailDraftDto.builder()
                                    .draftTitle(draftTitle)
                                    .draftSenderNo(userNo)
                                    .startDate(startDate)
                                    .endDate(endDate)
                                    .build();

            int pageCount =  (mailDraftInfo.containsKey("pageCount") ) ? Integer.parseInt(mailDraftInfo.get("pageCount")) : 10;
            mailDraft.setPageStart(pageStart * pageCount);
            mailDraft.setPageCount(pageCount);

            List<MailDraftDto> mailDraftList = mailDraftService.selectMailDraftAll(mailDraft);
            
            if(mailDraftList.size() > 0) {
                MailDraftDto mdraft = mailDraftList.get(0);
                int recordCount = mailDraftService.selectMailDraftdAllCount(mailDraft);
                mdraft.setRecordCount(recordCount);
                mailDraftList.set(0, mdraft);
            }

            message.setData(mailDraftList);
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
    @PostMapping("/user/selectMailDraftByDraftNo")
    public ResponseMessage selectMailDraftByDraftNo(@RequestBody Map<String,String> mailDraftInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            int draftNo = (mailDraftInfo.containsKey("draftNo")) ? Integer.parseInt(mailDraftInfo.get("draftNo").toString()) : 0;
            int userNo = user.getUserNo();
            MailDraftDto mailDraft = MailDraftDto.builder()
                                    .draftSenderNo(userNo)
                                    .draftNo(draftNo)
                                    .build();
            mailDraft = mailDraftService.selectMailDraftByDraftNo(mailDraft);
            message.setData(mailDraft);
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
<<<<<<< HEAD
    @PostMapping("/user/insertMailTemplate")
=======
    @PostMapping("/user/insertMailDraft")
>>>>>>> testbranch
    public ResponseMessage insertMailTemplate(@RequestBody Map<String,String> mailDraftInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            int draftTplNo = (mailDraftInfo.containsKey("draftTplNo")) ? Integer.parseInt(mailDraftInfo.get("draftTplNo").toString()) : 0;
            String draftTitle = (mailDraftInfo.containsKey("draftTitle")) ? mailDraftInfo.get("draftTitle").toString() : null;
            String draftDesc = (mailDraftInfo.containsKey("draftDesc")) ? mailDraftInfo.get("draftDesc").toString() : null;
            String draftReceiver = (mailDraftInfo.containsKey("draftReceiver")) ? mailDraftInfo.get("draftReceiver").toString() : null;
            String draftReference = (mailDraftInfo.containsKey("draftReference")) ? mailDraftInfo.get("draftReference").toString() : null;
            String draftAttach = (mailDraftInfo.containsKey("draftAttach")) ? mailDraftInfo.get("draftAttach").toString() : null;
            Date regDate = new Date();
            

            int userNo = user.getUserNo();
            MailDraftDto mailDraft = MailDraftDto.builder()
                                    .draftSenderNo(userNo)
                                    .draftTplNo(draftTplNo)
                                    .draftTitle(draftTitle)
                                    .draftDesc(draftDesc)
                                    .draftReceiver(draftReceiver)
                                    .draftReference(draftReference)
                                    .draftAttach(draftAttach)
                                    .regDate(regDate)
                                    .regId(userNo)
                                    .build();

            mailDraftService.insertMailDraft(mailDraft);
            message.setData(mailDraft);
<<<<<<< HEAD
        } catch(Exception ex) {
            ex.printStackTrace();
            message.setMessage("해당 아이디로 저장이 불가능 합니다.");
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

        message.setMessage("저장 완료");
        message.setStatus(StatusEnum.OK);
        return message;
    }

    @Transactional
    @PostMapping("/user/updateMailDraft")
    public ResponseMessage updateMailDraft(@RequestBody Map<String,String> mailDraftInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            int draftTplNo = (mailDraftInfo.containsKey("draftTplNo")) ? Integer.parseInt(mailDraftInfo.get("draftTplNo").toString()) : 0;
            int draftNo = (mailDraftInfo.containsKey("draftNo")) ? Integer.parseInt(mailDraftInfo.get("draftNo").toString()) : 0;
            String draftTitle = (mailDraftInfo.containsKey("draftTitle")) ? mailDraftInfo.get("draftTitle").toString() : null;
            String draftDesc = (mailDraftInfo.containsKey("draftDesc")) ? mailDraftInfo.get("draftDesc").toString() : null;
            String draftReceiver = (mailDraftInfo.containsKey("draftReceiver")) ? mailDraftInfo.get("draftReceiver").toString() : null;
            String draftReference = (mailDraftInfo.containsKey("draftReference")) ? mailDraftInfo.get("draftReference").toString() : null;
            String draftAttach = (mailDraftInfo.containsKey("draftAttach")) ? mailDraftInfo.get("draftAttach").toString() : null;
            Date editDate = new Date();
            

            int userNo = user.getUserNo();
            MailDraftDto mailDraft = MailDraftDto.builder()
                                    .draftNo(draftNo)
                                    .draftSenderNo(userNo)
                                    .draftTplNo(draftTplNo)
                                    .draftTitle(draftTitle)
                                    .draftDesc(draftDesc)
                                    .draftReceiver(draftReceiver)
                                    .draftReference(draftReference)
                                    .draftAttach(draftAttach)
                                    .editDate(editDate)
                                    .editor(userNo)
                                    .build();

            mailDraftService.updateMailDraft(mailDraft);
            message.setData("update");
<<<<<<< HEAD
        } catch(Exception ex) {
            ex.printStackTrace();
            message.setMessage("해당 아이디로 저장이 불가능 합니다.");
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

        message.setMessage("저장 완료");
        message.setStatus(StatusEnum.OK);
        return message;
    }

    // delete
    @Transactional
    @PostMapping("/user/deleteMailDraft")
    public ResponseMessage deleteMailDraft(@RequestBody Map<String, Object> mailDraftInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            List list = (ArrayList)mailDraftInfo.get("draftNos");
            list.forEach(item->{
                int darftNo = Integer.parseInt(item.toString());
                mailDraftService.deleteMailDraft(darftNo);
            });
            
            
<<<<<<< HEAD
        } catch(Exception ex) {
            message.setMessage("해당 아이디로 삭제가 불가능 합니다.");
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

        message.setMessage("삭제 완료");
        message.setData(null);
        message.setStatus(StatusEnum.OK);
        return message;
    }
}
