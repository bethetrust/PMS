package io.spring.mailsenderbizdem.service;

import java.util.List;

import io.spring.mailsenderbizdem.dto.AddressGroupDto;

public interface AddressGroupService {
    void insertAddressGroup(AddressGroupDto addressGroup);
    void updateAddressGroup(AddressGroupDto addressGroup);
    void deleteAddressGroup(int groupNo);
    int selectAddressGroupAllCount(AddressGroupDto addressGroup);
    List<AddressGroupDto> selectAddressGroupAll(AddressGroupDto addressGroup);
    AddressGroupDto selectOneAddressGroup(int groupNo);
    List<AddressGroupDto> selectGroupDetailByGroupOwner(int groupOwner);
}
