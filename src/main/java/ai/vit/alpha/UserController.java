package ai.vit.alpha;

import ai.vit.alpha.model.Users;
import ai.vit.alpha.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
//@EnableMongoRepositories
public class UserController {

    @Autowired
    UsersRepository userRepo;

    public void findUser(String firstName){
        Users users = userRepo.findByFirstName(firstName);
        System.out.println("User with First Name: " + users.getFirstName() + " " + users.getLastName());
    }

    public void updateUser(Map<String, String> info){
        Users user = userRepo.findByUsername(info.get("username"));
        info.forEach((k, v) ->{
                    switch (k) {
                        case "username"  : 						 break;
                        case "age" 		 : user.setAge(v);		 break;
                        case "password"  : user.setPassword(v);  break;
                        case "firstName" : user.setFirstName(v); break;
                        case "lastName"  : user.setLastName(v);  break;
                        case "homeCity"  : user.setHomeCity(v);  break;
                        case "gender" 	 : user.setGender(v);    break;
                        case "ethnicity" : user.setEthnicity(v); break;
                        case "homeState" : user.setHomeState(v); break;
                        default:
                            throw new IllegalArgumentException(
                                    "Invalid key: " + k + " for " + v);
                    }
                }
        );
        userRepo.save(user);
    }

    public HashMap<String, String> getUserInfo(HashMap<String, String> who){
        Users user = userRepo.findByUsername(who.get("username"));
        who.forEach((k, v) -> {
            switch(k) {
                case "username"  : 						            break;
                case "age" 		 : who.put(k, user.getAge());	    break;
                case "firstName" : who.put(k, user.getFirstName()); break;
                case "lastName"  : who.put(k, user.getLastName());  break;
                case "homeCity"  : who.put(k, user.getHomeCity());  break;
                case "gender" 	 : who.put(k, user.getGender());    break;
                case "ethnicity" : who.put(k, user.getEthnicity()); break;
                case "homeState" : who.put(k, user.getHomeState()); break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid key: " + k);
            }
        });
        return who;
    }

    public void createUser(Map<String, String> info){
        System.out.println("Map contains elem: " + info.get("username"));
        userRepo.save(new Users(info.get("username")));
        updateUser(info);
    }

}
