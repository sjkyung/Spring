package com.example.jigumproject.ctl;


import com.example.jigumproject.dto.UserDto;
import com.example.jigumproject.service.BikeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@Tag(name = "공공 api 연결 컨트롤러")
@RequiredArgsConstructor
public class bikeController {

    private  final BikeService bikeService;

    @GetMapping(value = "ListAll")
    public List test() throws IOException {

        log.info("test");
        //bikeService.bikeList();

        List test =new ArrayList();
        return test;
    }


    @GetMapping(value = "bikeList/{start}/{end}")
    public List bikeList(int start,int end) throws IOException {

        log.info("start,end  : {},{} ",start, end);
        bikeService.bikeList(start,end);

        List test =new ArrayList();
        return test;
    }
}
