package com.base.converter;

import java.util.List;

public interface IConverter<E, T, D> {
	
	D create();

	T getDto(E entity);

	List<T> getDtos(Iterable<E> etities);

	E getEntity(T dto);

	List<E> getEntities(List<T> dtos);

}
