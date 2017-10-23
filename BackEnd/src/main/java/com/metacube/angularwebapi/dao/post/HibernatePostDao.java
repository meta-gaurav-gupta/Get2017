package com.metacube.angularwebapi.dao.post;

import com.metacube.angularwebapi.dao.GenericHibernateDao;
import com.metacube.angularwebapi.model.Post;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gaurav
 */
@Repository("hibernatePostDao")
public class HibernatePostDao extends GenericHibernateDao<Post, Integer> implements PostDao {

    public HibernatePostDao() {
        super(Post.class);
    }
    
}
