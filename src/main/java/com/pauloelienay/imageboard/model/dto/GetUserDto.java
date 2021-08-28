package com.pauloelienay.imageboard.model.dto;

import com.pauloelienay.imageboard.model.Post;
import com.pauloelienay.imageboard.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class GetUserDto {
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
