package com.metacube.angularwebapi.facade.user;

import com.metacube.angularwebapi.dto.UserDto;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;

public interface UserFacade
{
	Iterable<UserDto> getAllUsers();
        Iterable<UserDto> getUsers(Map<String, String> queryMap);
	UserDto getUserById(int id);
}
