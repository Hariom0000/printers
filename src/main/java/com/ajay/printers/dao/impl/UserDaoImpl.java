package com.ajay.printers.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.ajay.printers.dao.UserDao;
import com.ajay.printers.model.User;

@Service
public class UserDaoImpl extends DAOImpl<Integer, User> implements UserDao {

	public User getUserByUsername(String username) {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();
	}

}
