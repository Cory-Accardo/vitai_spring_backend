package ai.vit.alpha;


import ai.vit.alpha.model.Resumes;
import ai.vit.alpha.model.Users;
import ai.vit.alpha.repository.ResumesRepository;
import ai.vit.alpha.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)
@EnableMongoRepositories
public class VitaiAlphaApplication implements CommandLineRunner {

	@Autowired
	UsersRepository userRepo;
	@Autowired
	ResumesRepository resumeRepo;

	public static void main(String[] args) {
		SpringApplication.run(VitaiAlphaApplication.class, args);
	}



	public void run(String... args) throws IOException, InterruptedException {
//		Gpt3Gen gpt3gen = new Gpt3Gen("Stalin was a leader who");
//		ConcurrentHashMap<String, String> info = new ConcurrentHashMap<>();
//		info.put("email", "stalin@uc.edu");
//		info.put("phone", "626-222-9999");
//		info.put("expComp1", " ");
//		createResume(info);
//		System.out.println(getResumeInfo(info));
//		findUser("Jarret");
//		ConcurrentHashMap<String, String> info = new ConcurrentHashMap<String, String>();
//		info.put("username", "spino@usc.edu");
//		info.put("someshit", null);
//		info.put("age", "34");
//		try{updateUser(info);} catch (Exception e) {
//			System.out.println(e.getMessage());}
//		findUser("Jarret");
//		Users j = userRepo.findByUsername("spino@usc.edu");
//		ConcurrentHashMap<String, String> chloe = new ConcurrentHashMap<String, String>();
//		chloe.put("username", "chagmann@usc.edu");
//		chloe.put("password", "peopleperson");
//		chloe.put("age", "23");
//		chloe.put("firstName", "Chloe");
//		chloe.put("lastName", "Hagmann");
//		chloe.put("homeCity", "Los Angeles");
//		createUser(chloe);
//		findUser("Chloe");
//		ConcurrentHashMap<String, String> eli = new ConcurrentHashMap<String, String>();
//		eli.put("username", "elimorri@usc.edu");
//		eli.put("password", "batistasurvivor");
//		eli.put("age", "20");
//		eli.put("firstName", "Eli");
//		eli.put("lastName", "morris");
//		eli.put("homeCity", "Los Angeles");
//		createUser(eli);
//		findUser("Eli");



	}
}