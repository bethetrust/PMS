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
public class AddressGroupDto {
    int groupNo;
    String groupNm;
    String groupDesc;
    int groupOwner;
    int useStatus;
    Date regDate;
    int regId;
    Date editDate;
    int editor;

    // plus for select
    int addrCount;
    
    // plus for common select 
    int pageStart;
    int pageCount = 10;
    int recordCount = 0;
}
