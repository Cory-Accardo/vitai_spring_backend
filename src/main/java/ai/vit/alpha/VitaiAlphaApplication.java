package ai.vit.alpha;


import ai.vit.alpha.model.Users;
import ai.vit.alpha.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableMongoRepositories
public class VitaiAlphaApplication implements CommandLineRunner {

	@Autowired
	UsersRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(VitaiAlphaApplication.class, args);
	}

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
		userRepo.save(new Users(info.get("username")));
		updateUser(info);
	}

	public void destroyUser(String username){

	}





	public void run(String... args) {

		findUser("Jarret");
		HashMap<String, String> info = new HashMap<String, String>();
		info.put("username", "spino@usc.edu");
		info.put("someshit", null);
		info.put("age", "34");
		try{updateUser(info);} catch (Exception e) {
			System.out.println(e.getMessage());}
		findUser("Jarret");
		Users j = userRepo.findByUsername("spino@usc.edu");
		HashMap<String, String> chloe = new HashMap<String, String>();
		chloe.put("username", "chagmann@usc.edu");
		chloe.put("password", "peopleperson");
		chloe.put("age", "23");
		chloe.put("firstName", "Chloe");
		chloe.put("lastName", "Hagmann");
		chloe.put("homeCity", "Los Angeles");
		createUser(chloe);
		findUser("Chloe");
        HashMap<String, String> eli = new HashMap<String, String>();
        eli.put("username", "elimorri@usc.edu");
        eli.put("password", "batistasurvivor");
        eli.put("age", "20");
        eli.put("firstName", "Eli");
        eli.put("lastName", "morris");
        eli.put("homeCity", "Los Angeles");
		createUser(eli);
		findUser("Eli");


	}
}