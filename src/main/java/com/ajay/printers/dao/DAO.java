 package com.ajay.printers.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.ajay.printers.model.PO;

public interface DAO<I extends Serializable, T extends PO<I>> {
	public T get(I id);
	
	
	public T create(T po);
	public <T> List<T> findAll(Class<T> persistentClass);
	public <T> List<T> findAllByIsDeletedTrue(Class<T> persistentClass);
	public <T> List<T> findAllBySchoolId(Class<T> persistentClass,I schoolId);
//	public T createOrUpdate(T po);
	
	public T update(T po);
	
	public void delete(T po);
	public void isDelete(I id,String entity);
	
	public int deleteById(I id);
	
	public <C extends Collection<T>> C create(C pos);
	
//	public <C extends Collection<T>> C createOrUpdate(C pos);
	
	public <C extends Collection<T>> C update(C pos);
	
	public <C extends Collection<T>> void delete(C pos);
	
	public <C extends Collection<I>> void deleteByIds(C ids);
}
