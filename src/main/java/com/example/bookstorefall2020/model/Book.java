package com.example.bookstorefall2020.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {

	/*
	 * @Id Specifies the primary key of an entity
	 * @GeneratedValue Provides for the specification of generation strategies for thevalues of primary keys
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;

	
	/*
	 * @ManyToOne Specifies a single-valued association to another entity class thathas many-to-one multiplicity
	 * @JoinColumn Specifies a column for joining an entity association or elementcollection
	 * Annotation used to indicate that annotated property is part oftwo-way linkage between fields; 
	 * and that its role is "parent" (or "forward") link.Value type (class) of property must have a single 
	 * compatible property annotated with JsonBackReference
	 */
	@ManyToOne
	@JoinColumn(name = "categoryid")
	@JsonManagedReference
	private Category category;

	public Book() {
		super();
	}

	public Book(String title, String author, int year, String isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
					+ ", price=" + price + ", getCategory()=" + this.getCategory() + "]";

		else
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
					+ ", price=" + price + "]";

	}

}
