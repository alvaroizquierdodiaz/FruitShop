package com.dto;

public class Offer {

	private long id;
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", description=" + description + "]";
	}

	public Offer(long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
