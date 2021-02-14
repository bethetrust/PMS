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
public class MailTemplateDto {
    
    private int tplNo;
    private String tplSub;
    private String tplDesc;
    private String tplContent;
    private String tplImagesDir;
    private int tplUserNo;
    private int useStatus;
    private Date regDate;
    private int regId;
    private Date editDate;
    private int editor;

    // plus for common select 
    int pageStart;
    int pageCount = 10;
    int recordCount = 0;
}
