package com.example.jigumproject.dto;


import com.example.jigumproject.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    Long id;
    String name;

    public User toEntity(){
        return User.builder()
                .id(id)
                .name(name)
                .build();
    }
}
