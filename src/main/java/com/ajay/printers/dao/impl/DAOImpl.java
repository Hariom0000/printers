package com.ajay.printers.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.ajay.printers.dao.DAO;
import com.ajay.printers.model.PO;

@SuppressWarnings({ "unchecked", "hiding" })
public abstract class DAOImpl<I extends Serializable, T extends PO<I>>
		implements DAO<I, T>, InitializingBean {

	@Autowired
	protected SessionFactory sessionFactory;
	private Class<T> poClass;
	private String entityName;

	public <T> List<T> findAll(Class<T> persistentClass) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				persistentClass);
		List<T> res = criteria.list();
		return res;

	}

	public <T> List<T> findAllByIsDeletedTrue(Class<T> persistentClass) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(persistentClass)
				.add(Restrictions.eq("isDeleted", false));
		List<T> res = criteria.list();
		return res;

	}

	public <T> List<T> findAllBySchoolId(Class<T> persistentClass, I schoolId) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(persistentClass)
				.add(Restrictions.eq("isDeleted", false))
				.add(Restrictions.eq("school.school_id", schoolId));
		List<T> res = criteria.list();
		return res;

	}

	public T get(I id) {
		return (T) sessionFactory.getCurrentSession().get(poClass, id);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Class<T> getPoClass() {
		return poClass;
	}

	public void setPoClass(Class<T> poClass) {
		this.poClass = poClass;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public T create(T po) {
		sessionFactory.getCurrentSession().save(po);
		return po;
	}

	// @Override
	// public T createOrUpdate(T po) {
	// sessionFactory.getCurrentSession().saveOrUpdate(po);
	// return po;
	// }

	public T update(T po) {
		sessionFactory.getCurrentSession().update(po);
		return po;
	}

	public void delete(T po) {
		sessionFactory.getCurrentSession().delete(po);

	}

	public void isDelete(I id, String entity) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery(
						"update " + entity
								+ " set isDeleted=:isDeleted where id = :id");
		query.setBoolean("isDeleted", true);
		query.setInteger("id", (Integer) id);

		query.executeUpdate();

	}

	public int deleteById(I id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete " + entityName + " where id = :id");
		query.setParameter("id", id);
		return query.executeUpdate();

	}

	public <C extends Collection<T>> C create(C pos) {
		for (T po : pos)
			create(po);
		return pos;
	}

	// @Override
	// public <C extends Collection<T>> C createOrUpdate(C pos) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	public <C extends Collection<T>> C update(C pos) {
		for (T po : pos)
			update(po);
		return pos;
	}

	public <C extends Collection<T>> void delete(C pos) {
		for (T po : pos)
			delete(po);
	}

	public <C extends Collection<I>> void deleteByIds(C ids) {
		for (I id : ids)
			deleteById(id);
	}

	public void afterPropertiesSet() throws Exception {
		poClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
		entityName = poClass.getSimpleName();
	}

	/*
	 * protected SessionFactory getSessionFactory(){ return sessionFactory; }
	 */

}
