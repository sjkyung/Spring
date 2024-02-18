package com.example.jigumproject.service;

import com.example.jigumproject.dto.UserDto;
import com.example.jigumproject.entity.User;
import com.example.jigumproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    public List<UserDto> userDtoList(){

        List<UserDto> userDtoList = new ArrayList<>();
        List<User> userList =userRepository.findAll();


        userList.forEach(user -> {
            userDtoList.add(user.toDto());
        });

        return userDtoList;
    }


    public  List<UserDto> userListId(UserDto userDto){

        List<UserDto> userDtoList =new ArrayList<>();

        User user =userDto.toEntity();
        Optional<User> userList =userRepository.findById(user.getId());
        if(userList.isPresent()){
            userDtoList.add(userList.get().toDto());
        }


        return userDtoList;
    }


}
