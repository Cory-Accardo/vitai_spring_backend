package ai.vit.alpha;


import ai.vit.alpha.model.Resumes;
import ai.vit.alpha.model.Users;
import ai.vit.alpha.repository.ResumesRepository;
import ai.vit.alpha.repository.UsersRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ResponseStatus(HttpStatus.OK)
public class HelloController {


    private final UsersRepository userRepo;
    private final ResumesRepository resumeRepo;
    private static final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();


    HelloController (UsersRepository ur, ResumesRepository rr) {
        userRepo = ur;
        resumeRepo = rr;
    }

    public void findUser(String firstName){
        Users users = userRepo.findByFirstName(firstName);
        System.out.println("User with First Name: " + users.getFirstName() + " " + users.getLastName());
    }

    public void updateUser(Map<String, String> info) throws IllegalArgumentException {
        updateUser(info, userRepo);
    }

    public static void updateUser(Map<String, String> info, UsersRepository userRepo) throws IllegalArgumentException {
        Users user = userRepo.findByUsername(info.get("username"));
        info.forEach((k, v) ->{
                    switch (k) {
                        case "username"  : 						                break;
                        case "age" 		 : user.setAge(v);		                break;
                        case "password"  : user.setPassword(bcrypt.encode(v));  break;
                        case "firstName" : user.setFirstName(v);                break;
                        case "lastName"  : user.setLastName(v);                 break;
                        case "homeCity"  : user.setHomeCity(v);                 break;
                        case "gender" 	 : user.setGender(v);                   break;
                        case "ethnicity" : user.setEthnicity(v);                break;
                        case "homeState" : user.setHomeState(v);                break;
                        case "job1"      : user.setJob1(v);                     break;
                        case "job2"      : user.setJob2(v);                     break;
                        case "job3"      : user.setJob3(v);                     break;
                        case "role1"     : user.setRole1(v);                    break;
                        case "role2"     : user.setRole2(v);                    break;
                        case "role3"     : user.setRole3(v);                    break;
                        case "location1" : user.setLocation1(v);                break;
                        case "location2" : user.setLocation2(v);                break;
                        case "location3" : user.setLocation3(v);                break;
                        default:
                            throw new IllegalArgumentException(
                                    "Invalid key: " + k + " for " + v);
                    }
                }
        );
        userRepo.save(user);
    }

//    public  ConcurrentHashMap<String, String> getUserInfo(ConcurrentHashMap<String, String> who){
    public  Users getUserInfo(ConcurrentHashMap<String, String> who){
        return userRepo.findByUsername(who.get("username"));
//        who.forEach((k, v) -> {
//            switch(k) {
//                case "username"  : 						            break;
//                case "age" 		 : who.put(k, user.getAge());	    break;
//                case "firstName" : who.put(k, user.getFirstName()); break;
//                case "lastName"  : who.put(k, user.getLastName());  break;
//                case "homeCity"  : who.put(k, user.getHomeCity());  break;
//                case "gender" 	 : who.put(k, user.getGender());    break;
//                case "ethnicity" : who.put(k, user.getEthnicity()); break;
//                case "homeState" : who.put(k, user.getHomeState()); break;
//                default:
//                    throw new IllegalArgumentException(
//                            "Invalid key: " + k);
//            }
//        });
//        return who;
    }

    public void createUser(Map<String, String> info) throws RuntimeException {
        try  {
            userRepo.save(new Users(info.get("username")));
            updateUser(info);
        }
        catch (IllegalArgumentException e) {
            throw new RuntimeException();
        }

        catch (ClassCastException e) {
            throw new RuntimeException();
        }

        catch (NullPointerException e) {
            throw new RuntimeException();
        }
    }

