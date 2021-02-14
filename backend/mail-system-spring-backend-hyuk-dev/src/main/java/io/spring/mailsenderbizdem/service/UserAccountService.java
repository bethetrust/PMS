package io.spring.mailsenderbizdem.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import io.spring.mailsenderbizdem.dto.UserAccountDto;

public interface UserAccountService {
    public List<UserAccountDto> selectAccountAll();
    public UserAccountDto loadUserByUsername(String userId);
    
}
