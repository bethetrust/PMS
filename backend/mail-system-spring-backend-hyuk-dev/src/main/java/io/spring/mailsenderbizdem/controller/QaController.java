package io.spring.mailsenderbizdem.controller;

import java.security.Principal;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.Date;
=======
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
>>>>>>> testbranch
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.spring.mailsenderbizdem.dto.AddressbookDto;
import io.spring.mailsenderbizdem.dto.QaDto;
import io.spring.mailsenderbizdem.dto.UserAccountDto;
import io.spring.mailsenderbizdem.mapper.UserAccountMapper;
import io.spring.mailsenderbizdem.message.ResponseMessage;
import io.spring.mailsenderbizdem.message.StatusEnum;
import io.spring.mailsenderbizdem.service.QaService;

@RestController
@CrossOrigin("*")
public class QaController {
	
	@Autowired
    private UserAccountMapper userAccountMapper;
	
	@Autowired
	private QaService qaService;
	
	public UserAccountDto getUser(String userId) {
        return userAccountMapper.selectOneByUserById(userId);
    }
	
	
<<<<<<< HEAD
	@PostMapping("/qa/selectQaAll")
	public ResponseMessage selectQaAll(Principal principal) {
		ResponseMessage message = new ResponseMessage();
		
=======
	@PostMapping("/user/selectQaAll")
	public ResponseMessage selectQaAll(@RequestBody Map<String,Object> qaInfo, Principal principal) {
		ResponseMessage message = new ResponseMessage();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

>>>>>>> testbranch
		try {
			UserAccountDto user = getUser(principal.getName());
			if (user == null) {
				throw new SQLException("해당 아이디를 찾을 수 없습니다.");
			}
			
<<<<<<< HEAD
			
			qaService.selectQaAll(user.getUserNo());
			message.setData(qaService.selectQaAll(user.getUserNo()));
=======
			int userNo = user.getUserNo();
			String qaTitle = (qaInfo.containsKey("qaTitle")) ? qaInfo.get("qaTitle").toString() : null;
			String startDate =  (qaInfo.containsKey("startDate") ) ? qaInfo.get("startDate").toString() : null;
			String endDate =  (qaInfo.containsKey("endDate")) ? qaInfo.get("endDate").toString() : null;
			int pageStart =  (qaInfo.containsKey("pageStart") ) ? Integer.parseInt(qaInfo.get("pageStart").toString()) : 0;

			if(startDate.equals("")) startDate = null;
            if(endDate==null || endDate.equals("")) {
                endDate = dateFormat.format(new Date());
            }
			endDate += " 23:59:59";

			QaDto qa = QaDto.builder()
					.qaTitle(qaTitle)
					.startDate(startDate)
					.endDate(endDate)
					.regId(userNo)
					.build();

			int pageCount =  (qaInfo.containsKey("pageCount") ) ? Integer.parseInt(qaInfo.get("pageCount").toString()) : 10;
			qa.setPageStart(pageStart * pageCount);
			qa.setPageCount(pageCount);

			List<QaDto> qaList = qaService.selectQaAll(qa);
			
			if(qaList.size() > 0) {
                QaDto qaDto = qaList.get(0);
                int recordCount = qaService.selectQaAllCount(qa);
                qaDto.setRecordCount(recordCount);
                qaList.set(0, qaDto);
			}
			
			message.setData(qaList);
>>>>>>> testbranch
		} catch (Exception e) {
			message.setMessage("해당 아이디로 전체 조회가 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setData(null);
            e.printStackTrace();
            return message;
		}
		
		message.setMessage("전체 조회 완료");
		message.setStatus(StatusEnum.OK);
		
		return message;
	}
	
	@PostMapping("/qa/save")
	public ResponseMessage saveQa(@RequestBody Map<String, Object> qaInfo, Principal principal) {
		ResponseMessage message = new ResponseMessage();
		
		try {
			UserAccountDto user = getUser(principal.getName());
			if (user == null) {
				throw new SQLException("해당 아이디를 찾을 수 없습니다.");
			}
			
			int userNo = user.getUserNo();
			QaDto qa = QaDto.builder()
					.qaTitle(qaInfo.get("qaTitle").toString())
					.qaContent(qaInfo.get("qaContent").toString())
					.qaAttach(qaInfo.get("qaAttach").toString())
					.qaGroup(qaInfo.get("qaGroup").toString())
					.build();
			// SAVE(INSERT)
			if (qaInfo.get("qaNo") == null) {
				qa.setRegDate(new Date());
				qa.setRegId(userNo);
				
				qaService.insertQa(qa);
				message.setData(qa.getQaNo());
				// SAVE(UPDATE)
			} else {
				qa.setQaNo(Integer.parseInt(qaInfo.get("qaNo").toString()));
				qa.setEditDate(new Date());
				qa.setEditor(userNo);
				qa.setUseStatus(Integer.parseInt(qaInfo.get("useStatus").toString()));
				message.setData("update");
				qaService.updateQa(qa);
			}
		} catch (Exception e) {
			 message.setMessage("해당 아이디로 등록이 불가능 합니다.");
	         message.setStatus(StatusEnum.NOT_FOUND);
	            
	         e.printStackTrace();
	         
	         return message;
		}
		
		message.setMessage("저장 완료");
        message.setStatus(StatusEnum.OK);
		
		
		return message;
	}
	
	//selectOne
    @Transactional
    @PostMapping("/qa/selectOneQa")
    public ResponseMessage selectOneAddressbook(@RequestBody Map<String,String> QaInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            int parsedQaNo = Integer.parseInt(QaInfo.get("qaNo").toString());
            QaDto qa = qaService.selectOneQa(parsedQaNo);
            message.setData(qa);
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
