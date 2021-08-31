package com.pauloelienay.imageboard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@NoArgsConstructor
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Post> posts;
}
