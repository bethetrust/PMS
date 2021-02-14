package io.spring.mailsenderbizdem.controller;


<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

=======
import java.security.Principal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.spring.mailsenderbizdem.dto.NoticeDto;
>>>>>>> testbranch
import io.spring.mailsenderbizdem.dto.UserAccountDto;
import io.spring.mailsenderbizdem.mapper.UserAccountMapper;
import io.spring.mailsenderbizdem.message.ResponseMessage;
import io.spring.mailsenderbizdem.message.StatusEnum;
import io.spring.mailsenderbizdem.service.NoticeService;


@RestController
@CrossOrigin("*")
public class NoticeController {
	
	@Autowired
    private UserAccountMapper userAccountMapper;
	
	@Autowired
	private NoticeService noticeService;

<<<<<<< HEAD
	
	
=======
>>>>>>> testbranch
	public UserAccountDto getUser(String userId) {
        return userAccountMapper.selectOneByUserById(userId);
    }

	
<<<<<<< HEAD
	@PostMapping("/notice/selectNoticeAll")
	public ResponseMessage selectNoticeAll() {
		ResponseMessage message = new ResponseMessage();
		
		try {
			message.setData(noticeService.selectNoticeAll());
		} catch(Exception ex) {
			message.setMessage("공지사항을 불러올 수 없습니다.");
			message.setStatus(StatusEnum.NOT_FOUND);
			message.setData(null);
			ex.printStackTrace();
			
			return message;
		}
=======
	@PostMapping("/user/selectNoticeAll")
	public ResponseMessage selectNoticeAll(@RequestBody Map<String,Object> noticeInfo, Principal principal) {
		ResponseMessage message = new ResponseMessage();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      

			int userNo = user.getUserNo();
			String noticeTitle = (noticeInfo.containsKey("noticeTitle")) ? noticeInfo.get("noticeTitle").toString() : null;
			String startDate =  (noticeInfo.containsKey("startDate") ) ? noticeInfo.get("startDate").toString() : null;
			String endDate =  (noticeInfo.containsKey("endDate")) ? noticeInfo.get("endDate").toString() : null;
			int pageStart =  (noticeInfo.containsKey("pageStart") ) ? Integer.parseInt(noticeInfo.get("pageStart").toString()) : 0;

			if(startDate.equals("")) startDate = null;
            if(endDate==null || endDate.equals("")) {
                endDate = dateFormat.format(new Date());
            }
			endDate += " 23:59:59";
			
			NoticeDto notice = NoticeDto.builder()
							.noticeTitle(noticeTitle)
							.startDate(startDate)
							.endDate(endDate)
							.build();

			int pageCount =  (noticeInfo.containsKey("pageCount") ) ? Integer.parseInt(noticeInfo.get("pageCount").toString()) : 10;
			notice.setPageStart(pageStart * pageCount);
			notice.setPageCount(pageCount);
			List<NoticeDto> noticeList = noticeService.selectNoticeAll(notice);
			
            if(noticeList.size() > 0) {
                NoticeDto not = noticeList.get(0);
                int recordCount = noticeService.selectNoticeAllCount(notice);
                not.setRecordCount(recordCount);
                noticeList.set(0, not);
            }
			
			message.setData(noticeList);
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
		
		message.setMessage("전체 공지사항 조회 완료");
		message.setStatus(StatusEnum.OK);
		
		return message;
	}
}
