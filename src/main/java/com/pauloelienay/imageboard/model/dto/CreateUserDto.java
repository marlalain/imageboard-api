package com.pauloelienay.imageboard.model.dto;

import com.pauloelienay.imageboard.model.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateUserDto {
    private String name;
    private String email;

    public static CreateUserDto convertToDto(User user) {
        return CreateUserDto.builder().email(user.getEmail()).name(user.getName()).build();
    }
}