    public void updateResume(Map<String,String> info) throws IllegalArgumentException {
        Resumes resume = resumeRepo.findByEmail(info.get("email"));
        info.forEach((k, v) ->{
                    switch (k) {
                        case "id"               : resume.setId(v);               break;
                        case "email"            : resume.setEmail(v);            break;
                        case "address"          : resume.setAddress(v);          break;
                        case "phone"            : resume.setPhone(v);            break;
                        case "website"          : resume.setWebsite(v);          break;
                        case "executiveSummary" : resume.setExecutiveSummary(v); break;
                        case "expComp1"         : resume.setExpComp1(v);         break;
                        case "expRole1"         : resume.setExpRole1(v);         break;
                        case "expDesc1"         : resume.setExpDesc1(v);         break;
                        case "expComp2"         : resume.setExpComp2(v);         break;
                        case "expRole2"         : resume.setExpRole2(v);         break;
                        case "expDesc2"         : resume.setExpDesc2(v);         break;
                        case "expComp3"         : resume.setExpComp3(v);         break;
                        case "expRole3"         : resume.setExpRole3(v);         break;
                        case "expDesc3"         : resume.setExpDesc3(v);         break;
                        case "skills1"			: resume.setSkills1(v);			 break;
                        case "skills2"			: resume.setSkills2(v);			 break;
                        case "skills3"			: resume.setSkills3(v);			 break;
                        case "education1"		: resume.setEducation1(v);		 break;
                        case "education2"		: resume.setEducation2(v);		 break;
                        case "education3"		: resume.setEducation3(v);		 break;
                        case "projTitle1"       : resume.setProjTitle1(v);       break;
                        case "projAssoc1"       : resume.setProjAssoc1(v);       break;
                        case "projDesc1"        : resume.setProjDesc1(v);        break;
                        case "projTitle2"       : resume.setProjTitle2(v);       break;
                        case "projAssoc2"       : resume.setProjAssoc2(v);       break;
                        case "projDesc2"        : resume.setProjDesc2(v);        break;
                        case "projTitle3"       : resume.setProjTitle3(v);       break;
                        case "projAssoc3"       : resume.setProjAssoc3(v);       break;
                        case "projDesc3"        : resume.setProjDesc3(v);        break;
                    }
                }
        );
        resumeRepo.save(resume);

    }




