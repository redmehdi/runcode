package com.base.persistence;

import java.io.Serializable;

public interface IBaseEntity<I1 extends Serializable> extends Serializable{

	I1 getId();

	void setId(I1 id);

}
