package com.metacube.angularwebapi.controller;

import com.metacube.angularwebapi.dto.UserDto;
import com.metacube.angularwebapi.facade.user.UserFacade;
import com.metacube.angularwebapi.spring.Factory;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@CrossOrigin
@Controller
@RequestMapping("/users")
public class UserController
{
        @Autowired
	private UserFacade userFacade;



	@RequestMapping(value = "", produces = "application/json", method = RequestMethod.GET)
        public @ResponseBody Iterable<UserDto> getUsers(@RequestParam Map<String, String> queryMap) {
            System.out.println(queryMap.toString());
		return userFacade.getUsers(queryMap);

	}
        
        @RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody UserDto getUser(@PathVariable("id") int id) {
            
		return userFacade.getUserById(id);
                
	}
}
