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
    Stack<People> Peoples = new Stack<>();

    @GetMapping("/greeting")
    public String greeting(
                @RequestParam(
                    name = "name",
                    required = false,
                    defaultValue="HI") String name, Model model){
                
                People p = new People();
                if (Peoples.isEmpty()){
                    p.num = 0;
                }
                else{
                    People p1 = Peoples.peek();
                    p.setNum(p1.getNum() + 1);
                }

                name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                p.setName(name);
                Peoples.push(p);
                
                model.addAttribute("peoples",Peoples);
                return "greeting";
 }
}
