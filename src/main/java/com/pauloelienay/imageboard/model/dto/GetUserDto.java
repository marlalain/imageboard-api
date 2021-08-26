package com.pauloelienay.imageboard.model.dto;

import com.pauloelienay.imageboard.model.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetUserDto {
    private String name;
    private String email;

    public static GetUserDto convertToDto(User user) {
        return GetUserDto.builder().email(user.getEmail()).name(user.getName()).build();
    }
}
