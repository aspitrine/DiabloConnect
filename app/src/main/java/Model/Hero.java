package Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by quentinlogie on 15/04/14.
 */
public class Hero implements Serializable {
    private int id, gender, lastUpdated;
    private String name, paragonLevel, level;
    @SerializedName("class")
    private String type;
    private boolean hardcore, dead;

    public Hero(){
        paragonLevel = "0";
        level = "1";
        gender = 0;
        name = "name";
        hardcore = false;
        dead = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParagonLevel() {
        return paragonLevel;
    }

    public void setParagonLevel(String paragonLevel) {
        this.paragonLevel = paragonLevel;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(int lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHardcore() {
        return hardcore;
    }

    public void setHardcore(boolean hardcore) {
        this.hardcore = hardcore;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
