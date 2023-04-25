package com.example.jigumproject.service;


import com.example.jigumproject.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class BikeService {



        // http://localhost:9090/api/server/hello 로 요청해서 response를 받아오기
        //http://openapi.seoul.go.kr:8088/464e43766a736a6b383768444b516b/json/bikeList/1/1000/ 따릉이 api
        public Map bikeList(int start,int end){
            // uri 주소 생성
            URI uri = UriComponentsBuilder
                    .fromUriString("http://openapi.seoul.go.kr:8088") //http://localhost에 호출
                    .path("/464e43766a736a6b383768444b516b/json/bikeList")
                    .path("/1/1000/")
//                    .queryParam("name", "steve")  // query parameter가 필요한 경우 이와 같이 사용
//                    .queryParam("age", 10)
                    .encode()
                    .build()
                    .toUri();

            System.out.println(uri.toString());

            RestTemplate restTemplete = new RestTemplate();

            ResponseEntity<Map> result = restTemplete.getForEntity(uri, Map.class);
            // entity로 데이터를 가져오겠다(Get)~~
            System.out.println(result.getStatusCode());
            System.out.println(result.getBody());

            return result.getBody();
        }


}
