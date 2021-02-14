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
public class MailResponseDto {
    private int responseNo;
    private String receiverEmail;
    private String receiverName;
    private String receiverPhone;
    private int sendRecNo;
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
