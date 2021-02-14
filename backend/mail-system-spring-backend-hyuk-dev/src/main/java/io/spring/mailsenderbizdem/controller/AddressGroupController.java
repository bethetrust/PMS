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

import io.spring.mailsenderbizdem.dto.AddressGroupDto;
import io.spring.mailsenderbizdem.dto.AddressbookDto;
import io.spring.mailsenderbizdem.dto.UserAccountDto;
import io.spring.mailsenderbizdem.mapper.AddressGroupMapper;
import io.spring.mailsenderbizdem.mapper.AddressbookMapper;
import io.spring.mailsenderbizdem.mapper.UserAccountMapper;
import io.spring.mailsenderbizdem.message.ResponseMessage;
import io.spring.mailsenderbizdem.message.StatusEnum;
import io.spring.mailsenderbizdem.service.AddressGroupService;
import io.spring.mailsenderbizdem.service.AddressbookService;

@RestController
@CrossOrigin("*")
public class AddressGroupController {
    
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private AddressGroupService addressGroupService;

    @Autowired
    private AddressbookService addressbookService;

    public UserAccountDto getUser(String userId) {
        return userAccountMapper.selectOneByUserById(userId);
    }
    
    // insert AddressGroup (AddressGroup 저장(생성))
    @Transactional
    @PostMapping("/user/updateAddressGroup")
    public ResponseMessage updateAddressGroup(@RequestBody Map<String,Object> addressGroupInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            } 
            
            int userNo = user.getUserNo();
            AddressGroupDto addressGroup =  AddressGroupDto.builder()
                            .groupNo(Integer.parseInt(addressGroupInfo.get("groupNo").toString()))
                            .groupNm(addressGroupInfo.get("groupNm").toString())
                            .groupDesc(addressGroupInfo.get("groupDesc").toString())
                            .groupOwner(userNo)
                            .editDate(new Date())
                            .editor(userNo)
                            .build();

