package io.spring.mailsenderbizdem.controller;


import java.nio.charset.Charset;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.spring.mailsenderbizdem.dto.MailTemplateDto;
import io.spring.mailsenderbizdem.dto.UserAccountDto;
import io.spring.mailsenderbizdem.mapper.UserAccountMapper;
import io.spring.mailsenderbizdem.message.ResponseMessage;
import io.spring.mailsenderbizdem.message.StatusEnum;
import io.spring.mailsenderbizdem.service.MailTemplateService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin("*")
public class MailTemplateController {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private MailTemplateService mailTemplateService; 
    
    public HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders(); 
        headers.setContentType(new MediaType("application", "json",
            Charset.forName("UTF-8")
        ));
        headers.setAccessControlAllowOrigin("*");
        return headers;
    }
    
    public UserAccountDto getUser(String userId) {
        return userAccountMapper.selectOneByUserById(userId);
    }
    
    // insert MailTemplate (메일 템플릿 저장(생성))
    @Transactional
    @PostMapping("/user/save")
    public ResponseMessage saveMailTemplate(@RequestBody Map<String,Object> mailTemplateInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            } 
            
            int userNo = user.getUserNo();
            MailTemplateDto mailTemplate = MailTemplateDto.builder()
                            .tplSub(mailTemplateInfo.get("tplSub").toString())
                            .tplDesc(mailTemplateInfo.get("tplDesc").toString())
                            .tplContent(mailTemplateInfo.get("tplContent").toString())
                            .tplImagesDir(mailTemplateInfo.get("tplImagesDir").toString())
                            .tplUserNo(userNo)
                            .build();
            
            
            // Save(Insert)                
            if(mailTemplateInfo.get("tplNo") == null) {
                mailTemplate.setRegDate(new Date());
                mailTemplate.setRegId(userNo);
                
                mailTemplateService.insertMailTemplate(mailTemplate);
                message.setData(mailTemplate.getTplNo());
            // Save(Update)
            } else {
                mailTemplate.setTplNo(Integer.parseInt(mailTemplateInfo.get("tplNo").toString()));
                mailTemplate.setEditDate(new Date());
                mailTemplate.setEditor(userNo);
                mailTemplate.setUseStatus(Integer.parseInt(mailTemplateInfo.get("useStatus").toString()));
                message.setData("update");
                mailTemplateService.updateMailTemplate(mailTemplate);
            }

<<<<<<< HEAD
        }catch(Exception ex) {
            message.setMessage("해당 아이디로 등록이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            
            ex.printStackTrace();
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
        message.setMessage("저장 완료");
        message.setStatus(StatusEnum.OK);
        return message;
    }

    //selectOne
    @Transactional
    @PostMapping("/user/selectMailTemplate")
    public ResponseMessage selectMailTemplate(@RequestBody Map<String,String> tpl, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            int parsedTplNo = Integer.parseInt(tpl.get("tplNo"));
            MailTemplateDto mailTemplate = mailTemplateService.selectOneMailTemplate(parsedTplNo);
            message.setData(mailTemplate);
<<<<<<< HEAD
        } catch(Exception ex) {
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

    // delete
<<<<<<< HEAD
=======

>>>>>>> testbranch
    @Transactional
    @PostMapping("/user/deleteMailTemplate")
    public ResponseMessage deleteMailTemplate(@RequestBody Map<String, Object> tpl, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            List list = (ArrayList)tpl.get("tplNos");
            list.forEach(item->{
                int tplNo = Integer.parseInt(item.toString());
                mailTemplateService.deleteMailTemplate(tplNo);
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
            message.setMessage("오류가 발생했습니다..");
            message.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
>>>>>>> testbranch
            return message;
        }

        message.setMessage("삭제 완료");
        message.setData(null);
        message.setStatus(StatusEnum.OK);
        return message;
    }

    // selectAll
    @PostMapping("/user/selectMailTemplateAll")
    public ResponseMessage selectMailTemplateAll(@RequestBody Map<String, Object> tpl, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            String tplSub = (tpl.containsKey("tplSub")) ? tpl.get("tplSub").toString() : null;
            int pageStart =  (tpl.containsKey("pageStart") ) ? Integer.parseInt(tpl.get("pageStart").toString()) : 0;
            int tplUserNo = user.getUserNo();

            MailTemplateDto mailTemplate = MailTemplateDto.builder()
                                            .tplSub(tplSub)
                                            .tplUserNo(tplUserNo)
                                            .build();

            int pageCount =  (tpl.containsKey("pageCount") ) ? Integer.parseInt(tpl.get("pageCount").toString()) : 10;
            mailTemplate.setPageStart(pageStart * pageCount);
            mailTemplate.setPageCount(pageCount);

            List<MailTemplateDto> mailTemplateList = mailTemplateService.selectMailTemplateAll(mailTemplate);
            if(mailTemplateList.size() > 0) {
                MailTemplateDto mailtpl = mailTemplateList.get(0);
                int recordCount = mailTemplateService.selectMailTemplateCount(mailTemplate);
                mailtpl.setRecordCount(recordCount);
                mailTemplateList.set(0, mailtpl);
            }
            message.setData(mailTemplateList);
            
<<<<<<< HEAD
        } catch(Exception ex) {
            ex.printStackTrace();
            message.setMessage("해당 아이디로 전체 조회가 불가능 합니다.");
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

        message.setMessage("전체 조회 완료");
        
        message.setStatus(StatusEnum.OK);
        return message;
    }

    // count
    @PostMapping("/user/selectMailTemplateCount")
    public ResponseMessage selectMailTemplateCount(Map<String, Object>tpl, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            String tplSub = (tpl.containsKey("tplSub")) ? tpl.get("tplSub").toString() : null;
            int tplUserNo = user.getUserNo();

            MailTemplateDto mailTemplate = MailTemplateDto.builder()
                                            .tplSub(tplSub)
                                            .tplUserNo(tplUserNo)
                                            .build();

            message.setData(mailTemplateService.selectMailTemplateAll(mailTemplate));
            
<<<<<<< HEAD
        } catch(Exception ex) {
            message.setMessage("해당 아이디로 전체 조회가 불가능 합니다.");
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

        message.setMessage("전체 조회 완료");
        
        message.setStatus(StatusEnum.OK);
        return message;
    }
    
    
}
