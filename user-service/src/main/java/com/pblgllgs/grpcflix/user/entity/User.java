package com.pblgllgs.grpcflix.user.entity;
/*
 *
 * @author pblgl
 * Created on 21-02-2024
 *
 */

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ToString
@Data
@Table(name = "\"user\"")
public class User {

    @Id
    private String login;
    private String name;
    private String genre;
}
