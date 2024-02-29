package com.example.jigumproject.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessMessage {

    OK(HttpStatus.OK,"200","요청에 성공했습니다."),
    CREATED(HttpStatus.CREATED,"201","요청에 성공했습니다.");


    private HttpStatus httpStatus;
    private String code;
    private String message;
}
