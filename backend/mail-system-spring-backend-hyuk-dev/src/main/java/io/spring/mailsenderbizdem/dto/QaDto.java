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
public class QaDto {
	
	private int qaNo;
	private String qaTitle;
	private String qaContent;
	private String qaAttach;
	private String qaGroup;
	private String qaReplyContent;
	private int useStatus;
	private Date regDate;
	private int regId;
	private Date editDate;
	private int editor;
	

	
	//add data
	private String qaUserNm;
	private String replyYn;
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