            addressGroupService.updateAddressGroup(addressGroup);
            message.setData(addressGroup.getEditDate());
            

<<<<<<< HEAD
        }catch(Exception ex) {
            message.setMessage("해당 아이디로 등록이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            
            ex.printStackTrace();
=======
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

    // insert AddressGroup (AddressGroup 저장(생성))
    @Transactional
    @PostMapping("/user/insertAddressGroup")
    public ResponseMessage insertAddressGroup(@RequestBody Map<String,Object> addressGroupInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            } 
            
            int userNo = user.getUserNo();
            AddressGroupDto addressGroup =  AddressGroupDto.builder()
                            .groupNm(addressGroupInfo.get("groupNm").toString())
                            .groupDesc(addressGroupInfo.get("groupDesc").toString())
                            .groupOwner(userNo)
                            .regDate(new Date())
                            .regId(userNo)
                            .build();

            // Save(Insert)                
                
            addressGroupService.insertAddressGroup(addressGroup);
            message.setData(addressGroup);
            

<<<<<<< HEAD
        }catch(Exception ex) {
            message.setMessage("해당 아이디로 등록이 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            
            ex.printStackTrace();
=======
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

    //selectOne
    @Transactional
    @PostMapping("/user/selectOneAddressGroup")
    public ResponseMessage selectOneAddressGroup(@RequestBody Map<String,String> addressGroupInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            int parsedGroupNo = Integer.parseInt(addressGroupInfo.get("groupNo").toString());
            AddressGroupDto addressGroup = addressGroupService.selectOneAddressGroup(parsedGroupNo);
            message.setData(addressGroup);
<<<<<<< HEAD
        } catch(Exception ex) {
            message.setMessage("해당 아이디로 조회가 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setData(null);
=======
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

    // delete
    @Transactional
    @PostMapping("/user/deleteAddressGroup")
    public ResponseMessage deleteAddressGroup(@RequestBody Map<String, Object> addressGroupInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            List list = (ArrayList)addressGroupInfo.get("addressGroupNos");
            list.forEach(item->{
                int addressGroupNo = Integer.parseInt(item.toString());
                AddressbookDto addressbook = new AddressbookDto();
                addressbook.setAddrGroupNo(addressGroupNo);
                addressbook.setAddrOwner(user.getUserNo());
                addressbook.setPageCount(0);
                List<AddressbookDto> addressbookList = addressbookService.selectAddressbookAll(addressbook);
                addressbookList.forEach(addr -> {
                    addressbookService.deleteAddressbook(addr.getAddrNo());
                });
                addressGroupService.deleteAddressGroup(addressGroupNo);
            });
            
<<<<<<< HEAD
        } catch(Exception ex) {
            message.setMessage("해당 아이디로 삭제가 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setData(null);
=======
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

    //selectAll
    @Transactional
    @PostMapping("/user/selectAddressGroupAll")
    public ResponseMessage selectAddressGroupAll(@RequestBody Map<String,String> addressGroupInfo, Principal principal) {
        ResponseMessage message = new ResponseMessage();
        try {
            UserAccountDto user = getUser(principal.getName());
            if(user == null) {
                throw new SQLException("해당 아이디를 찾을 수 없습니다.");
            }      
            String groupNm = (addressGroupInfo.containsKey("groupNm")) ? addressGroupInfo.get("groupNm").toString() : null;
            int pageStart =  (addressGroupInfo.containsKey("pageStart") ) ? Integer.parseInt(addressGroupInfo.get("pageStart")) : 0;
            
            AddressGroupDto addressGroup = AddressGroupDto.builder()
                                        .groupNm(groupNm)
                                        .groupOwner(user.getUserNo())
                                        .build();

            int pageCount =  (addressGroupInfo.containsKey("pageCount") ) ? Integer.parseInt(addressGroupInfo.get("pageCount")) : 10;
            addressGroup.setPageStart(pageStart * pageCount);
            addressGroup.setPageCount(pageCount);
            List<AddressGroupDto> addressGroupList = addressGroupService.selectAddressGroupAll(addressGroup);
            
            if(addressGroupList.size() > 0) {
                AddressGroupDto addrGroup = addressGroupList.get(0);
                int recordCount = addressGroupService.selectAddressGroupAllCount(addressGroup);
                addrGroup.setRecordCount(recordCount);
                addressGroupList.set(0, addrGroup);
            }

            message.setData(addressGroupList);
            message.setMessage("조회 완료");
            message.setStatus(StatusEnum.OK);
            return message;
<<<<<<< HEAD
        } catch(Exception ex) {
            ex.printStackTrace();
            message.setMessage("해당 아이디로 조회가 불가능 합니다.");
            message.setStatus(StatusEnum.NOT_FOUND);
            message.setData(null);
=======
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
    }

     //selectAll
     @Transactional
     @PostMapping("/user/selectGroupDetailByGroupOwner")
     public ResponseMessage selectGroupDetailByGroupOwner(@RequestBody Map<String,String> addressGroupInfos, Principal principal) {
         ResponseMessage message = new ResponseMessage();
         try {
             UserAccountDto user = getUser(principal.getName());
             if(user == null) {
                 throw new SQLException("해당 아이디를 찾을 수 없습니다.");
             }      
             int parsedGroupOwner = user.getUserNo();
             List<AddressGroupDto> addressGroupList = addressGroupService.selectGroupDetailByGroupOwner(parsedGroupOwner);
             message.setData(addressGroupList);
<<<<<<< HEAD
         } catch(Exception ex) {
             message.setMessage("해당 아이디로 조회가 불가능 합니다.");
             message.setStatus(StatusEnum.NOT_FOUND);
             message.setData(null);
             return message;
         }
=======
            } catch (NullPointerException ex) {
                message.setMessage("해당 아이디로 등록이 불가능 합니다.");
                message.setStatus(StatusEnum.NOT_FOUND);
                return message;
    
            } catch (Exception ex) {
                message.setMessage("해당 아이디로 등록이 불가능 합니다.");
                message.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
                return message;
            }
>>>>>>> testbranch
 
         message.setMessage("조회 완료");
         message.setStatus(StatusEnum.OK);
         return message;
     }
    
}
