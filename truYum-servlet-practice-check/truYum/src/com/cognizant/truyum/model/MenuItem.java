package com.cognizant.truyum.model;

import java.util.Date;

import com.cognizant.truyum.util.DateUtil;

public class MenuItem {

	private Long id;
	private String name;
	private Float price;
	private Boolean active;
	private Date dateoflaunch;
	private String category;
	private Boolean freeDelivery;

	public MenuItem(Long id, String name, Float price, Boolean active, Date dateOfLaunch, String category,
			Boolean freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateoflaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;

	}
		
	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateoflaunch;
	}

	public void setDateOfLaunch(Date dateoflaunch) {
		this.dateoflaunch = dateoflaunch;
	}

	public Boolean getFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(Boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((dateoflaunch == null) ? 0 : dateoflaunch.hashCode());
		result = prime * result + ((freeDelivery == null) ? 0 : freeDelivery.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (dateoflaunch == null) {
			if (other.dateoflaunch != null)
				return false;
		} else if (!dateoflaunch.equals(other.dateoflaunch))
			return false;
		if (freeDelivery == null) {
			if (other.freeDelivery != null)
				return false;
		} else if (!freeDelivery.equals(other.freeDelivery))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateoflaunch="
				+ new DateUtil().convertToString(dateoflaunch) + ", freeDelivery=" + freeDelivery + ", category="
				+ category + "]";
	}

}