package io.spring.mailsenderbizdem.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ResponseMessage  {
    private StatusEnum status;
    private Object data;
    private String message;
}
