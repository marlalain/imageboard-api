package com.pauloelienay.imageboard.model.dto;

import com.pauloelienay.imageboard.model.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Builder
@Getter
@Setter
@Slf4j
public class GetPostDto {
    private String title;
    private String body;
    private String mediaLink;
    private GetUserDto author;

    public static GetPostDto convertToDto(Post post) {
        return GetPostDto.builder()
                .title(post.getTitle())
                .body(post.getBody())
                .mediaLink(post.getMediaLink())
                .author(GetUserDto.convertToDto(post.getAuthor()))
                .build();
    }
}
