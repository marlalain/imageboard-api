package com.pauloelienay.imageboard.model;

import com.pauloelienay.imageboard.model.dto.CreateUserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @SequenceGenerator(name = "seq_users")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")
    @Column(unique = true)
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
}
