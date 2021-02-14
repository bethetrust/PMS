package io.spring.mailsenderbizdem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import io.spring.mailsenderbizdem.dto.AddressbookDto;

@Repository
@Mapper
public interface AddressbookMapper {
    @Options(useGeneratedKeys = true, keyProperty = "addrNo")
    void insertAddressbook(AddressbookDto addressbook);
    void updateAddressbook(AddressbookDto addressbook);
    void deleteAddressbook(int addrNo);
    List<AddressbookDto> selectAddressbookAll(AddressbookDto addressbook);
    int selectAddressbookAllCount(AddressbookDto addressbook);
    AddressbookDto selectOneAddressbook(int addrNo);
    List<AddressbookDto> selectAddrDetailByGroupOwner(AddressbookDto addressbook);
    List<AddressbookDto> selectAddrDetailOrderByAddrGroupNo(AddressbookDto addressbook);
    
}
