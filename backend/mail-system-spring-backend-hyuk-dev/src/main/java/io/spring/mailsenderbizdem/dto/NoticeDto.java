package io.spring.mailsenderbizdem.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeDto {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeAttach;
	private int useStatus;
	private Date regDate;
	private int regId;
	private Date editDate;
	private int editor;

<<<<<<< HEAD
=======
	// pluf for select
    private String startDate;
	private String endDate;
	
	 // plus for common select 
	 int pageStart;
	 int pageCount = 10;
	 int recordCount = 0;

>>>>>>> testbranch
}
