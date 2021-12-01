package com.entelgy.reto.model.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("page")
	private int page;
	@JsonProperty("per_page")
	private int perPage;
	@JsonProperty("total")
	private int total;
	@JsonProperty("total_pages")
	private int totalPages;
	@JsonProperty("data")
	private List<UserDTO> users;
	
	public FormDTO() {
		super();
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<UserDTO> getUsers() {
		return users;
	}
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}	
	
}
