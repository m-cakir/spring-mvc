package com.mcakir.core.model;

import com.mcakir.core.base.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class Menu extends BaseModel {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String link;

	@Column(nullable = false, columnDefinition = "int default 1")
	private int displayOrder;
	
	@ManyToOne(optional=true)
	private Menu parent;
	
	@Transient
	private List<Menu> childs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public List<Menu> getChilds() {
		return childs;
	}

	public void setChilds(List<Menu> childs) {
		this.childs = childs;
	}
}
