package com.encora.movieapi.Entities;

import javax.persistence.*;
import java.io.Serializable;
//import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(
            name = "username",
            unique = true,
            nullable = false
    )
    private String username;
    @Column(
            name = "email",
            unique = true,
            nullable = false
    )
    private String user_email;


    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Raitings> raitingsList;*/


    public User (){ }
    public User(int userId, String username, String user_email) {
        this.userId = userId;
        this.username = username;
        this.user_email = user_email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return user_email;
    }

    public void setEmail(String email) {
        this.user_email = email;
    }


}
