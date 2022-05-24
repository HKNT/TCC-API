package com.tcc.agronomia.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {


    @GetMapping
    public String get(){
        return "API Agronomia";
    }

    @GetMapping("/userInfo")
    public UserDetails getUserInfo(@AuthenticationPrincipal UserDetails user){
        return user;
    }

}
