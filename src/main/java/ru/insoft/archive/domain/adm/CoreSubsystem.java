package ru.insoft.archive.domain.adm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "core_subsystem")
public class CoreSubsystem implements Serializable {

	@Id
	@Column(name = "subsystem_number", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "subsystem_name", insertable = false, updatable = false, nullable = false)
	private String name;

	@Column(name = "subsystem_code", insertable = false, updatable = false, nullable = false)
	private String code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
