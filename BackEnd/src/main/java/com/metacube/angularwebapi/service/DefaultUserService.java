package com.metacube.angularwebapi.service;

import com.metacube.angularwebapi.dao.user.UserDao;
import com.metacube.angularwebapi.model.User;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class DefaultUserService implements UserService
{
    @Resource(name = "hibernateUserDao")
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
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
