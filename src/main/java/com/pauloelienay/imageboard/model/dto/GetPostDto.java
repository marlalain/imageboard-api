package com.pauloelienay.imageboard.model.dto;

import com.pauloelienay.imageboard.model.Post;
import com.pauloelienay.imageboard.model.Reply;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Builder
@Getter
@Setter
@Slf4j
public class GetPostDto {
    private String title;
    private String body;
    private String mediaLink;
    private GetUserDto author;
    private Set<Reply> replies;

    public static GetPostDto convertToDto(Post post) {
        return GetPostDto.builder()
                .title(post.getTitle())
                .body(post.getBody())
                .mediaLink(post.getMediaLink())
                .author(GetUserDto.convertToDto(post.getAuthor()))
                .replies(post.getReplies())
                .build();
    }
}
