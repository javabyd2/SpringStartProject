package com.sda.spring.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "publisher")
public class Publisher {

    // nie robimy geta na book !!!!!

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "publisher",cascade = CascadeType.ALL)
    private Set<Book> books;

    public Publisher() {
    }

    public Publisher(String name, String address, Set<Book> books) {
        this.name = name;
        this.address = address;
        this.books = books;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
