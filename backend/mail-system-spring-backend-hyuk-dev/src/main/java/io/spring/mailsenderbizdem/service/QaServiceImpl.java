package io.spring.mailsenderbizdem.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.mailsenderbizdem.dto.QaDto;
import io.spring.mailsenderbizdem.mapper.QaMapper;

@Service
public class QaServiceImpl implements QaService {

	@Autowired
	private QaMapper qaMapper;
	
	
	
	@Override
<<<<<<< HEAD
	public List<QaDto> selectQaAll(int userNo) {
		return qaMapper.selectQaAll(userNo);
=======
	public List<QaDto> selectQaAll(QaDto qa) {
		return qaMapper.selectQaAll(qa);
>>>>>>> testbranch
	}

	@Override
	public void insertQa(QaDto qaDto) {
		qaMapper.insertQa(qaDto);
		
	}

	@Override
	public void updateQa(QaDto qaDto) {
		qaMapper.updateQa(qaDto);
		
	}

	@Override
	public Map<QaDto, String> selectQaTest(int userNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QaDto selectOneQa(int parsedQaNo) {
		return qaMapper.selectOneQa(parsedQaNo);
	}
<<<<<<< HEAD
=======

	@Override
	public int selectQaAllCount(QaDto qa) {
		return qaMapper.selectQaAllCount(qa);
	}
>>>>>>> testbranch
	

}
  