package com.koreait.cgvproject.controller.admin.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminQnaController {


    @GetMapping("mailList")//mailList 페이지
    public String mailList(){
        return "admin/qna/mailList";
    }

    @GetMapping("orgList")//orgList 페이지
    public String orgLst(){
        return "admin/qna/orgList";
    }

    @GetMapping("lostList")//lostList 페이지
    public String lostList(){
        return "admin/qna/lostList";
    }

    @GetMapping("manage_AskAnswer")//lostList 페이지
    public String manage_AskAnswer(){
        return "admin/qna/manage_AskAnswer";
    }
}
