package io.spring.mailsenderbizdem.service;

import java.util.List;

import io.spring.mailsenderbizdem.dto.AddressbookDto;

public interface AddressbookService {
    void insertAddressbook(AddressbookDto addressbook);
    void updateAddressbook(AddressbookDto addressbook);
    void deleteAddressbook(int addrNo);
    List<AddressbookDto> selectAddressbookAll(AddressbookDto addressbook);
    int selectAddressbookAllCount(AddressbookDto addressbook);
    AddressbookDto selectOneAddressbook(int addrNo);
    List<AddressbookDto> selectAddrDetailByGroupOwner(AddressbookDto addressbook);
    List<AddressbookDto> selectAddrDetailOrderByAddrGroupNo(AddressbookDto addressbook);
}
