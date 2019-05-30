package by.cources.spring.task2.spring.model;

import java.util.Date;

public class Autor {

	private Long id;
	private String name;
	private Date birthDay;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", name=" + name + ", birthDay=" + birthDay + "]";
	}

}