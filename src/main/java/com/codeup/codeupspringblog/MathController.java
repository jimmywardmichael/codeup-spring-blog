package com.codeup.codeupspringblog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class MathController {
    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String basicArithmetic(@PathVariable int number, int number2) {
        return number + " plus one is " + (number + 1) + "!";
    }

}
