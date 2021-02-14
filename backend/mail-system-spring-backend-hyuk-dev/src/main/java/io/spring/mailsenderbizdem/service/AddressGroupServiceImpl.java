package io.spring.mailsenderbizdem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.mailsenderbizdem.dto.AddressGroupDto;
import io.spring.mailsenderbizdem.mapper.AddressGroupMapper;

@Service
public class AddressGroupServiceImpl implements AddressGroupService {

    @Autowired
    AddressGroupMapper addressGroupMapper;

    @Override
    public void insertAddressGroup(AddressGroupDto addressGroup) {
        addressGroupMapper.insertAddressGroup(addressGroup);

    }

    @Override
    public void updateAddressGroup(AddressGroupDto addressGroup) {
        addressGroupMapper.updateAddressGroup(addressGroup);
    }

    @Override
    public void deleteAddressGroup(int groupNo) {
        addressGroupMapper.deleteAddressGroup(groupNo);
    }

    @Override
    public List<AddressGroupDto> selectAddressGroupAll(AddressGroupDto addressGroup) {
        return addressGroupMapper.selectAddressGroupAll(addressGroup);
    }

    @Override
    public AddressGroupDto selectOneAddressGroup(int groupNo) {
        return addressGroupMapper.selectOneAddressGroup(groupNo);
    }

    @Override
    public List<AddressGroupDto> selectGroupDetailByGroupOwner(int groupOwner) {
        return addressGroupMapper.selectGroupDetailByGroupOwner(groupOwner);
    }

    @Override
    public int selectAddressGroupAllCount(AddressGroupDto addressGroup) {
        return addressGroupMapper.selectAddressGroupAllCount(addressGroup);
    }
    
}
