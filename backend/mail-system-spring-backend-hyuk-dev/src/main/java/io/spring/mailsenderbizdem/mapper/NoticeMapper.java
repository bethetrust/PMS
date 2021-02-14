package io.spring.mailsenderbizdem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import io.spring.mailsenderbizdem.dto.NoticeDto;

@Repository
@Mapper
public interface NoticeMapper {
<<<<<<< HEAD
	
	   List<NoticeDto> selectNoticeAll();
	
	
	

}
=======
	List<NoticeDto> selectNoticeAll(NoticeDto notice);
	int selectNoticeAllCount(NoticeDto notice);

}
>>>>>>> testbranch
