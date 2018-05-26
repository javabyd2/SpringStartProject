package com.sda.spring.demo.model;

import javax.persistence.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String lastname;
    private int password;
    private String nick;
    private String addres;
    private String city;
    private int postalcode;
    private int telephone;

    @ManyToOne(cascade = CascadeType.ALL)
    // odnosi sie do mapped by w Role.java
    private Role role;

    public User() {
    }

    public User(String username, String lastname, int password, String nick, String addres, String city, int postalcode, int telephone, Role role) {
        this.username = username;
        this.lastname = lastname;
        this.password = password;
        this.nick = nick;
        this.addres = addres;
        this.city = city;
        this.postalcode = postalcode;
        this.telephone = telephone;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Role getRoles() {
        return role;
    }

    public void setRoles(Role roles) {
        this.role = roles;
    }
}
