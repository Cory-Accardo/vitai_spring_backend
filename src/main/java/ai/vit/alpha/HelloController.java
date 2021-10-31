package ai.vit.alpha;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/welcome")
    public String welcome(){
        return "This means that you were successful cory!";
    }

    @GetMapping("/goodbye")
    public String goodbye(){
        return "Goodbye Cory!";
    }

}


