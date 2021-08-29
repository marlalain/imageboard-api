package com.pauloelienay.imageboard.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pauloelienay.imageboard.model.Post;
import com.pauloelienay.imageboard.model.User;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetUserDto extends RepresentationModel<GetUserDto> {
    private String name;
    private String email;
    private Set<Post> posts;

    public static GetUserDto convertToDto(User user) {
        return GetUserDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .posts(user.getPosts())
                .build();
    }
}
