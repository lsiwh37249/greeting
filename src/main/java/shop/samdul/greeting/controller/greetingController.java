package shop.samdul.greeting.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import shop.samdul.greeting.controller.People;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class greetingController {
    Stack<People> peoples = new Stack<>();
    int i = 0;
    int num = 0;

    @GetMapping("/greeting")
    public String greeting(
                @RequestParam(
                    name = "name",
                    required = false,
                    defaultValue="HI") String name, Model model){
                i = i + 1;
                num = i;
                System.out.println("======================");
                name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                System.out.println(name);
                
                People people = new People(num, name);
                peoples.push(people);
                System.out.println("======================");
                
                model.addAttribute("peoples",peoples);
                return "greeting";
 }
}
