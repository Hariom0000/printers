package com.ajay.printers.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.printers.dao.DAO;
import com.ajay.printers.model.PO;
import com.ajay.printers.service.CRUDService;

@SuppressWarnings({ "hiding", "unchecked" })
public class CRUDServiceImpl<I extends Serializable, T extends PO<I>, D extends DAO<I, T>>
		implements CRUDService<I, T> {
	protected D dao;
	@Autowired
	protected SessionFactory sessionFactory;

	public CRUDServiceImpl(D dao) {
		this.dao = dao;
	}

	@Transactional
	public T create(T po) {
		return dao.create(po);
	}

	@Transactional
	public T read(I id) {
		return dao.get(id);
	}

	@Transactional
	public T update(T po) {
		return dao.update(po);
	}

	@Transactional
	public void delete(T po) {
		dao.delete(po);
	}

	@Transactional
	public int deleteById(I id) {
		return dao.deleteById(id);
	}

	@Transactional
	public <C extends Collection<T>> C create(C pos) {
		return dao.create(pos);
	}

	@Transactional
	public <C extends Collection<T>> C update(C pos) {
		return dao.update(pos);
	}

	@Transactional
	public <C extends Collection<T>> void delete(C pos) {
		dao.delete(pos);
	}

	@Transactional
	public <C extends Collection<I>> void deleteByIds(C ids) {
		dao.deleteByIds(ids);
	}

	@Transactional
	public <T> List<T> findAll(Class<T> persistentClass) {

		return dao.findAll(persistentClass);
	}

	@Transactional
	public T createOrUpdate(T po) {
		// TODO Auto-generated method stub
		return ((CRUDService<I, T>) dao).createOrUpdate(po);

	}

	@Transactional
	public <T> List<T> findAllByIsDeletedTrue(Class<T> persistentClass) {
		// TODO Auto-generated method stub
		return dao.findAllByIsDeletedTrue(persistentClass);
	}

	@Transactional
	public void isDelete(I id, String entity) {
		dao.isDelete(id, entity);

	}

	@Transactional
	public <T> List<T> findAllBySchoolId(Class<T> persistentClass, I schoolId) {
		// TODO Auto-generated method stub
		return dao.findAllBySchoolId(persistentClass, schoolId);
	}

}
