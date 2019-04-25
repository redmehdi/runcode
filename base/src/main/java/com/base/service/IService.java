package com.base.service;

import java.util.List;

/**
 * @author RMehdi
 *
 * @param <E>
 * @param <T>
 */
public interface IService<E, T> {

	List<T> getAll();

	boolean addOrUpdate(T t);

	boolean addAll(List<T> t);

	boolean remove(String idExt);

	T findById(String id);

}
