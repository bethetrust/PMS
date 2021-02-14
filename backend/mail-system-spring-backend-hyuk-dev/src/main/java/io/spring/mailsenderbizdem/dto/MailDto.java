package io.spring.mailsenderbizdem.dto;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailDto {

	private String address;
<<<<<<< HEAD
	private String[] ccs;
	private String title;
	private String message;
	private File htmlTemplate;
	private int sendRecNo;
=======
	private String title;
	private String message;
	private File htmlTemplate;

	private int sendRecNo;

>>>>>>> testbranch
	
}