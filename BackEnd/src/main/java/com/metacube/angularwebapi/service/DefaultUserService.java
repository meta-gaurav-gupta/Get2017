package com.metacube.angularwebapi.service;

import com.metacube.angularwebapi.dao.user.UserDao;
import com.metacube.angularwebapi.model.User;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userService")
public class DefaultUserService implements UserService
{
	private UserDao userDao;

        @Autowired
	public DefaultUserService(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override public Iterable<User> getAllUsers()
	{
		return userDao.findAll();
	}

	@Override public User getUserById(final int id)
	{
		return userDao.findOne(id);
	}

    @Override
    public Iterable<User> getUsers(Map<String, String> queryMap) {
        if(queryMap.isEmpty()) { return getAllUsers(); }
        if(queryMap.containsKey("search")) {
            return userDao.search(queryMap.get("search"));
        }
        return userDao.findAll(queryMap);
    }
}
