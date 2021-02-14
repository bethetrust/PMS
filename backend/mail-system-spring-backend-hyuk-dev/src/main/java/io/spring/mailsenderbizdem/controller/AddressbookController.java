package io.spring.mailsenderbizdem.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.spring.mailsenderbizdem.dto.AddressbookDto;
import io.spring.mailsenderbizdem.dto.UserAccountDto;
import io.spring.mailsenderbizdem.mapper.AddressbookMapper;
import io.spring.mailsenderbizdem.mapper.UserAccountMapper;
import io.spring.mailsenderbizdem.message.ResponseMessage;
import io.spring.mailsenderbizdem.message.StatusEnum;
import io.spring.mailsenderbizdem.service.AddressbookService;

@RestController
@CrossOrigin("*")
public class AddressbookController {
<<<<<<< HEAD
    
=======

>>>>>>> testbranch
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private AddressbookService addressbookService;

    public UserAccountDto getUser(String userId) {
        return userAccountMapper.selectOneByUserById(userId);
    }

<<<<<<< HEAD
    
    // insert AddressGroup (AddressGroup 저장(생성))
    @Transactional
    @PostMapping("/user/insertAddressbook")
    public ResponseMessage insertAddressbook(@RequestBody Map<String,Object> addressbookInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            } 
            
            int userNo = user.getUserNo();
            AddressbookDto addressbook =  AddressbookDto.builder()
                            .addrGroupNo(Integer.parseInt(addressbookInfo.get("addrGroupNo").toString()))
                            .addrEmail(addressbookInfo.get("addrEmail").toString())
                            .addrNm(addressbookInfo.get("addrNm").toString())
                            .addrOwner(userNo)
                            .regDate(new Date())
                            .regId(userNo)
                            .build();

            // Save(Insert)                
                
