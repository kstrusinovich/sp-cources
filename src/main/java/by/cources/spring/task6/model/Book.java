package by.cources.spring.task6.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	@Size(min=2, max=30)
	private String name;

	@ManyToOne(optional = false, cascade = { PERSIST, DETACH, MERGE, REFRESH })
	@JoinColumn(name = "author_id")
	@JsonIgnore
	private Author author;

	@Column(name = "published_in")
	@NotNull
	@Min(1800)
	protected Long publishedIn;

	public Long getPublishedIn() {
		return publishedIn;
	}

	public void setPublishedIn(Long publishedIn) {
		this.publishedIn = publishedIn;
	}

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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", publishedIn=" + publishedIn + "]";
	}
}