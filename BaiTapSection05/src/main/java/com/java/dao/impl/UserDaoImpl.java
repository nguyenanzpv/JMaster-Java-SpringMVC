package com.java.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.dao.UserDao;
import com.java.entity.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory; //su dung session cua Hibernate

	public void add(User user) {
		sessionFactory.getCurrentSession().save(user); //getCurrentSession se tra ve session moi khi co request toi db
	}

	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public User getById(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public void delete(int id) {
		sessionFactory.getCurrentSession().delete(getById(id));
	}

	public User getByUsername(String username) {
		String hql = "FROM User WHERE username = :name "; //hql query
		return (User) sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", username)
				.uniqueResult();
	}

	public List<User> getAll() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(User.class);
		return cr.list();
	}

}
