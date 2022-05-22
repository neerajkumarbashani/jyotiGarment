package com.shopme.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Table(name="categories")
@Entity
public class Category {

	@Id
	private int id;
	private String name;
	private String alias;
	private String image;
	private boolean enables;

	@OneToOne
	@JoinColumn(name = "parant_id")
	private Category parant;
	
	
	@OneToMany(mappedBy ="parant" )

	private Set<Category> children=new HashSet<>();




	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public boolean isEnables() {
		return enables;
	}


	public void setEnables(boolean enables) {
		this.enables = enables;
	}


	public Category( String name, String alias, String image, boolean enables, Category parant,
			Set<Category> children) {

		this.name = name;
		this.alias = alias;
		this.image = image;
		this.enables = enables;
		this.parant = parant;
		this.children = children;
	}


	public Category(String name) {
		super();
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public Category getParant() {
		return parant;
	}


	public void setParant(Category parant) {
		this.parant = parant;
	}


	public Set<Category> getChildren() {
		return children;
	}


	public void setChildren(Set<Category> children) {
		this.children = children;
	}

}
