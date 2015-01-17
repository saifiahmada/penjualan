package com.dessy.penjualan.common;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class GenericHibernateDao<T, K extends Serializable> implements
		GenericDao<T, K> {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private Class<T> persistentClass;

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public GenericHibernateDao() {
		this.persistentClass = ((Class) ((java.lang.reflect.ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@SuppressWarnings("unchecked")
	public T load(K key) {
		return (T) this.sessionFactory.getCurrentSession().load(this.persistentClass, key);
	}

	@SuppressWarnings("unchecked")
	public T get(K key) {
		return (T) this.sessionFactory.getCurrentSession().get(this.persistentClass, key);
	}

	protected Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public void saveOrUpdate(T newEntity) {
		getCurrentSession().saveOrUpdate(newEntity);
	}

	public void save(T newEntity) {
		getCurrentSession().save(newEntity);
	}

	public void flush() {
		getCurrentSession().flush();
	}

	public void update(T editedEntity) {
		getCurrentSession().update(editedEntity);
	}

	public void delete(K key) {
		Object entity = getCurrentSession().get(this.persistentClass, key);
		getCurrentSession().delete(entity);
	}

	public void clear() {
		getCurrentSession().clear();
	}

	public void evict(Object entity) {
		getCurrentSession().evict(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		List<T> list = getCurrentSession().createQuery("from "+persistentClass.getName()).list();
		return list;
	}
}
