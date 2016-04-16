package com.nchu.web.support;

import java.util.List;

import com.nchu.model.TbRoleFunction;

public class MenuRender {

	private Integer id;
	private String functionUrl;
	private String name;
	private List<MenuRender> child;
	public String getFunctionUrl() {
		return functionUrl;
	}
	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MenuRender> getChild() {
		return child;
	}
	public void setChild(List<MenuRender> child) {
		this.child = child;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
