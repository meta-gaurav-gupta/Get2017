package com.metacube.angularwebapi.facade.user;

import java.util.ArrayList;
import java.util.List;

import com.metacube.angularwebapi.dto.UserDto;
import com.metacube.angularwebapi.model.User;
import com.metacube.angularwebapi.service.UserService;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userFacade")
public class DefaultUserFacade implements UserFacade
{
        @Autowired
	private UserService userService;

    public DefaultUserFacade() {
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

        
        
	public DefaultUserFacade(UserService userService) {
		this.userService = userService;
	}


	@Override public Iterable<UserDto> getAllUsers()
	{
		List<UserDto> userDtoList = new ArrayList<>();

		for (User user : userService.getAllUsers()) {
			userDtoList.add(modelToDto(user));
		}

		return userDtoList;
	}

	@Override public UserDto getUserById(final int id)
	{
		return modelToDto(userService.getUserById(id));
	}

	protected User dtoToModel(UserDto userDto) {
		if (userDto == null) {
			return null;
		}
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setWebsite(userDto.getWebsite());
		return user;
	}

	protected UserDto modelToDto(User user) {
		if (user == null) {
			return null;
		}
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setUsername(user.getUsername());
		userDto.setEmail(user.getEmail());
		userDto.setWebsite(user.getWebsite());
		return userDto;
	}

    @Override
    public Iterable<UserDto> getUsers(Map<String, String> queryMap) {
        System.out.println(queryMap.toString());
        if(queryMap.isEmpty()) { return getAllUsers(); }
        List<UserDto> userDtoList = new ArrayList<>();

		for (User user : userService.getUsers(queryMap)) {
			userDtoList.add(modelToDto(user));
		}

		return userDtoList;
    }
}
