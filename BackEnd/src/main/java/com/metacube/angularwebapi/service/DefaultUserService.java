package com.metacube.angularwebapi.service;

import com.metacube.angularwebapi.dao.user.UserDao;
import com.metacube.angularwebapi.model.User;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;

public class DefaultUserService implements UserService
{
	private UserDao userDao;

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
    public Iterable<User> getUsers(MultivaluedMap<String, String> queryMap) {
        if(queryMap.isEmpty()) { return getAllUsers(); }
        if(queryMap.containsKey("search")) {
            return userDao.search(queryMap.getFirst("search"));
        }
        return userDao.findAll(queryMap);
    }
}
