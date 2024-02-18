package com.example.jigumproject.ctl;


import com.example.jigumproject.dto.UserDto;
import com.example.jigumproject.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@Tag(name = "테스트 컨트롤러")
@RequiredArgsConstructor
@RequestMapping("User")
public class TestController {

    private final UserService userService;

    @GetMapping(value = "ListAll")
    public List<UserDto> test(){

        log.info("test");
        List<UserDto> test =userService.userDtoList();

        return test;
    }



    @PostMapping(value = "userId")
    public List<UserDto> findUserId(@RequestBody UserDto userDto){

        log.info("findUserId");
        List<UserDto> userDtoList =userService.userListId(userDto);

        return userDtoList;
    }



}
