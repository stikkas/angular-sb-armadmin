package ru.insoft.archive.app.domain.adm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.Column;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "adm_user")
@Entity
public class AdmUser implements Serializable {

	@Id
	@Column(name = "user_id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "user_type_id", insertable = false, updatable = false, nullable = false)
	private Long typeId;

	@Column(name = "login", insertable = false, updatable = false, nullable = false, unique = true)
	private String login;

	@Column(name = "password", insertable = false, updatable = false, nullable = false)
	private String password;

	@Column(name = "is_blocked", insertable = false, updatable = false, nullable = false)
	private Boolean blocked;

	@Column(name = "displayed_name", insertable = false, updatable = false, nullable = false)
	private String name;

	@JoinColumn(name = "user_type_id", referencedColumnName = "descriptor_value_id", insertable = false, updatable = false)
	@ManyToOne
	private DescriptorValue type;

	@ManyToMany(mappedBy = "users", fetch = EAGER)
	private Collection<AdmGroup> groups = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DescriptorValue getType() {
		return type;
	}

	public void setType(DescriptorValue type) {
		this.type = type;
	}

	public void addGroup(AdmGroup group) {
		if (!groups.contains(group)) {
			groups.add(group);
			group.addUser(this);
		}
	}

	public void removeGroup(AdmGroup group) {
		groups.remove(group);
		if (group.getUsers().contains(this)) {
			group.removeUser(this);
		}
	}

	public Collection<AdmGroup> getGroups() {
		return Collections.unmodifiableCollection(groups);
	}
}
