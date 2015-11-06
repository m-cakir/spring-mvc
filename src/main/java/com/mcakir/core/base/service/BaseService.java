package com.mcakir.core.base.service;

import java.util.List;

public interface BaseService<T> {

	public T create(T entity);
	
	public void delete(Long id);

	public List<T> findAll();

    public T findById(Long id);
 
    public void update(T entity);
}
