/**
 * 
 */
package com.base.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author RMehdi
 *
 */
@NoRepositoryBean
public interface IRepository<E, T extends Serializable> extends CrudRepository<E, T> {

	List<E> findByIdExt(String idExt);

}
