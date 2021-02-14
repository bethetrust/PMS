package io.spring.mailsenderbizdem.service;

import java.util.List;


import io.spring.mailsenderbizdem.dto.NoticeDto;



public interface NoticeService {
	
	
<<<<<<< HEAD
	List<NoticeDto> selectNoticeAll();
=======
	List<NoticeDto> selectNoticeAll(NoticeDto notice);
	int selectNoticeAllCount(NoticeDto notice);
>>>>>>> testbranch

}
