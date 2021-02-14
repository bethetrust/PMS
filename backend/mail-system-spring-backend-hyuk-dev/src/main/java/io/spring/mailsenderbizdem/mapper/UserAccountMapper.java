package io.spring.mailsenderbizdem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import io.spring.mailsenderbizdem.dto.UserAccountDto;

@Repository
@Mapper
public interface UserAccountMapper {
    List<UserAccountDto> selectAccountAll();
    UserAccountDto selectOneByUserById(String userId);
    void insertUserByCustomUserDetail(UserAccountDto userAccountDto);
}
