package io.spring.mailsenderbizdem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.mailsenderbizdem.dto.AddressbookDto;
import io.spring.mailsenderbizdem.mapper.AddressbookMapper;

@Service
public class AddressbookServiceImpl implements AddressbookService {

    @Autowired
    AddressbookMapper addressbookMapper;

	@Override
	public void insertAddressbook(AddressbookDto addressbook) {
		addressbookMapper.insertAddressbook(addressbook);
	}

	@Override
	public void updateAddressbook(AddressbookDto addressbook) {
		addressbookMapper.updateAddressbook(addressbook);
	}

	@Override
	public void deleteAddressbook(int addrNo) {
		addressbookMapper.deleteAddressbook(addrNo);
	}

	@Override
	public List<AddressbookDto> selectAddressbookAll(AddressbookDto addressbook) {
		return addressbookMapper.selectAddressbookAll(addressbook);
	}

	@Override
	public AddressbookDto selectOneAddressbook(int addrNo) {
		return addressbookMapper.selectOneAddressbook(addrNo);
	}

	@Override
	public List<AddressbookDto> selectAddrDetailByGroupOwner(AddressbookDto addressbook) {
		return addressbookMapper.selectAddrDetailByGroupOwner(addressbook);
	}

	@Override
	public List<AddressbookDto> selectAddrDetailOrderByAddrGroupNo(AddressbookDto addressbook) {
		return addressbookMapper.selectAddrDetailOrderByAddrGroupNo(addressbook);
	}

	@Override
	public int selectAddressbookAllCount(AddressbookDto addressbook) {
		return addressbookMapper.selectAddressbookAllCount(addressbook);
	}
}
