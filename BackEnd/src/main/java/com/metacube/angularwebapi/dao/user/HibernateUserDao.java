package com.metacube.angularwebapi.dao.user;

import com.metacube.angularwebapi.model.User;
import org.springframework.stereotype.Repository;
import com.metacube.angularwebapi.dao.GenericHibernateDao;
import java.util.Map;

/**
 *
 * @author Gaurav
 */

@Repository("hibernateUserDao")
public class HibernateUserDao extends GenericHibernateDao<User, Integer> implements UserDao{

    public HibernateUserDao() {
        super(User.class);
    }
    
}
