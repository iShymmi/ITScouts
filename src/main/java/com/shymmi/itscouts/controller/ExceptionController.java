package com.shymmi.itscouts.controller;

import com.shymmi.itscouts.exception.TalentNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(TalentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String handleTalentNotFoundException(TalentNotFoundException e){
        return e.getMessage();
    }
}