    public void createResume(Map<String, String> info) throws RuntimeException {
        try  {
            System.out.println(info.get("email"));
            Gpt3Gen gpt3gen = new Gpt3Gen("Stalin was a leader who");
            info.put("executiveSummary", gpt3gen.getExecSum());
            resumeRepo.save(new Resumes(info.get("email")));
            updateResume(info);
        }
        catch (IllegalArgumentException e) {
            throw new RuntimeException();
        }

        catch (ClassCastException e) {
            throw new RuntimeException();
        }

        catch (NullPointerException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "This means that you were successful cory!";
    }

    @PostMapping("/friends_list")
    @ResponseBody
    public ArrayList<String> friends(){
        ArrayList<String> friends = new ArrayList<String>();
        userRepo.findAll().forEach(f->friends.add(f.getUsername()));
        MultithreadedSorter.sort(friends);
        return friends;
    }

    @PostMapping("/generate")
    @ResponseBody
    public String generate(@RequestBody String thePrompt) throws JsonProcessingException {
        String execS = "is a hard worker and a great communicator.";
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, String> pMap = objectMapper.readValue(thePrompt, HashMap.class);
        try {
            Gpt3Gen gpt3gen = new Gpt3Gen(pMap.get("prompt"));
            execS = gpt3gen.getExecSum();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return execS;
    }

    @PostMapping("/signup")
    @ResponseBody
    public void signup(@RequestBody String body)
    {
        ConcurrentHashMap theBody;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            theBody = objectMapper.readValue(body, ConcurrentHashMap.class);
            System.out.println(theBody);
            if (userRepo.findByUsername((String) theBody.get("username")) != null)
                throw new RuntimeException();
            createUser(theBody);

        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException();
        }

        catch (RuntimeException e) {
            e.printStackTrace();
            throw new BadRequestException();
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public void login(@RequestBody String body)
    {
        ConcurrentHashMap theBody;
        ObjectMapper objectMapper = new ObjectMapper();
        String username;
        String password;


        try{
            theBody = objectMapper.readValue(body, ConcurrentHashMap.class);
            username =(String) theBody.get("username");
            password =(String) theBody.get("password");
        }
        catch (Exception e) {
            throw new BadRequestException();
        }


        if (!isAuthenticated(username,password))
            throw new UnauthException();
    }

    @PostMapping("/update_user")
    @ResponseBody
    public void post_update_user(@RequestBody String body)
    {
        ConcurrentHashMap theBody;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            theBody = objectMapper.readValue(body, ConcurrentHashMap.class);
            String username =(String) theBody.get("username");
            String password =(String) theBody.get("password");
            if (!isAuthenticated(username,password))throw new UnauthException();
            updateUser(theBody);

        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException();
        }

        catch (RuntimeException e) {
            e.printStackTrace();
            throw new BadRequestException();
        }
    }

    @PostMapping("/create_resume")
    @ResponseBody
    public void post_create_resume(@RequestBody String body)    {
        ConcurrentHashMap bodyNoArray;
        ConcurrentHashMap bodyArray;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            bodyNoArray = objectMapper.readValue(body, ConcurrentHashMap.class);
            bodyArray = objectMapper.readValue(body, ConcurrentHashMap.class);


            String username = (String) bodyNoArray.get("username");
            String password = (String) bodyNoArray.get("password");

            System.out.println(bodyNoArray);
            System.out.println(bodyArray);

            if (!isAuthenticated(username,password))throw new UnauthException();
            createResume(bodyNoArray);

        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException();
        }
        catch (UnauthException e) {
            e.printStackTrace();
            throw new UnauthException();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            throw new BadRequestException();
        }
    }

    
    @PostMapping("/update_resume")
    @ResponseBody
    public void post_update_resume(@RequestBody String body)
    {
        ConcurrentHashMap bodyNoArray;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            bodyNoArray = objectMapper.readValue(body, ConcurrentHashMap.class);
            
            String username = (String) bodyNoArray.get("username");
            String password = (String) bodyNoArray.get("password");

            System.out.println(bodyNoArray);

            if (!isAuthenticated(username,password))throw new UnauthException();
            updateResume(bodyNoArray);

        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException();
        }
        catch (UnauthException e) {
            e.printStackTrace();
            throw new UnauthException();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            throw new BadRequestException();
        }

    }

    @PostMapping("/get_user")
    @ResponseBody
    public Users get_user(@RequestBody String body)
    {
        
        ConcurrentHashMap theBody;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            theBody = objectMapper.readValue(body, ConcurrentHashMap.class);

            System.out.println(theBody);
            String username =(String) theBody.get("username");
            return  userRepo.findByUsername((String)theBody.get("username"));

        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException();
        }

        catch (RuntimeException e) {
            e.printStackTrace();
            throw new BadRequestException();
        }
    }

    @PostMapping("/get_resume")
    @ResponseBody
//    public ConcurrentHashMap<String, String> get_resume(@RequestBody String body)
    public Resumes get_resume(@RequestBody String body)
    {
        
        ConcurrentHashMap theBody;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            theBody = objectMapper.readValue(body, ConcurrentHashMap.class);
            String username =(String) theBody.get("username");
            String password =(String) theBody.get("password");
            if (!isAuthenticated(username,password))throw new UnauthException();
            theBody.put("email", theBody.get("username"));
            theBody.remove("username");
            theBody.remove("password");

            return getResumeInfo(theBody);

        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException();
        }

        catch (RuntimeException e) {
            e.printStackTrace();
            throw new BadRequestException();
        }
    }


