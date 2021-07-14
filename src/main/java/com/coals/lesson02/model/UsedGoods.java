package com.coals.lesson02.model;

import java.util.Date;

public class UsedGoods {

	private int id;
	private String title;
	private String description;
	private String picture;
	private int sellerId;
	private Date createdAt;
	private Date uqdatedAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUqdatedAt() {
		return uqdatedAt;
	}
	public void setUqdatedAt(Date uqdatedAt) {
		this.uqdatedAt = uqdatedAt;
	}
	
}
