package io.spring.mailsenderbizdem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import io.spring.mailsenderbizdem.dto.NoticeDto;
import io.spring.mailsenderbizdem.dto.QaDto;


@Repository
@Mapper
public interface QaMapper {
	 // 각 userId 전체 qa 조회
<<<<<<< HEAD
	 List<QaDto> selectQaAll(int userNo);
=======
	//  List<QaDto> selectQaAll(QaDto userNo);
>>>>>>> testbranch
	 
	 // insert qa
	 void insertQa(QaDto qaDto);

	 void updateQa(QaDto qaDto);

	QaDto selectOneQa(int parsedQaNo);

<<<<<<< HEAD
=======
	List<QaDto> selectQaAll(QaDto qa);
	int selectQaAllCount(QaDto qa);

>>>>>>> testbranch
}
