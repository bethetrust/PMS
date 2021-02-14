package io.spring.mailsenderbizdem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.mailsenderbizdem.dto.NoticeDto;
import io.spring.mailsenderbizdem.mapper.NoticeMapper;


@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	
	
	@Override
<<<<<<< HEAD
	public List<NoticeDto> selectNoticeAll() {
		return noticeMapper.selectNoticeAll();
=======
	public List<NoticeDto> selectNoticeAll(NoticeDto notice) {
		return noticeMapper.selectNoticeAll(notice);
	}

	@Override
	public int selectNoticeAllCount(NoticeDto notice) {
		return noticeMapper.selectNoticeAllCount(notice);
>>>>>>> testbranch
	}

}
