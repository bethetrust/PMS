package io.spring.mailsenderbizdem.controller;

import java.security.Principal;
<<<<<<< HEAD
import java.sql.SQLException;
=======
>>>>>>> testbranch
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.mailsenderbizdem.config.security.JwtTokenProvider;
<<<<<<< HEAD
import io.spring.mailsenderbizdem.dto.QaDto;
import io.spring.mailsenderbizdem.dto.UserAccountDto;
import io.spring.mailsenderbizdem.mapper.UserAccountMapper;
import io.spring.mailsenderbizdem.message.ResponseMessage;
import io.spring.mailsenderbizdem.message.StatusEnum;
=======
import io.spring.mailsenderbizdem.dto.UserAccountDto;
import io.spring.mailsenderbizdem.mapper.UserAccountMapper;
>>>>>>> testbranch
import io.spring.mailsenderbizdem.service.UserAccountService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
public class UserAccountController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private UserAccountService userAccountService;

    // 회원가입
<<<<<<< HEAD
    @PostMapping("/user/join")
    public ResponseMessage join(@RequestBody Map<String, String> userInfo) {
    	
    	ResponseMessage message = new ResponseMessage();
		
		try {
			Map<String, String> resultMap = new HashMap<>();
	        UserAccountDto user = UserAccountDto.builder()
	                                .userId(userInfo.get("userId"))
	                                .userPw(passwordEncoder.encode(userInfo.get("userPw")))
	                                .userDpt(userInfo.get("userDpt"))
	                                .userEmail(userInfo.get("userEmail"))
	                                .userNm(userInfo.get("userNm"))
	                                .userPhone(userInfo.get("userPhone"))
	                                .regDate((new Date()))
	                                .regId(0)
	                                .role("USER")
	                                .build();
	        
	        userAccountMapper.insertUserByCustomUserDetail(user);
	        
	        message.setData(user);
			
		} catch (Exception e) {
			 message.setMessage("서버와의 연결이 불안정합니다.");
	         message.setStatus(StatusEnum.NOT_FOUND);
	            
	         e.printStackTrace();
	         
	         return message;
		}
		
		message.setMessage("회원가입이 완료되었습니다.");
        message.setStatus(StatusEnum.OK);
		
		
		return message;
	}
    	
    	
    	
    	

=======
    @PostMapping("/join")
    public Map<String,String> join(@RequestBody Map<String, String> userInfo) {
        Map<String, String> resultMap = new HashMap<>();
        UserAccountDto user = UserAccountDto.builder()
                                .userId(userInfo.get("userId"))
                                .userPw(passwordEncoder.encode(userInfo.get("userPw")))
                                .userDpt(userInfo.get("userDpt"))
                                .userEmail(userInfo.get("userEmail"))
                                .userNm(userInfo.get("userNm"))
                                .userPhone(userInfo.get("userPhone"))
                                .regDate((new Date()))
                                .regId(0)
                                .role("USER")
                                .build();
        userAccountMapper.insertUserByCustomUserDetail(user);
        resultMap.put("result", "success");
        return resultMap;
    }
>>>>>>> testbranch

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        UserAccountDto userDto = userAccountService.loadUserByUsername(user.get("userId"));
        if(userDto==null) return "userIdWrong";
        if(!passwordEncoder.matches(user.get("userPw"), userDto.getPassword())) {
            return "userPwWrong";
        }
        return jwtTokenProvider.createToken(userDto.getUsername(), userDto.getRole());
    }

    // 로그아웃
    // @GetMapping("/user/logout")
    // public String logout() {

    // }
    
    //확인
    // @GetMapping("/confirm")
    // public String confirm(Principal principal,@RequestHeader("X-AUTH-TOKEN") String jwtToken) {
    //     System.out.println(principal.getName());
    //     return jwtToken;
    // }
}
