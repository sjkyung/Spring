package com.koreait.cgvproject.service.admin.theater;

import com.koreait.cgvproject.dto.HallDTO;
import com.koreait.cgvproject.dto.TheaterDTO;
import com.koreait.cgvproject.entity.Theater;
import com.koreait.cgvproject.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminTheaterService {

    @Autowired
    private TheaterRepository theaterRepository;


    // 극장 코드 정보 받기
    public List<TheaterDTO> getCGV(Long acode){
        List<Theater> theaterlist=theaterRepository.findAllByAreacode(acode);
        List<TheaterDTO> cgvDTOlist = new ArrayList<>();
        for(Theater theater : theaterlist) cgvDTOlist.add(theater.toDTO());
        return cgvDTOlist;
    }

    public TheaterDTO getTheater(Long tcode) {
        Theater theater = theaterRepository.findByTcode(tcode);
        TheaterDTO findtheaterDTO = theater.toDTO();
        return findtheaterDTO;

    }


    public List<TheaterDTO> findAll() {
        List<Theater> theaterList=theaterRepository.findAll();
        List<TheaterDTO> theaterDTOList= new ArrayList<>();
        for(Theater theater: theaterList){
            theaterDTOList.add(theater.toDTO());
        }
        return theaterDTOList;

    }
    public List<HallDTO> getHallList(Long tcode) {
        Theater theater=theaterRepository.findByTcode(tcode);
        List<HallDTO> hallDTOList=new ArrayList<>();
        if(theater!=null){
            theater.getHalls().stream().forEach(hall -> {
                hallDTOList.add(hall.toDTO());

            });
        }
        return hallDTOList;
    }

    // 극장 tname으로 theater 반환하기
    public TheaterDTO getTnameSendtheater(String tname){
        TheaterDTO theaterDTO=new TheaterDTO();
        Theater theater=theaterRepository.findByTname(tname);
        if(theater != null){
            theaterDTO=theater.toDTO();
        }
        return theaterDTO;
    }

}