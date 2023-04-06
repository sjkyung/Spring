package com.example.jigumproject.ctl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class TestController {



    @GetMapping(value = "/jigum")
    public  List<String> test(){

        log.info("test");
        List<String> test =new ArrayList<>();

        return test;
    }



}
