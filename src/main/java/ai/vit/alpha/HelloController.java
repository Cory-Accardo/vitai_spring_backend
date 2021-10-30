package ai.vit.alpha;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

    public String hello(){
        return "Good Job Cory, you did it!";
    }

}
