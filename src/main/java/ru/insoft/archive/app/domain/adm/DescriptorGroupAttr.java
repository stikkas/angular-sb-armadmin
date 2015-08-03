package ru.insoft.archive.app.domain.adm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "descriptor_group_attr")
@Entity
public class DescriptorGroupAttr implements Serializable {

	@Id
	@Column(name = "descriptor_group_attr_id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "descriptor_group_id", insertable = false, updatable = false, nullable = false)
	private Long groupId;

	@Column(name = "datatype_code", insertable = false, updatable = false, nullable = false)
	private String datatypeCode;

	@Column(name = "attr_name", insertable = false, updatable = false, nullable = false)
	private String name;

	@Column(name = "attr_code", insertable = false, updatable = false, nullable = false)
	private String code;

	@Column(name = "sort_order", insertable = false, updatable = false, nullable = false)
	private Integer sortOrder;

	@Column(name = "is_collection", insertable = false, updatable = false, nullable = false)
	private Boolean collection;

	@Column(name = "is_required", insertable = false, updatable = false, nullable = false)
	private Boolean required;

	@Column(name = "ref_descriptor_group_id", insertable = false, updatable = false)
	private Long refGroupId;

	@ManyToOne
	@JoinColumn(name = "descriptor_group_id", referencedColumnName = "descriptor_group_id", insertable = false, updatable = false)
	private DescriptorGroup descriptorGroup;

	@ManyToOne
	@JoinColumn(name = "ref_descriptor_group_id", referencedColumnName = "descriptor_group_id", insertable = false, updatable = false)
	private DescriptorGroup refDescriptorGroup;

	@ManyToOne
	@JoinColumn(name = "datatype_code", referencedColumnName = "datatype_code", insertable = false, updatable = false)
	private DescDatatype dataType;

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

	public String getDatatypeCode() {
		return datatypeCode;
	}

	public void setDatatypeCode(String datatypeCode) {
		this.datatypeCode = datatypeCode;
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

	public Boolean isCollection() {
		return collection;
	}

	public void setCollection(Boolean collection) {
		this.collection = collection;
	}

	public Boolean isRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Long getRefGroupId() {
		return refGroupId;
	}

	public void setRefGroupId(Long refGroupId) {
		this.refGroupId = refGroupId;
	}

	public DescriptorGroup getDescriptorGroup() {
		return descriptorGroup;
	}

	public void setDescriptorGroup(DescriptorGroup descriptorGroup) {
		this.descriptorGroup = descriptorGroup;
	}

	public DescriptorGroup getRefDescriptorGroup() {
		return refDescriptorGroup;
	}

	public void setRefDescriptorGroup(DescriptorGroup refDescriptorGroup) {
		this.refDescriptorGroup = refDescriptorGroup;
	}

	public DescDatatype getDataType() {
		return dataType;
	}

	public void setDataType(DescDatatype dataType) {
		this.dataType = dataType;
	}

	
}
