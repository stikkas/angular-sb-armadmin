package ru.insoft.archive.app.domain.adm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "desc_datatype")
@Entity
public class DescDatatype implements Serializable {

	@Id
	@Column(name = "datatype_code", insertable = false, updatable = false, nullable = false)
	private String code;

	@Column(name = "type_name", insertable = false, updatable = false, nullable = false)
	private String name;

	@Column(name = "sort_order", insertable = false, updatable = false, nullable = false)
	private Integer sortOrder;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

}
