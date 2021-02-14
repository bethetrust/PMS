package io.spring.mailsenderbizdem.dto;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Arrays;
>>>>>>> testbranch
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.mapping.FetchType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder 
@SuppressWarnings("serial")
public class UserAccountDto implements UserDetails {
    
    private int userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private String userPhone;
    private String userDpt;
    private String userEmail;
    private int userAdmin;
    private int useStatus;
    private Date regDate;
    private int regId;
    private Date editDate;
    private int editor;



    // details
    private String role;
    private int enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
<<<<<<< HEAD
		authList.add(new SimpleGrantedAuthority(role));
		return authList;
=======
        if(role.indexOf(',') != -1) {
           Arrays.asList(role.split(",")).forEach((rol)-> {
                authList.add(new SimpleGrantedAuthority(rol));
            }
           ); 
        } else {
            authList.add(new SimpleGrantedAuthority(role));
        }
        return authList;
>>>>>>> testbranch
    }

    @Override
    public String getPassword() {
        return userPw;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled==1?true:false;
    }
}