package com.baizhi.hrz.entity;

import java.io.Serializable;
import java.util.List;

//类别表
public class Category implements Serializable{
	private String id; //编号
	private String name; //类别名称
	private String parent_id;//所属类别
	private Integer levels;//级别
	private List<Category> seconds; //集合对象
	private Category category;//类别对象
	
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the parent_id
	 */
	public String getParent_id() {
		return parent_id;
	}
	/**
	 * @param parent_id the parent_id to set
	 */
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	/**
	 * @return the levels
	 */
	public Integer getLevels() {
		return levels;
	}
	/**
	 * @param levels the levels to set
	 */
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	/**
	 * @return the seconds
	 */
	public List<Category> getSeconds() {
		return seconds;
	}
	/**
	 * @param seconds the seconds to set
	 */
	public void setSeconds(List<Category> seconds) {
		this.seconds = seconds;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parent_id="
				+ parent_id + ", levels=" + levels + ", seconds=" + seconds
				+ "]";
	}
	public Category(String id, String name, String parent_id, Integer levels,
			List<Category> seconds) {
		super();
		this.id = id;
		this.name = name;
		this.parent_id = parent_id;
		this.levels = levels;
		this.seconds = seconds;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
