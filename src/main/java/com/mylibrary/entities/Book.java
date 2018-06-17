package com.mylibrary.entities;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private Date publicationDate;

	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;


	@ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(
			name="book_author",
			joinColumns={@JoinColumn(name = "book_id")},
			inverseJoinColumns = {@JoinColumn(name = "author_id")}
	)
	private Set<Author> authors = new HashSet<>();
}
