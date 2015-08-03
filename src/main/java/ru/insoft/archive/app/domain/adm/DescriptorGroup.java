package ru.insoft.archive.app.domain.adm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "descriptor_group")
@Entity
public class DescriptorGroup implements Serializable {

	@Id
	@Column(name = "descriptor_group_id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "subsystem_number", insertable = false, updatable = false)
	private Long subsystemNumber;

	@Column(name = "group_name", insertable = false, updatable = false, nullable = false)
	private String name;

	@Column(name = "group_code", insertable = false, updatable = false)
	private String code;

	@Column(name = "sort_order", insertable = false, updatable = false, nullable = false)
	private Integer sortOrder;

	@Column(name = "is_system", insertable = false, updatable = false, nullable = false)
	private Boolean system;

	@Column(name = "is_hierarchical", insertable = false, updatable = false, nullable = false)
	private Boolean hierarchical;

	@Column(name = "short_value_supported", insertable = false, updatable = false, nullable = false)
	private Boolean shortSupported;

	@Column(name = "alphabetic_sort", insertable = false, updatable = false, nullable = false)
	private Boolean alphabeticSort;

	@ManyToOne
	@JoinColumn(name = "subsystem_number", referencedColumnName = "subsystem_number", insertable = false, updatable = false)
	private CoreSubsystem subsystem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSubsystemNumber() {
		return subsystemNumber;
	}

	public void setSubsystemNumber(Long subsystemNumber) {
		this.subsystemNumber = subsystemNumber;
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

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Boolean isSystem() {
		return system;
	}

	public void setSystem(Boolean system) {
		this.system = system;
	}

	public Boolean isHierarchical() {
		return hierarchical;
	}

	public void setHierarchical(Boolean hierarchical) {
		this.hierarchical = hierarchical;
	}

	public Boolean isShortSupported() {
		return shortSupported;
	}

	public void setShortSupported(Boolean shortSupported) {
		this.shortSupported = shortSupported;
	}

	public Boolean isAlphabeticSort() {
		return alphabeticSort;
	}

	public void setAlphabeticSort(Boolean alphabeticSort) {
		this.alphabeticSort = alphabeticSort;
	}

	public CoreSubsystem getSubsystem() {
		return subsystem;
	}

	public void setSubsystem(CoreSubsystem subsystem) {
		this.subsystem = subsystem;
	}

	
}
