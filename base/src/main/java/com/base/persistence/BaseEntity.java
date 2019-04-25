package com.base.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.base.util.UtilProcess;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements IEntity<Long, String, Date, String> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ID_EXT", updatable = false, nullable = false, unique = true)
	private String idExt;

	@Column(name = "CREATED_NAME_BY", updatable = false, nullable = false)
	private String createdNameBy;

	@Column(name = "MODIFIED_NAME_BY", updatable = true, nullable = false)
	private String modifiedNameBy;

	@Column(name = "CREATION_DATE", updatable = false, nullable = false)
	private Date creationDate;

	@Column(name = "MODIFICATION_DATE", updatable = true, nullable = false)
	private Date modificationDate;

	public BaseEntity() {
	}

	/**
	 * 
	 * New record private constructor for {@link BaseEntity}
	 * @param createdNameBy
	 * @param modifiedNameBy
	 * @param creationDate
	 * @param modificationDate
	 */
	private BaseEntity(String idExt, String createdNameBy, String modifiedNameBy, Date creationDate,
			Date modificationDate) {
		this.idExt = idExt;
		this.createdNameBy = createdNameBy;
		this.modifiedNameBy = modifiedNameBy;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}

	/**
	 * 
	 * New record public constructor for {@link BaseEntity}
	 * @param createdNameBy
	 * @param modifiedNameBy
	 * @param creationDate
	 * @param modificationDate
	 */
	public BaseEntity(String createdNameBy, String modifiedNameBy) {
		this(UtilProcess.generateId(), createdNameBy, modifiedNameBy, new Date(), new Date());
	}

	/**
	 * 
	 * Modify record public constructor for {@link BaseEntity}
	 * @param createdNameBy
	 * @param modifiedNameBy
	 * @param creationDate
	 * @param modificationDate
	 */
	public BaseEntity(String modifiedNameBy) {
		this(null, null, modifiedNameBy, null, new Date());
	}

	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getIdExt() {
		return idExt;
	}

	@Override
	public void setModificationDate(Date currentDate) {
		modificationDate = currentDate;
	}

	@Override
	public void setModifiedNameBy(String name) {
		modifiedNameBy = name;
	}

	@Override
	public Date getModificationDate() {
		return modificationDate;
	}

	@Override
	public String getModifiedNameBy() {
		return modifiedNameBy;
	}

	@Override
	public Date getCreationDate() {
		return creationDate;
	}

	@Override
	public String getCreatedNameBy() {
		return createdNameBy;
	}

	@Override
	public String toString() {
		return String.format(
				"BaseEntity [id=%s, idExt=%s, createdNameBy=%s, modifiedNameBy=%s, creationDate=%s, modificationDate=%s]",
				id, idExt, createdNameBy, modifiedNameBy, creationDate, modificationDate);
	}
}
