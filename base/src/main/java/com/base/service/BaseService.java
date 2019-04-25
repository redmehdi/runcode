package com.base.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import com.base.converter.BaseConverter;
import com.base.dto.IDto;
import com.base.persistence.IBaseEntity;
import com.base.repository.IRepository;

/**
 * @author RMehdi
 *
 * @param <E>
 * @param <T>
 * @param <C>
 */
@ComponentScan({ "com." })
public abstract class BaseService<E extends IBaseEntity<Long>, T extends IDto, C extends IRepository<E, Long>>
		implements IService<E, T> {

	protected abstract BaseConverter<E, T>  getConverter();

	@Autowired
	private C repository;


	@Override
	public List<T> getAll() {
		Iterable<E> eList = repository.findAll();
		return getConverter().getDtos(eList);
	}

	@Override
	@Transactional
	public boolean addOrUpdate(T t) {
		E entity =null;
		E entityStored = null;
		entity = getConverter().getEntity(t);
		final String idExt = t.getId();
		if (idExt!=null) {
			entityStored = repository.findByIdExt(idExt).get(0);
			entity.setId(entityStored.getId());
		}
		E e = repository.save(entity);
		if (e == null)
			return false;
		return true;
	}

	@Override
	public boolean addAll(List<T> t) {
		return false;
	}

	@Override
	public boolean remove(String idExt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T findById(String id) {
		final List<E> findById = repository.findByIdExt(id);
		if (findById == null || findById.isEmpty()) {
			return null;
		}
		return getConverter().getDto(findById.get(0));
	}

}
