package com.example.jigumproject.entity;


import com.example.jigumproject.dto.UserDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id @GeneratedValue
    Long id;
    String name;


    public UserDto toDto(){
        return UserDto.builder()
                .id(id)
                .name(name)
                .build();
    }


}
