package io.spring.mailsenderbizdem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.spring.mailsenderbizdem.dto.UserAccountDto;
import io.spring.mailsenderbizdem.mapper.UserAccountMapper;

@Service
public class UserAccountServiceImpl implements UserDetailsService, UserAccountService {

    @Autowired
    public UserAccountMapper userAccountMapper;

    @Override
    public UserAccountDto loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserAccountDto users = userAccountMapper.selectOneByUserById(userId);
		if(users == null) {
          //  throw new UsernameNotFoundException("username " + userId + " not found");
            return null;
        }
		System.out.println("**************Found user***************");
		System.out.println("id : " + users.getUserId());
		return users;
    }

    @Override
    public List<UserAccountDto> selectAccountAll() {
        return userAccountMapper.selectAccountAll();
    }
    
}
