package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

record Message(String message){}
@Controller
public class HelloController {
    @GetMapping(path = "hello")
    @ResponseBody
    public String helloWorld(){
        return "<h1>Hello from Spring</h1>";}
    //Method will listen for Get request at /json and return application/json as content type
    @GetMapping(path = "/json", produces = "application/json")
    @ResponseBody
    public Message returnMessage(){
        return new Message("Hello from Spring!");
    }
    //Request mapping is the parent of all other mapping annotations and can be further customized.
    @RequestMapping(path = "/color", method = RequestMethod.GET)
    @ResponseBody
    public String color(){
        return "Royal Blue";
    }
    @GetMapping("/hello/{firstName}/{lastName}")
    @ResponseBody
    public String sayHello(@PathVariable String firstName, @PathVariable String lastName){
        return "<h1>Hello " + firstName + " " + lastName + "</h1>";
    }
}


