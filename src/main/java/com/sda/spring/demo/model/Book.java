package com.sda.spring.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private int isbn;

    @Column(name = "author_id")
    private int author_id;


    @ManyToOne(cascade = CascadeType.MERGE)
    private Category category;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(joinColumns =
    @JoinColumn(name = "book_id"),
            inverseJoinColumns =
            @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    @ManyToOne
    private Publisher publisher;

    public Book(String title, Category category, Set<Author> authors) {
        this.title = title;
        this.category = category;
        this.authors = authors;
    }

    public Book() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn() {

        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}