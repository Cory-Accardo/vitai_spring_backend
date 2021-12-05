package ai.vit.alpha.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("users")
public class Users {
    @Id
    private String id;

    public String username;
    private String password;
    private String salt;
    public String firstName;
    public String lastName;
    public String age;
    public String gender;
    public String ethnicity;
    public String homeCity;
    public String homeState;
    public ArrayList<Resumes> authorizedResumes;
    public ArrayList<String> testArray;

    public ArrayList<String> getTestArray() {
        return testArray;
    }

    public void setTestArray(ArrayList<String> testArray) {
        this.testArray = testArray;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getHomeCity() { return homeCity; }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getSalt() { return salt; }

    public void setSalt(String salt) { this.salt = salt; }

    public ArrayList<Resumes> getAuthorizedResumes() {
        return authorizedResumes;
    }

    public void setAuthorizedResumes(ArrayList<Resumes> authorizedResumes) {
        this.authorizedResumes = authorizedResumes;
    }

    public Users(String id){
        super();
        this.id = id;
        this.username = id;
    }

}