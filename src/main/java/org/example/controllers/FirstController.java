package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){
        model.addAttribute("result", "Your name and surname: "+name +" " +  surname);
        return "first/hello";
    }

    @GetMapping("/goodbay")
    public String goodbayPage(){
        return "first/goodbay";
    }

    @GetMapping("/exit")
    public String exitPage(){
        return "first/exit";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a") int a,
                             @RequestParam(value = "b") int b,
                             @RequestParam(value = "action") char action,
                             Model model){

        try {
            if(action == '/' && b == 0){
                model.addAttribute("result", "Error: Division by zero is not allowed!");
            }
            else {
                switch (action) {
                    case '+':
                        model.addAttribute("a", "a = "+a);
                        model.addAttribute("b", "b = " +b);
                        model.addAttribute("action", "action = "+ action);
                        model.addAttribute("result", "Result: " + (a + b));
                        break;
                    case '-':
                        model.addAttribute("a", "a = "+a);
                        model.addAttribute("b", "b = " +b);
                        model.addAttribute("action", "action = "+ action);
                        model.addAttribute("result", "Result: " + (a - b));
                        break;
                    case '*':
                        model.addAttribute("a", "a = "+a);
                        model.addAttribute("b", "b = " +b);
                        model.addAttribute("action", "action = "+ action);
                        model.addAttribute("result", "Result: " + (a * b));
                        break;
                    case '/':
                        model.addAttribute("a", "a = "+a);
                        model.addAttribute("b", "b = " +b);
                        model.addAttribute("action", "action = "+ action);
                        model.addAttribute("result", "Result: " + (a / b));
                        break;
                    default:
                        model.addAttribute("result", "Result: Invalid operation!");
                }
            }
        } catch (Exception e) {
            return String.valueOf(new ArithmeticException());
        }

        return "first/calculator";
    }
}
