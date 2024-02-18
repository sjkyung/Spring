package com.koreait.cgvproject.controller.user.page;

import com.koreait.cgvproject.dto.FavCGVDTO;
import com.koreait.cgvproject.dto.HallDTO;
import com.koreait.cgvproject.dto.PriceDTO;
import com.koreait.cgvproject.dto.TheaterDTO;
import com.koreait.cgvproject.entity.Member;
import com.koreait.cgvproject.repository.MemberRepository;
import com.koreait.cgvproject.service.admin.price.AdminPriceService;
import com.koreait.cgvproject.service.admin.theater.AdminTheaterService;
import com.koreait.cgvproject.service.user.mycgv.UserFavCGVService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@AllArgsConstructor
@Controller
public class UserTheatersController {
    private HttpSession session;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private UserFavCGVService userFavCGVService;
    @Autowired
    private AdminTheaterService adminTheaterService;
    @Autowired
    private AdminPriceService adminPriceService;


    @GetMapping("/theaters")
    public String theaters(Model model){
        List<TheaterDTO> theaterDTOList=adminTheaterService.getCGV(1L);
        List<HallDTO> lengthhalls=adminTheaterService.getHallList(theaterDTOList.get(0).getTcode());

        if(session.getAttribute("userid") != null){
            Member member = memberRepository.findByUserid((String)session.getAttribute("userid"));
            List<FavCGVDTO> favCGVDTOS=userFavCGVService.list(member);
            model.addAttribute("theater",theaterDTOList.get(0));
            model.addAttribute("lengthhalls", lengthhalls.size());
            model.addAttribute("halls", lengthhalls);
            model.addAttribute("tcode",theaterDTOList.get(0).getTcode());
            session.setAttribute("favCGV", favCGVDTOS);
        }
        else if(session.getAttribute("userid") == null){
            model.addAttribute("theater",theaterDTOList.get(0));
            model.addAttribute("lengthhalls", lengthhalls.size());
            model.addAttribute("halls", lengthhalls);
            model.addAttribute("tcode",theaterDTOList.get(0).getTcode());
        }

        return "user/theaters/theaters";
    }

    @GetMapping("/theaters/{tcode}")
    public String theatersview(@PathVariable Long tcode, Model model){
        TheaterDTO theaterDTO=adminTheaterService.getTheater(tcode);
        List<HallDTO> lengthhalls=adminTheaterService.getHallList(tcode);
        model.addAttribute("theater", theaterDTO);
        model.addAttribute("lengthhalls", lengthhalls.size());
        model.addAttribute("halls", lengthhalls);
        model.addAttribute("tcode", tcode);
        return "/user/theaters/theaters";
    }


    @GetMapping("/theaters/theaterPrice/{tcode}")
    public String thPrice(@PathVariable("tcode") Long tcode, Model model){
        List<PriceDTO> priceDTO=adminPriceService.read(tcode);
        TheaterDTO theaterDTO=adminTheaterService.getTheater(tcode);
        model.addAttribute("theaterprice", priceDTO);
        model.addAttribute("theater", theaterDTO);
        return "user/theaters/theaterPrice";
    }

}
