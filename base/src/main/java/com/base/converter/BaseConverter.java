package com.base.converter;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter class from entity <-> dto
 * 
 * @author RMehdi
 *
 * @param <E>
 * @param <T>
 */
public abstract class BaseConverter<E, T> /**implements IConverter<E, T> */{
	

	/**
	 * Method to convert Entity -> Dto object
	 * 
	 * @param e
	 * @return T
	 */
	public abstract T getDto(E e);

	/**
	 * Method to convert Dto -> Entity object
	 * 
	 * @param t
	 * @return E
	 */
	public abstract E getEntity(T t);
	
	/**
	 * Method to convert Dtos -> Entities object
	 * 
	 * @param entities
	 * @return
	 */
	public List<T> getDtos(Iterable<E> entities) {
		if (entities ==null) 
			return null;
		List<T> dtos = new ArrayList<>();
		entities.forEach(entity -> dtos.add(getDto(entity)));
		return dtos;
	}

	/**
	 * Method to convert Entities -> Dtos object
	 * 
	 * @param dtos
	 * @return
	 */
	public List<E> getEntities(List<T> dtos) {
		List<E> entities = new ArrayList<>();
		dtos.forEach(dto -> entities.add(getEntity(dto)));
		return entities;
	}

}
