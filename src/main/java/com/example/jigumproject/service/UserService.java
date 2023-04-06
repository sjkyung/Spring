package com.example.jigumproject.service;

import com.example.jigumproject.dto.UserDto;
import com.example.jigumproject.entity.User;
import com.example.jigumproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    public List<UserDto> userDtoList(){

        List<UserDto> userDtoList = new ArrayList<>();
        List<User> userList =userRepository.findAll();

        userDtoList.add((UserDto) userList);

        return userDtoList;
    }
}
