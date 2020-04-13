package com.hotel.application.dao;

import com.hotel.application.entity.Role;

public interface RoleDao {
	
	public Role findRoleByName(String theRoleName);

}
