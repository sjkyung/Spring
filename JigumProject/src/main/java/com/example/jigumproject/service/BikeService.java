package com.example.jigumproject.service;


import com.example.jigumproject.dto.apiDto;
import com.example.jigumproject.dto.row;
import com.example.jigumproject.entity.Bike;
import com.example.jigumproject.repository.BikeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
@Slf4j
public class BikeService {

        private final BikeRepository bikeRepository;


        // http://localhost:9090/api/server/hello 로 요청해서 response를 받아오기
        //http://openapi.seoul.go.kr:8088/464e43766a736a6b383768444b516b/json/bikeList/1/1000/ 따릉이 api
        @Transactional
        public List<row> bikeList(String startLatitude, String endLatitude){

        Optional<Bike> bikeKey = bikeRepository.findById(1L);
        String  apiBikeKey = bikeKey.get().getKey();
        List<row> bikeDtoList = new ArrayList();

        String start = startLatitude.substring(0,5);
        String end =endLatitude.substring(0,5);



            // uri 주소 생성
            URI uri1 = UriComponentsBuilder
                    .fromUriString("http://openapi.seoul.go.kr:8088/") //http://localhost에 호출
                    .path(apiBikeKey)
                    .path("/json/bikeList/1/1000/")
                    .encode().build().toUri();

            log.info("url1 toString : {}",uri1.toString());

            RestTemplate restTemplete1 = new RestTemplate();

            ResponseEntity<apiDto> result1 = restTemplete1.getForEntity(uri1, apiDto.class);
            // entity로 데이터를 가져오겠다(Get)~~
            //System.out.println(result1.getStatusCode());
            //System.out.println(result1.getBody());
            ArrayList<row> rowArrayListFirst = result1.getBody().getRentBikeStatus().getRow();


            URI uri2 = UriComponentsBuilder
                    .fromUriString("http://openapi.seoul.go.kr:8088/") //http://localhost에 호출
                    .path(apiBikeKey)
                    .path("/json/bikeList/1001/2000/")
                    .encode()
                    .build()
                    .toUri();

            log.info("url2 toString {}",uri2.toString());

            RestTemplate restTemplete2 = new RestTemplate();

            ResponseEntity<apiDto> result2 = restTemplete2.getForEntity(uri2, apiDto.class);
            // entity로 데이터를 가져오겠다(Get)~~
            //System.out.println(result2.getStatusCode());
            //System.out.println(result2.getBody().getRentBikeStatus().getRow());

            ArrayList<row> rowArrayListTwo =result2.getBody().getRentBikeStatus().getRow();


            //bikeDtoList.stream().map(value ->)
//            bikeDtoList.add(rowArrayListTwo);
//            bikeDtoList.add(rowArrayListFirst);

            bikeDtoList = Stream.concat(rowArrayListFirst.stream(),rowArrayListTwo.stream()).collect(Collectors.toList());

            //bikeDtoList.forEach(f -> System.out.println(f.getStationLatitude()));


            //parameter 위도 경도 받아서  list 데이터 정제
            List<row> bikeList = bikeDtoList.stream()
                    .filter(f -> f.getStationLatitude().contains(start) && f.getStationLongitude().contains(end))
                    .collect(Collectors.toList());


            List<row> bikeListstartLatitude = bikeDtoList.stream()
                    .filter(f -> f.getStationLatitude().startsWith(startLatitude))
                    .collect(Collectors.toList());



            return bikeList;
        }


}
