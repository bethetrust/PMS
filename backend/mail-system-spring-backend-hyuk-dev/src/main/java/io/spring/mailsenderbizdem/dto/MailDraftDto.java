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
public class MailDraftDto {
    private int draftNo;
    private String draftTitle;
    private String draftDesc;
    private String draftReceiver;
    private int draftSenderNo;
    private String draftReference;
    private String draftAttach;
    private int useStatus;
    private Date regDate;
    private int regId;
    private Date editDate;
    private int editor;

    private int draftTplNo;

    // pluf for select
    private String startDate;
    private String endDate;
    
    // plus for common select 
    int pageStart;
    int pageCount = 10;
    int recordCount = 0;
}