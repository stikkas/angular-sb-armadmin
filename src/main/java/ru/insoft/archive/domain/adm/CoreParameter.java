package ru.insoft.archive.domain.adm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "core_parameter")
@Entity
public class CoreParameter implements Serializable {

	@Id
	@Column(name = "parameter_code", insertable = false, updatable = false, nullable = false)
	private String code;

	@Column(name = "subsystem_number", insertable = false, updatable = false, nullable = false)
	private Long sybsystemNumber;

	@Column(name = "parameter_name", insertable = false, updatable = false, nullable = false)
	private String name;

	@Column(name = "parameter_description", insertable = false, updatable = false)
	private String description;

	@Column(name = "parameter_value", insertable = false, updatable = false, nullable = false)
	private String value;

	@JoinColumn(name = "subsystem_number", referencedColumnName = "subsystem_number", insertable = false, updatable = false)
	@ManyToOne
	private CoreSubsystem subsystem;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getSybsystemNumber() {
		return sybsystemNumber;
	}

	public void setSybsystemNumber(Long sybsystemNumber) {
		this.sybsystemNumber = sybsystemNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CoreSubsystem getSubsystem() {
		return subsystem;
	}

	public void setSubsystem(CoreSubsystem subsystem) {
		this.subsystem = subsystem;
	}
}
