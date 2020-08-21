package com.dy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dy.service.UidGenService;

@RestController
public class UidController {
    @Autowired
    private UidGenService uidGenService;

    @GetMapping("/uidGenerator")
    public String UidGenerator() {
        return String.valueOf(uidGenService.getUid());
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
