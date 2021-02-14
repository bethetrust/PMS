package io.spring.mailsenderbizdem.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressbookDto {
    int addrNo;
    String addrNm;
    String addrEmail;
    int addrGroupNo;
    int addrOwner;
    int useStatus;
    Date regDate;
    int regId;
    Date editDate;
    int editor;

    // plus for search
    String addrGroupNm;

    // plus for common select 
    int pageStart;
    int pageCount = 10;
    int recordCount = 0;
}