            addressbookService.insertAddressbook(addressbook);
            message.setData(addressbook);
            

        }catch(Exception ex) {
            message.setMessage("해당 아이디로 등록이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            
            ex.printStackTrace();
=======
    // insert AddressGroup (AddressGroup 저장(생성))
    @Transactional
    @PostMapping("/user/insertAddressbook")
    public ResponseMessage insertAddressbook(@RequestBody Map<String, Object> addressbookInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if (user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }

            int userNo = user.getUserNo();
            AddressbookDto addressbook = AddressbookDto.builder()
                    .addrGroupNo(Integer.parseInt(addressbookInfo.get("addrGroupNo").toString()))
                    .addrEmail(addressbookInfo.get("addrEmail").toString())
                    .addrNm(addressbookInfo.get("addrNm").toString()).addrOwner(userNo).regDate(new Date())
                    .regId(userNo).build();

            // Save(Insert)

            addressbookService.insertAddressbook(addressbook);
            message.setData(addressbook);

        } catch (NullPointerException ex) {
            message.setMessage("해당 아이디로 등록이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            return message;

        } catch (Exception ex) {
            message.setMessage("오류가 발생했습니다.");
            message.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
>>>>>>> testbranch
            return message;
        }
        message.setMessage("저장 완료");
        message.setStatus(StatusEnum.OK);
        return message;
    }

    @Transactional
    @PostMapping("/user/updateAddressbook")
<<<<<<< HEAD
    public ResponseMessage updateAddressbook(@RequestBody Map<String,Object> addressbookInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            } 
            
            int userNo = user.getUserNo();
            AddressbookDto addressbook =  AddressbookDto.builder()
                            .editDate(new Date())
                            .editor(userNo)
                            .addrOwner(userNo)
                            .addrGroupNo(Integer.parseInt(addressbookInfo.get("addrGroupNo").toString()))
                            .addrEmail(addressbookInfo.get("addrEmail").toString())
                            .addrNm(addressbookInfo.get("addrNm").toString())
                            .addrNo(Integer.parseInt(addressbookInfo.get("addrNo").toString()))
                            .build();

            addressbookService.updateAddressbook(addressbook);
            message.setData(addressbook.getEditDate());
            

        }catch(Exception ex) {
            message.setMessage("해당 아이디로 등록이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            
            ex.printStackTrace();
=======
    public ResponseMessage updateAddressbook(@RequestBody Map<String, Object> addressbookInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if (user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }

            int userNo = user.getUserNo();
            AddressbookDto addressbook = AddressbookDto.builder().editDate(new Date()).editor(userNo).addrOwner(userNo)
                    .addrGroupNo(Integer.parseInt(addressbookInfo.get("addrGroupNo").toString()))
                    .addrEmail(addressbookInfo.get("addrEmail").toString())
                    .addrNm(addressbookInfo.get("addrNm").toString())
                    .addrNo(Integer.parseInt(addressbookInfo.get("addrNo").toString())).build();

            addressbookService.updateAddressbook(addressbook);
            message.setData(addressbook.getEditDate());

        } catch (NullPointerException ex) {
            message.setMessage("해당 아이디로 등록이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            return message;

        } catch (Exception ex) {
            message.setMessage("오류가 발생했습니다.");
            message.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
>>>>>>> testbranch
            return message;
        }
        message.setMessage("저장 완료");
        message.setStatus(StatusEnum.OK);
        return message;
    }

    @Transactional
    @PostMapping("/user/deleteAddressbook")
    public ResponseMessage deleteAddressbook(@RequestBody Map<String, Object> addressbookInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
<<<<<<< HEAD
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }     
             
            List list = (ArrayList)addressbookInfo.get("addressbookNos");
            list.forEach(item->{
                int parsedAddressbookNo = Integer.parseInt(item.toString());
                addressbookService.deleteAddressbook(parsedAddressbookNo);
            });
            
        } catch(Exception ex) {
            message.setMessage("해당 아이디로 삭제가 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setData(null);
=======
            if (user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }

            List list = (ArrayList) addressbookInfo.get("addressbookNos");
            list.forEach(item -> {
                int parsedAddressbookNo = Integer.parseInt(item.toString());
                addressbookService.deleteAddressbook(parsedAddressbookNo);
            });

        } catch (NullPointerException ex) {
            message.setMessage("해당 아이디로 등록이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            return message;

        } catch (Exception ex) {
            message.setMessage("오류가 발생했습니다.");
            message.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
>>>>>>> testbranch
            return message;
        }

        message.setMessage("삭제 완료");
        message.setData(null);
        message.setStatus(StatusEnum.OK);
        return message;
    }

<<<<<<< HEAD
    //selectOne
    @Transactional
    @PostMapping("/user/selectOneAddressbook")
    public ResponseMessage selectOneAddressbook(@RequestBody Map<String,String> addressbookInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            int parsedAddrNo = Integer.parseInt(addressbookInfo.get("addrNo").toString());
            AddressbookDto addressbook = addressbookService.selectOneAddressbook(parsedAddrNo);
            message.setData(addressbook);
        } catch(Exception ex) {
            message.setMessage("해당 아이디로 조회가 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setData(null);
=======
    // selectOne
    @Transactional
    @PostMapping("/user/selectOneAddressbook")
    public ResponseMessage selectOneAddressbook(@RequestBody Map<String, String> addressbookInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if (user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }
            int parsedAddrNo = Integer.parseInt(addressbookInfo.get("addrNo").toString());
            AddressbookDto addressbook = addressbookService.selectOneAddressbook(parsedAddrNo);
            message.setData(addressbook);
        } catch (NullPointerException ex) {
            message.setMessage("해당 아이디로 등록이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            return message;

        } catch (Exception ex) {
            message.setMessage("오류가 발생했습니다.");
            message.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
>>>>>>> testbranch
            return message;
        }

        message.setMessage("조회 완료");
        message.setStatus(StatusEnum.OK);
        return message;
    }

<<<<<<< HEAD
    //selectAll
    @Transactional
    @PostMapping("/user/selectAddressbookAll")
    public ResponseMessage selectAddressbookAll(@RequestBody Map<String,String> addressbookInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            int userNo = user.getUserNo();
            String addrEmail = (addressbookInfo.containsKey("addrEmail")) ? addressbookInfo.get("addrEmail").toString() : null;
            String addrGroupNm =  (addressbookInfo.containsKey("addrGroupNm") ) ? addressbookInfo.get("addrGroupNm").toString() : null;
            int addrGroupNo =  (addressbookInfo.containsKey("addrGroupNo") ) ? Integer.parseInt(addressbookInfo.get("addrGroupNo")) : 0;
            String addrNm =  (addressbookInfo.containsKey("addrNm") ) ? addressbookInfo.get("addrNm").toString() : null;
            int addrNo =  (addressbookInfo.containsKey("addrNo") ) ? Integer.parseInt(addressbookInfo.get("addrNo")) : 0;
            int pageStart =  (addressbookInfo.containsKey("pageStart") ) ? Integer.parseInt(addressbookInfo.get("pageStart")) : 0;
  
            AddressbookDto address = AddressbookDto.builder()
                                    .addrEmail(addrEmail)
                                    .addrGroupNm(addrGroupNm)
                                    .addrGroupNo(addrGroupNo)
                                    .addrNm(addrNm)
                                    .addrNo(addrNo)
                                    .addrOwner(userNo)
                                    .build();
                                    
            int pageCount =  (addressbookInfo.containsKey("pageCount") ) ? Integer.parseInt(addressbookInfo.get("pageCount")) : 10;
            address.setPageStart(pageStart * pageCount);
            address.setPageCount(pageCount);
            List<AddressbookDto> addressbookList = addressbookService.selectAddressbookAll(address);
            
            if(addressbookList.size() > 0) {
=======
    // selectAll
    @Transactional
    @PostMapping("/user/selectAddressbookAll")
    public ResponseMessage selectAddressbookAll(@RequestBody Map<String, String> addressbookInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if (user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }
            int userNo = user.getUserNo();
            String addrEmail = (addressbookInfo.containsKey("addrEmail")) ? addressbookInfo.get("addrEmail").toString()
                    : null;
            String addrGroupNm = (addressbookInfo.containsKey("addrGroupNm"))
                    ? addressbookInfo.get("addrGroupNm").toString()
                    : null;
            int addrGroupNo = (addressbookInfo.containsKey("addrGroupNo"))
                    ? Integer.parseInt(addressbookInfo.get("addrGroupNo"))
                    : 0;
            String addrNm = (addressbookInfo.containsKey("addrNm")) ? addressbookInfo.get("addrNm").toString() : null;
            int addrNo = (addressbookInfo.containsKey("addrNo")) ? Integer.parseInt(addressbookInfo.get("addrNo")) : 0;
            int pageStart = (addressbookInfo.containsKey("pageStart"))
                    ? Integer.parseInt(addressbookInfo.get("pageStart"))
                    : 0;

            AddressbookDto address = AddressbookDto.builder().addrEmail(addrEmail).addrGroupNm(addrGroupNm)
                    .addrGroupNo(addrGroupNo).addrNm(addrNm).addrNo(addrNo).addrOwner(userNo).build();

            int pageCount = (addressbookInfo.containsKey("pageCount"))
                    ? Integer.parseInt(addressbookInfo.get("pageCount"))
                    : 10;
            address.setPageStart(pageStart * pageCount);
            address.setPageCount(pageCount);
            List<AddressbookDto> addressbookList = addressbookService.selectAddressbookAll(address);

            if (addressbookList.size() > 0) {
>>>>>>> testbranch
                AddressbookDto addr = addressbookList.get(0);
                int recordCount = addressbookService.selectAddressbookAllCount(address);
                addr.setRecordCount(recordCount);
                addressbookList.set(0, addr);
            }
<<<<<<< HEAD
            
            message.setData(addressbookList);

        } catch(Exception ex) {
            ex.printStackTrace();
            message.setMessage("해당 아이디로 조회가 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setData(null);
=======

            message.setData(addressbookList);

        } catch (NullPointerException ex) {
            message.setMessage("해당 아이디로 등록이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            return message;

        } catch (Exception ex) {
            message.setMessage("오류가 발생했습니다.");
            message.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
>>>>>>> testbranch
            return message;
        }

        message.setMessage("조회 완료");
        message.setStatus(StatusEnum.OK);
        return message;
    }

    // select group by ADDR_GROUP_NO, ORDER BY ADDR_GROUP_NO
    @Transactional
    @PostMapping("/user/selectAddrDetailOrderByAddrGroupNo")
<<<<<<< HEAD
    public ResponseMessage selectAddrDetailOrderByAddrGroupNo(@RequestBody Map<String,String> addressbookInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            int userNo = user.getUserNo();
            String addrEmail = (addressbookInfo.containsKey("addrEmail")) ? addressbookInfo.get("addrEmail").toString() : null;
            String addrGroupNm =  (addressbookInfo.containsKey("addrGroupNm") ) ? addressbookInfo.get("addrGroupNm").toString() : null;
            int addrGroupNo =  (addressbookInfo.containsKey("addrGroupNo") ) ? Integer.parseInt(addressbookInfo.get("addrGroupNo")) : 0;
            String addrNm =  (addressbookInfo.containsKey("addrNm") ) ? addressbookInfo.get("addrNm").toString() : null;
            int addrNo =  (addressbookInfo.containsKey("addrNo") ) ? Integer.parseInt(addressbookInfo.get("addrNo")) : 0;
            AddressbookDto address = AddressbookDto.builder()
                                    .addrEmail(addrEmail)
                                    .addrGroupNm(addrGroupNm)
                                    .addrGroupNo(addrGroupNo)
                                    .addrNm(addrNm)
                                    .addrNo(addrNo)
                                    .addrOwner(userNo)
                                    .build();
            List<AddressbookDto> addressbookList = addressbookService.selectAddrDetailOrderByAddrGroupNo(address);
            message.setData(addressbookList);
        } catch(Exception ex) {
            ex.printStackTrace();
            message.setMessage("해당 아이디로 조회가 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setData(null);
=======
    public ResponseMessage selectAddrDetailOrderByAddrGroupNo(@RequestBody Map<String, String> addressbookInfo,
            Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if (user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }
            int userNo = user.getUserNo();
            String addrEmail = (addressbookInfo.containsKey("addrEmail")) ? addressbookInfo.get("addrEmail").toString()
                    : null;
            String addrGroupNm = (addressbookInfo.containsKey("addrGroupNm"))
                    ? addressbookInfo.get("addrGroupNm").toString()
                    : null;
            int addrGroupNo = (addressbookInfo.containsKey("addrGroupNo"))
                    ? Integer.parseInt(addressbookInfo.get("addrGroupNo"))
                    : 0;
            String addrNm = (addressbookInfo.containsKey("addrNm")) ? addressbookInfo.get("addrNm").toString() : null;
            int addrNo = (addressbookInfo.containsKey("addrNo")) ? Integer.parseInt(addressbookInfo.get("addrNo")) : 0;
            AddressbookDto address = AddressbookDto.builder().addrEmail(addrEmail).addrGroupNm(addrGroupNm)
                    .addrGroupNo(addrGroupNo).addrNm(addrNm).addrNo(addrNo).addrOwner(userNo).build();
            List<AddressbookDto> addressbookList = addressbookService.selectAddrDetailOrderByAddrGroupNo(address);
            message.setData(addressbookList);
        } catch (NullPointerException ex) {
            message.setMessage("해당 아이디로 등록이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            return message;

        } catch (Exception ex) {
            message.setMessage("오류가 발생했습니다.");
            message.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
>>>>>>> testbranch
            return message;
        }

        message.setMessage("조회 완료");
        message.setStatus(StatusEnum.OK);
        return message;
    }
<<<<<<< HEAD
    
=======

>>>>>>> testbranch
}
