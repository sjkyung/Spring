package com.example.jigumproject.ctl;


import com.example.jigumproject.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@Tag(name = "테스트 컨트롤러")
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;

    @GetMapping(value = "/jigum")
    public  List<String> test(){

        log.info("test");
        List<String> test =new ArrayList<>();

        return test;
    }



}
