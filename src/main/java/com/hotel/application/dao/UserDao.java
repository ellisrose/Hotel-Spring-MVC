package com.hotel.application.dao;

import com.hotel.application.entity.User;

public interface UserDao {
	
	User findByUserName(String userName);
    
    void save(User user);

}
