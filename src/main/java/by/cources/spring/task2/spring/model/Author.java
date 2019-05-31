package by.cources.spring.task2.spring.model;

import java.time.LocalDate;

public class Author {

    private String name;
    private LocalDate dateOfBirth;
    private Long id;

    public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

    @Override
    public String toString () {
        return "Author [id=" + this.getId() + "; name=" + this.getName() +"; date of birth=" + this.getDateOfBirth() + "]";
    }

}
