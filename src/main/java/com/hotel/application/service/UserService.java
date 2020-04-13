package com.hotel.application.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.hotel.application.entity.User;
import com.hotel.application.user.CrmUser;

public interface UserService extends UserDetailsService {
	
	User findByUserName(String userName);

    void save(CrmUser crmUser);

}
