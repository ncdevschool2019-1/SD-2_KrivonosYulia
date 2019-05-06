package com.netcracker.projectmanager.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @OneToOne
    @JoinColumn(name = "role", nullable = false)
    private Role role;

    @Column(name = "email",nullable = false, length = 255)
    private String email;
    @Column(name = "name",nullable = true, length = 15)
    private String name;

    @Column(name = "surname",nullable = true, length = 15)
    private String surname;

    @Column(name = "login",nullable = true, length = 15)
    private String login;

    @Column(name = "password",nullable = false, length = 25)
    private String password;

    @Column(name = "picture",nullable = true, length = 255)
    private String picture;


//    @OneToMany(mappedBy="tasks")
//    @Column(name = "assigneduser")
//    private Set<Task> tasksAssigned;
//


//    @OneToMany(mappedBy="users")
//    @Column(name = "reporter")
//    private Set<Task> tasksCreated;

    public User() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                email.equals(user.email) &&
                Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, login);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
