package io.spring.mailsenderbizdem.service;

import java.util.List;
import java.util.Map;

import io.spring.mailsenderbizdem.dto.QaDto;

public interface QaService {
	//전체 qa조회
<<<<<<< HEAD
	List<QaDto> selectQaAll(int userNo);
=======
	List<QaDto> selectQaAll(QaDto qa);
>>>>>>> testbranch
	
	//insert qa
	void insertQa(QaDto qaDto);

	void updateQa(QaDto qaDto);
	
	
	//test
	Map<QaDto, String> selectQaTest(int userNo);

	QaDto selectOneQa(int parsedQaNo);
<<<<<<< HEAD
=======

	int selectQaAllCount(QaDto qa);
>>>>>>> testbranch
	
}
