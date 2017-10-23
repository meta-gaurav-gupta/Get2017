package com.metacube.angularwebapi.dao.comment;

import com.metacube.angularwebapi.dao.GenericHibernateDao;
import com.metacube.angularwebapi.model.Comment;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gaurav
 */

@Repository("hibernateCommentDao")
public class HibernateCommentDao extends GenericHibernateDao<Comment, Integer> implements CommentDao {

    public HibernateCommentDao() {
        super(Comment.class);
    }
    
}
