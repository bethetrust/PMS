package io.spring.mailsenderbizdem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import io.spring.mailsenderbizdem.dto.AddressGroupDto;

@Repository
@Mapper
public interface AddressGroupMapper {
    @Options(useGeneratedKeys = true, keyProperty = "groupNo")
    void insertAddressGroup(AddressGroupDto addressGroup);
    void updateAddressGroup(AddressGroupDto addressGroup);
    void deleteAddressGroup(int groupNo);
    int selectAddressGroupAllCount(AddressGroupDto addressGroup);
    List<AddressGroupDto> selectAddressGroupAll(AddressGroupDto addressGroup);
    AddressGroupDto selectOneAddressGroup(int groupNo);
    List<AddressGroupDto> selectGroupDetailByGroupOwner(int groupOwner);
}
