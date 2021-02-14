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
public class SendRecordDto {    
    private int sendRecNo;
    private String sendRecTitle;
    private String sendRecContent;
    private String sendRecReceiver;
    private int sendRecSenderNo;
    private String sendRecRefference;
    private String sendRecAttach;
    private int useStatus;
    private Date regDate;
    private int regId;
    private Date editDate;
    private int editor;
    private int sendRecTplNo;

<<<<<<< HEAD
=======


>>>>>>> testbranch
    // pluf for select
    private String startDate;
    private String endDate;
    private String tplTitle;

<<<<<<< HEAD
    // plus for common select 
=======

    // plus for common select 

>>>>>>> testbranch
    private int pageStart;
    private int pageCount = 10;
    private int recordCount = 0;

<<<<<<< HEAD

=======
>>>>>>> testbranch
}
