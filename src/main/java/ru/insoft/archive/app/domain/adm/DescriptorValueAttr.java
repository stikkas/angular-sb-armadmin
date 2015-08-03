package ru.insoft.archive.app.domain.adm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "descriptor_value_attr")
@Entity
public class DescriptorValueAttr implements Serializable {

	@Id
	@Column(name = "descriptor_value_attr_id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "descriptor_value_id", insertable = false, updatable = false, nullable = false)
	private Long descValueId;
	
	@Column(name = "descriptor_group_attr_id", insertable = false, updatable = false, nullable = false)
	private Long groupAttrId;

	@Column(name = "attr_value", insertable = false, updatable = false)
	private String value;

	@Column(name = "ref_descriptor_value_id", insertable = false, updatable = false)
	private Long refDescriptorValueId;

	@ManyToOne
	@JoinColumn(name="descriptor_value_id", referencedColumnName = "descriptor_value_id", insertable = false, updatable = false)
	private DescriptorValue descValue;
 
	@ManyToOne
	@JoinColumn(name="descriptor_group_attr_id", referencedColumnName = "descriptor_group_attr_id", insertable = false, updatable = false)
	private DescriptorGroupAttr groupAttr;

	@ManyToOne
	@JoinColumn(name="ref_descriptor_value_id", referencedColumnName = "descriptor_value_id", insertable = false, updatable = false)
	private DescriptorValue refDescriptorValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDescValueId() {
		return descValueId;
	}

	public void setDescValueId(Long descValueId) {
		this.descValueId = descValueId;
	}

	public Long getGroupAttrId() {
		return groupAttrId;
	}

	public void setGroupAttrId(Long groupAttrId) {
		this.groupAttrId = groupAttrId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getRefDescriptorValueId() {
		return refDescriptorValueId;
	}

	public void setRefDescriptorValueId(Long refDescriptorValueId) {
		this.refDescriptorValueId = refDescriptorValueId;
	}

	public DescriptorValue getDescValue() {
		return descValue;
	}

	public void setDescValue(DescriptorValue descValue) {
		this.descValue = descValue;
	}

	public DescriptorGroupAttr getGroupAttr() {
		return groupAttr;
	}

	public void setGroupAttr(DescriptorGroupAttr groupAttr) {
		this.groupAttr = groupAttr;
	}

	public DescriptorValue getRefDescriptorValue() {
		return refDescriptorValue;
	}

	public void setRefDescriptorValue(DescriptorValue refDescriptorValue) {
		this.refDescriptorValue = refDescriptorValue;
	}

}
