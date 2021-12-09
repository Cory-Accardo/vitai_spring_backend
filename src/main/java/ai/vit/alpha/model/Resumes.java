package ai.vit.alpha.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("Resumes")
public class Resumes {
    @Id
    private String id;
    private String email;
    private String address;
    private String phone;
    private String website;
    private String expComp1;
    private String expRole1;
    private String expDesc1;
    private String expComp2;
    private String expRole2;
    private String expDesc2;
    private String projTitle1;
    private String projAssoc1;
    private String projDesc1;
    private String projTitle2;
    private String projAssoc2;
    private String projDesc2;
    private String projTitle3;
    private String projAssoc3;
    private String expComp3;
    private String expRole3;
    private String expDesc3;
    private String skills1;
    private String skills2;
    private String skills3;
    private String education1;
    private String education2;
    private String education3;
    private String executiveSummary;


    public String getProjTitle1() {
        return projTitle1;
    }

    public void setProjTitle1(String projTitle1) {
        this.projTitle1 = projTitle1;
    }

    public String getProjAssoc1() {
        return projAssoc1;
    }

    public void setProjAssoc1(String projAssoc1) {
        this.projAssoc1 = projAssoc1;
    }

    public String getProjDesc1() {
        return projDesc1;
    }

    public void setProjDesc1(String projDesc1) {
        this.projDesc1 = projDesc1;
    }

    public String getProjTitle2() {
        return projTitle2;
    }

    public void setProjTitle2(String projTitle2) {
        this.projTitle2 = projTitle2;
    }

    public String getProjAssoc2() {
        return projAssoc2;
    }

    public void setProjAssoc2(String projAssoc2) {
        this.projAssoc2 = projAssoc2;
    }

    public String getProjDesc2() {
        return projDesc2;
    }

    public void setProjDesc2(String projDesc2) {
        this.projDesc2 = projDesc2;
    }

    public String getProjTitle3() {
        return projTitle3;
    }

    public void setProjTitle3(String projTitle3) {
        this.projTitle3 = projTitle3;
    }

    public String getProjAssoc3() {
        return projAssoc3;
    }

    public void setProjAssoc3(String projAssoc3) {
        this.projAssoc3 = projAssoc3;
    }

    public String getProjDesc3() {
        return projDesc3;
    }

    public void setProjDesc3(String projDesc3) {
        this.projDesc3 = projDesc3;
    }

    private String projDesc3;


    public String getExpComp1() {
        return expComp1;
    }

    public void setExpComp1(String expComp1) {
        this.expComp1 = expComp1;
    }

    public String getExpRole1() {
        return expRole1;
    }

    public void setExpRole1(String expRole1) {
        this.expRole1 = expRole1;
    }

    public String getExpDesc1() {
        return expDesc1;
    }

    public void setExpDesc1(String expDesc1) {
        this.expDesc1 = expDesc1;
    }

    public String getExpComp2() {
        return expComp2;
    }

    public void setExpComp2(String expComp2) {
        this.expComp2 = expComp2;
    }

    public String getExpRole2() {
        return expRole2;
    }

    public void setExpRole2(String expRole2) {
        this.expRole2 = expRole2;
    }

    public String getExpDesc2() {
        return expDesc2;
    }

    public void setExpDesc2(String expDesc2) {
        this.expDesc2 = expDesc2;
    }

    public String getExpComp3() {
        return expComp3;
    }

    public void setExpComp3(String expComp3) {
        this.expComp3 = expComp3;
    }

    public String getExpRole3() {
        return expRole3;
    }

    public void setExpRole3(String expRole3) {
        this.expRole3 = expRole3;
    }

    public String getExpDesc3() {
        return expDesc3;
    }

    public void setExpDesc3(String expDesc3) {
        this.expDesc3 = expDesc3;
    }





    public String getSkills1() {
        return skills1;
    }

    public void setSkills1(String skills1) {
        this.skills1 = skills1;
    }

    public String getSkills2() {
        return skills2;
    }

    public void setSkills2(String skills2) {
        this.skills2 = skills2;
    }

    public String getSkills3() {
        return skills3;
    }

    public void setSkills3(String skills3) {
        this.skills3 = skills3;
    }

    public String getEducation1() {
        return education1;
    }

    public void setEducation1(String education1) {
        this.education1 = education1;
    }

    public String getEducation2() {
        return education2;
    }

    public void setEducation2(String education2) {
        this.education2 = education2;
    }

    public String getEducation3() {
        return education3;
    }

    public void setEducation3(String education3) {
        this.education3 = education3;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getExecutiveSummary() {
        return executiveSummary;
    }

    public void setExecutiveSummary(String executiveSummary) {
        this.executiveSummary = executiveSummary;
    }


    public Resumes(String email) {
        super();
        this.id = email;
        this.email = email;
    }
}
