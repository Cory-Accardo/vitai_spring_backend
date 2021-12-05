package ai.vit.alpha;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class HelloController {

    @GetMapping("/welcome")
    public String welcome(){
        return "This means that you were successful cory!";
    }



    @GetMapping("/goodbye")
    @ResponseBody
    public String goodbye(@RequestBody String body) throws JsonProcessingException {
        HashMap theBody = new HashMap<String, String>();
        ObjectMapper objectMapper = new ObjectMapper();
        theBody = objectMapper.readValue(body, HashMap.class);
        System.out.println(theBody.get("username"));
        return "Goodbye Cory!";
    }

    @GetMapping("/foopa")
    public String foopa(){
        return "troopa!";
    }

}

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ResourceNotFoundException extends RuntimeException {
}

//LOOK AT THIS
//    @ResponseBody
//    public ResponseTransfer postResponseController(
//            @RequestBody LoginForm loginForm) {
//        return new ResponseTransfer("Thanks For Posting!!!");
//    }