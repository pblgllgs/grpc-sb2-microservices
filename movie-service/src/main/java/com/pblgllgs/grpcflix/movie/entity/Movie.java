package com.pblgllgs.grpcflix.movie.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 *
 * @author pblgl
 * Created on 21-02-2024
 *
 */
@Entity
@ToString
@Data
@Table(name = "\"movie\"")
public class Movie {

    @Id
    private int id;
    private String title;
    @Column(name = "release_year")
    private int year;
    private double rating;
    private String genre;
}
