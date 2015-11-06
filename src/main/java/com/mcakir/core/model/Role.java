package com.mcakir.core.model;

import com.mcakir.core.base.model.BaseModel;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role extends BaseModel {

	@Column(nullable = false)
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		joinColumns = { @JoinColumn },
		inverseJoinColumns = { @JoinColumn }
	)
	@OrderBy("displayOrder ASC")
	private Set<Menu> menu;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Menu> getMenu() {
		return menu;
	}

	public void setMenu(Set<Menu> menu) {
		this.menu = menu;
	}
}
