package ru.insoft.archive.app.domain.adm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "adm_employee")
@Entity
public class AdmEmployee implements Serializable {

	@Id
	@Column(name = "employee_id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Column(name = "user_id", insertable = false, updatable = false)
	private Long userId;

	@Column(name = "department_id", insertable = false, updatable = false, nullable = false)
	private Long departmentId;

	@Column(name = "position_id", insertable = false, updatable = false, nullable = false)
	private Long positionId;

	@Column(name = "last_name", insertable = false, updatable = false, nullable = false)
	private String lastName;

	@Column(name = "first_name", insertable = false, updatable = false, nullable = false)
	private String firstName;

	@Column(name = "middle_name", insertable = false, updatable = false)
	private String middleName;

	@JoinColumn(name="user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
	@ManyToOne
	private AdmUser admUser;

	@JoinColumn(name="department_id", referencedColumnName = "descriptor_value_id", insertable = false, updatable = false)
	@ManyToOne
	private DescriptorValue department;

	@JoinColumn(name="position_id", referencedColumnName = "descriptor_value_id", insertable = false, updatable = false)
	@ManyToOne
	private DescriptorValue position;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public AdmUser getAdmUser() {
		return admUser;
	}

	public void setAdmUser(AdmUser admUser) {
		this.admUser = admUser;
	}

	public DescriptorValue getDepartment() {
		return department;
	}

	public void setDepartment(DescriptorValue department) {
		this.department = department;
	}

	public DescriptorValue getPosition() {
		return position;
	}

	public void setPosition(DescriptorValue position) {
		this.position = position;
	}

}
 

 
 
 
