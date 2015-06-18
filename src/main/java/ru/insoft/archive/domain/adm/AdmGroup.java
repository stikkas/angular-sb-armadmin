package ru.insoft.archive.domain.adm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "adm_group")
@Entity
public class AdmGroup implements Serializable {

	@Id
	@Column(name = "group_id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "group_name", insertable = false, updatable = false, nullable = false, unique = true)
	private String name;

	@Column(name = "group_note", insertable = false, updatable = false)
	private String note;

	@JoinTable(name = "adm_user_group", joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
	@ManyToMany
	private Collection<AdmUser> users = new ArrayList<>();

	@JoinTable(name = "adm_group_rule", joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
			inverseJoinColumns = @JoinColumn(name = "access_rule_id", referencedColumnName = "access_rule_id"))
	@ManyToMany
	private Collection<AdmAccessRule> rules = new ArrayList<>();

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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void addUser(AdmUser user) {
		if (!users.contains(user)) {
			users.add(user);
			user.addGroup(this);
		}
	}

	public void removeUser(AdmUser user) {
		users.remove(user);
		if (user.getGroups().contains(this)) {
			user.removeGroup(this);
		}
	}

	public Collection<AdmUser> getUsers() {
		return Collections.unmodifiableCollection(users);
	}

	public void addRule(AdmAccessRule rule) {
		if (!rules.contains(rule)) {
			rules.add(rule);
			rule.addGroup(this);
		}
	}

	public void removeRule(AdmAccessRule rule) {
		rules.remove(rule);
		if (rule.getGroups().contains(this)) {
			rule.removeGroup(this);
		}

	}

	public Collection<AdmAccessRule> getRules() {
		return Collections.unmodifiableCollection(rules);
	}
}
