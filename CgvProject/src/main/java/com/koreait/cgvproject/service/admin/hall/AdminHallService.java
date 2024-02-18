package com.koreait.cgvproject.service.admin.hall;

import com.koreait.cgvproject.dto.HallDTO;
import com.koreait.cgvproject.entity.Hall;
import com.koreait.cgvproject.entity.Theater;
import com.koreait.cgvproject.repository.HallRepository;
import com.koreait.cgvproject.repository.TheaterRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AdminHallService {
    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private TheaterRepository theaterRepository;


    public int savePost(HallDTO hallDTO){
        Hall hall=new Hall();
        Theater theater=theaterRepository.findByTcode(hallDTO.getTcode());
        hall.setHcode(hallDTO.getHcode());
        hall.setTheater(theater);
        hall.setLocation(hallDTO.getLocation());
        hall.setHname(hallDTO.getHname());
        hall.setHguan(hallDTO.getHguan());
        hallRepository.save(hall);

    return 1;
    }

    public HallDTO findHall(Long hcode){
        Hall hall=hallRepository.findByHcode(hcode);
        if(hall!=null){
            HallDTO hallDTO=new HallDTO();
            hallDTO.setHguan(hall.getHguan());
            hallDTO.setLocation(hall.getLocation());
            hallDTO.setHname(hall.getHname());
            hallDTO.setTheater(hall.getTheater().toDTO());
            hallDTO.setTcode(hall.getTheater().getTcode());
            return hallDTO;
        }
        return null;

    }

    // theater service에 halllist 불러올수 있음
//    public List<HallDTO> getHallList(Long tcode){
//        Theater theater=theaterRepository.findByTcode(tcode);
//        System.out.println(theater);
//        List<Hall> hallList = hallRepository.findAllByTheater(theater);
//        System.out.println(hallList);
//        List<HallDTO> hallDTOList = new ArrayList<>();
//        for(Hall hall : hallList){
//            HallDTO hallDTO = HallDTO.builder().hcode(hall.getHcode())
//                    .tcode(hall.getTheater().getTcode()).location(hall.getLocation())
//                    .hname(hall.getHname()).build();
//            hallDTOList.add(hallDTO);
//
//        }
//
//        return hallDTOList;
//    }
}
