package com.pauloelienay.imageboard.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "replies")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reply implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    @Id
    private long id;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "media_link")
    private String mediaLink;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    @JsonBackReference("author")
    @ToString.Exclude
    private User author;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonBackReference("post")
    @ToString.Exclude
    private Post post;
}
