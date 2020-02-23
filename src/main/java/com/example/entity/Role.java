package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -145808389293383555L;

	@Column(name = "role")
	private String role;

	@JsonIgnore
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private List<User> users;

	@Override
	public String toString() {
		return "Role{" + "id: " + super.getId() + ", " + "role: " + role + "}";
	}

	public Role(String role, List<User> users) {
		this.role = role;
		this.users = users;
	}

	public Role() {
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
