package com.base.persistence;

import java.io.Serializable;

public interface IEntity<I1 extends Serializable,I2 extends Serializable,I3,I4> extends IBaseEntity<I1> {
	
	I2 getIdExt();
	
	I3 getModificationDate();
	void setModificationDate(I3 currentDate);
	
	I4 getModifiedNameBy();
	void setModifiedNameBy(I4 name);
	
	I3 getCreationDate();
	I4 getCreatedNameBy();
	
}