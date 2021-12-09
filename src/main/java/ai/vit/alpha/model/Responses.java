package ai.vit.alpha.model;

import java.util.ArrayList;

public class Responses {
    String id;
    String object;
    String created;
    String model;
    ArrayList<Choices> choices;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getChoice(){
        if(choices == null || choices.isEmpty()) return " ";
        return choices.get(0).getText();
    }


}
