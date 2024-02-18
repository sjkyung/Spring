package com.example.jigumproject.dto;


import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class row {

    @Parameter(name = "거치대개수")
    private String rackTotCnt;
    @Parameter(name ="대여소이름")
    private String stationName;
    private String parkingBikeTotCnt;
//    private String shared;
    private String stationLatitude;
    private String stationLongitude;
    private String stationId;



//    public String subString(String stationLatitude, String stationLongitude){
//        this.stationLatitude.substring(0,5);
//        this.stationLongitude.substring(0,5);
//        return;
//    }
}
