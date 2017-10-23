package com.metacube.angularwebapi.service;


import com.metacube.angularwebapi.model.User;
import javax.ws.rs.core.MultivaluedMap;


public interface UserService {
	Iterable<User> getAllUsers();	
        Iterable<User> getUsers(MultivaluedMap<String, String> queryMap);
	User getUserById(int id);
}
