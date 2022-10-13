package com.dailycodebuffer.dailycodebuffer.controller;

import com.dailycodebuffer.dailycodebuffer.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {


    @RequestMapping("/")
    public String home(){return "Hello home";}
     //    http://localhost:8080



    //    @RequestMapping("/user")
    //    @RequestMapping(value = "/user" , method = RequestMethod.GET)
    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setId("1");
        user.setName("Abubakr");
        user.setEmailId("abubakr.iut.1992@gmail.com");

        return user;
    }
      //http://localhost:8080/user






    @GetMapping("/{id}")
    public String pathVariable(@PathVariable String id ){
        return "The path variable is " + id;
    }
        //    http://localhost:8080/1   The path variable is 1
        //    http://localhost:8080/abdi   The path variable is abdi



    @GetMapping("/{id}/{id2}")
    public String pathVariable(@PathVariable String id,
    //                               @PathVariable String id2
                               @PathVariable("id2") String name
    ){
    //        return "The path Variable is " + id + " :) " + id2;
        return "The path Variable is " + id + " : " + name;
    }
        // http://localhost:8080/1/2
            // "The path Variable is 1 : 2
        // http://localhost:8080/home/profile
            // "The path Variable is home : profile



    //if data not mandaroty use requestParam   works with question marks

    @GetMapping("/requestParam")
    public String requestParam(@RequestParam String name ){
        return "Your name is : " + name;
    }
        // http://localhost:8080/requestParam?name=Abubakr
            // "Your name is :Abubakr

    @GetMapping("/requestParam2")
    public String requestParam2(@RequestParam String name,
                                @RequestParam String emailId
                                ){
        return "Your name is : " + name + " and your email is : " +emailId;
    }
        //http://localhost:8080/requestParam2?name=Abubakr&emailId=abubakr.iut.1992@gmail.com
            //Your name is : Abubakr and your email is : abubakr.iut.1992@gmail.com


    @GetMapping("/requestParamV3")
    public String requestParamV3(@RequestParam String name,
                                @RequestParam(name = "email", required = false , defaultValue = "") String emailId
    ){
        return "Your name is : " + name + " and your email is :" + emailId ;
    }
        //http://localhost:8080/requestParamV3?name=Abubakr
            //Your name is : Abubakr and your email is :null
            //Your name is : Abubakr and your email is                 //defaultValue=" "


}
