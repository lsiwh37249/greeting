package shop.samdul.greeting.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class greetingController {

    Stack<String> names = new Stack<String>();

    @GetMapping("/greeting")
    public String greeting(
                @RequestParam(
                    name = "name",
                    required = false,
                    defaultValue="HI") String name, Model model){
                names.push(name);
                
                model.addAttribute("names",names);
                return "greeting";
 }
}
