package com.encora.mx.restapi.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "DIRECTOR")
public class Director implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

    @Column(name = "MOVIES")
    @ManyToMany(mappedBy = "directors")
    private List<Movie> movies;

    public Director(String name) {
        this.name = name;
    }
}
