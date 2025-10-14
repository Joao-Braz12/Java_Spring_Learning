package dev.Braz.spring_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/wellcome")
    public String WellCome(){
        return  "Boas Vindas";
    }

}
