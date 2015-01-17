package com.dessy.penjualan.common;

import java.io.Serializable;
import java.util.List;

public abstract interface GenericDao<T, K extends Serializable> {
	
	public abstract T load(K paramK);

	public abstract T get(K paramK);

	public abstract void delete(K paramK);

	public abstract void save(T paramT);

	public abstract void saveOrUpdate(T paramT);

	public abstract void evict(Object paramObject);

	public abstract void update(T paramT);

	public abstract void flush();

	public abstract void clear();
	
	public List<T> findAll();
}
