package ru.insoft.archive.app.domain.adm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "descriptor_value")
@Entity
public class DescriptorValue implements Serializable {

	@Id
	@Column(name = "descriptor_value_id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "descriptor_group_id", insertable = false, updatable = false, nullable = false)
	private Long groupId;

	@Column(name = "full_value", insertable = false, updatable = false, nullable = false)
	private String fullValue;

	@Column(name = "short_value", insertable = false, updatable = false)
	private String shortValue;

	@Column(name = "value_code", insertable = false, updatable = false)
	private String code;

	@Column(name = "sort_order", insertable = false, updatable = false, nullable = false)
	private Long sortOrder;

	@Column(name = "parent_value_id", insertable = false, updatable = false)
	private Long parentId;

	@ManyToOne
	@JoinColumn(name = "descriptor_group_id", referencedColumnName = "descriptor_group_id", insertable = false, updatable = false)
	private DescriptorGroup group;

	@ManyToOne
	@JoinColumn(name = "parent_value_id", referencedColumnName = "descriptor_value_id", insertable = false, updatable = false)
	private DescriptorValue parent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getFullValue() {
		return fullValue;
	}

	public void setFullValue(String fullValue) {
		this.fullValue = fullValue;
	}

	public String getShortValue() {
		return shortValue;
	}

	public void setShortValue(String shortValue) {
		this.shortValue = shortValue;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public DescriptorGroup getGroup() {
		return group;
	}

	public void setGroup(DescriptorGroup group) {
		this.group = group;
	}

	public DescriptorValue getParent() {
		return parent;
	}

	public void setParent(DescriptorValue parent) {
		this.parent = parent;
	}

}
