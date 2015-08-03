package ru.insoft.archive.app.domain.adm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "adm_access_rule")
@Entity
public class AdmAccessRule implements Serializable {

	@Id
	@Column(name = "access_rule_id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "subsystem_number", insertable = false, updatable = false, nullable = false)
	private Long subsystemNumber;

	@Column(name = "rule_code", insertable = false, updatable = false, nullable = false)
	private String code;

	@Column(name = "rule_name", insertable = false, updatable = false, nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "subsystem_number", referencedColumnName = "subsystem_number", insertable = false, updatable = false)
	private CoreSubsystem subsystem;

	@ManyToMany(mappedBy = "rules")
	private Collection<AdmGroup> groups = new ArrayList<>();

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

	public CoreSubsystem getSubsystem() {
		return subsystem;
	}

	public void setSubsystem(CoreSubsystem subsystem) {
		this.subsystem = subsystem;
	}

	public void addGroup(AdmGroup group) {
		if (!groups.contains(group)) {
			groups.add(group);
			group.addRule(this);
		}
	}

	public void removeGroup(AdmGroup group) {
		groups.remove(group);
		if (group.getRules().contains(this)) {
			group.removeRule(this);
		}
	}

	public Collection<AdmGroup> getGroups() {
		return Collections.unmodifiableCollection(groups);
	}
}