//    public  ConcurrentHashMap<String, String> getResumeInfo(ConcurrentHashMap<String, String> what){
    public  Resumes getResumeInfo(ConcurrentHashMap<String, String> what){
        return resumeRepo.findByID(what.get("email"));

//        what.forEach((k, v) -> {
//            switch(k) {
//                case "email"                : what.put(k, resume.getEmail());               break;
//                case "address"   		 	: what.put(k, resume.getAddress());	   			break;
//                case "phone"     		 	: what.put(k, resume.getPhone());				break;
//                case "website"   	   		: what.put(k, resume.getWebsite());  			break;
//                case "executiveSummary"		: what.put(k, resume.getExecutiveSummary());	break;
//                case "expComp1"				: what.put(k, resume.getExpComp1());			break;
//                case "expRole1"				: what.put(k, resume.getExpRole1());			break;
//                case "expDesc1"				: what.put(k, resume.getExpDesc1());			break;
//                case "expComp2"				: what.put(k, resume.getExpComp2());			break;
//                case "expRole2"				: what.put(k, resume.getExpRole2());			break;
//                case "expDesc2"				: what.put(k, resume.getExpDesc2());			break;
//                case "expComp3"				: what.put(k, resume.getExpComp3());			break;
//                case "expRole3"				: what.put(k, resume.getExpRole3());			break;
//                case "expDesc3"				: what.put(k, resume.getExpDesc3());			break;
//                case "skills1"				: what.put(k, resume.getSkills1());				break;
//                case "skills2"				: what.put(k, resume.getSkills2());				break;
//                case "skills3"				: what.put(k, resume.getSkills3());				break;
//                case "education1"			: what.put(k, resume.getEducation1());			break;
//                case "education2"			: what.put(k, resume.getEducation2());			break;
//                case "education3"			: what.put(k, resume.getEducation3());			break;
//                case "projTitle1"           : what.put(k, resume.getProjTitle1());          break;
//                case "projAssoc1"           : what.put(k, resume.getProjAssoc1());          break;
//                case "projDesc1"            : what.put(k, resume.getProjDesc1());           break;
//                case "projTitle2"           : what.put(k, resume.getProjTitle2());          break;
//                case "projAssoc2"           : what.put(k, resume.getProjAssoc2());          break;
//                case "projDesc2"            : what.put(k, resume.getProjDesc2());           break;
//                case "projTitle3"           : what.put(k, resume.getProjTitle3());          break;
//                case "projAssoc3"           : what.put(k, resume.getProjAssoc3());          break;
//                case "projDesc3"            : what.put(k, resume.getProjDesc3());           break;
//                default:
//                    throw new IllegalArgumentException(
//                            "Invalid key: " + k);
//            }
//        });
//        return what;
    }

    boolean isAuthenticated(String username, String pwd)
    {
       Users user = userRepo.findByUsername(username);
       if (user == null)
           return false;

       if (bcrypt.matches(pwd,user.getPassword()))
           return true;

       return false;
    }

//    @GetMapping("/resumes")
//    @ResponseBody
//    public ConcurrentHashMap getResumes(@RequestBody String body)
//    {
//        ConcurrentHashMap theBody;
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            theBody = objectMapper.readValue(body, ConcurrentHashMap.class);
//            String username =(String) theBody.get("username");
//            String password =(String) theBody.get("password");
//            if (!isAuthenticated(username,password))throw new UnauthException();
//
//
//            Users user = userRepo.findByUsername(username);
//
//            if (user == null) throw new ResourceNotFoundException();
//            ArrayList<String> resumeIDs = user.getAuthorizedResumes();
//            if (resumeIDs == null) throw new ResourceNotFoundException();
//            if (resumeIDs.isEmpty()) throw new ResourceNotFoundException();
//
//            ArrayList<Resumes> resumesList = new ArrayList<Resumes>();
//
//            for (String res : resumeIDs) {
//                Resumes resume = resumeRepo.findByID(res);
//                if (resume != null) {
//                    resumesList.add(resume);
//                }
//            }
//
//            return resumesList;
//
//        }
//        catch(Exception e){
//            e.printStackTrace();
//            throw new BadRequestException();
//        }
//
//    }

}

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ResourceNotFoundException extends RuntimeException {
}

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
class UnauthException extends RuntimeException {

}
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class BadRequestException extends RuntimeException {

}