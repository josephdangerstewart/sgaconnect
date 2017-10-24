/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect.backend;

import java.util.Random;
import org.json.JSONObject;

/**
 *
 * @author josephstewart
 */
public class User {
    
    private static final String[] MAJORS = {
        "Computer Science",
        "Nursing",
        "Art",
        "Business",
        "Biology",
        "Engineering",
        "Film"
    };
    
    private int id = -1;
    private String name = "UNDEFINED";
    private int role = 0;
    private String email = "UNDEFINED";
    private String room = "UNDEFINED";
    private String dorm = "UNDEFINED";
    private int year = 0;
    private String major = "UNDEFINED";
    private String netID = "UNDEFINED";
    private String password = "UNDEFINED";
    
    public User(JSONObject userObj) {
        
        try {
            
            id = userObj.getInt("id");
            name = userObj.getString("name");
            role = userObj.getInt("role");
            email = userObj.getString("email");
            room = userObj.getString("room");
            dorm = userObj.getString("dorm");
            year = userObj.getInt("year");
            major = userObj.getString("major");
            netID = userObj.getString("netID");
            password = userObj.getString("password");
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
    
    public User(int id, int role) {
        Random rn = new Random();
        
        String dorms[] = Prefs.getDorms();
        
        this.id = id;
        name = "User " + id;
        this.role = role;
        this.email = "user." + id + "@biola.edu";
        this.room = "101";
        this.dorm = dorms[rn.nextInt(dorms.length)];
        this.year = rn.nextInt(4);
        this.major = MAJORS[rn.nextInt(MAJORS.length)];
        this.netID = "user"+id;
        this.password = "password";
    }
    
    public User(int id, String name, int role, String dorm, int year, String major) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.email = name.replaceAll("\\s+","") + "@biola.edu";
        this.room = "101";
        this.dorm = dorm;
        this.year = year;
        this.major = major;
        this.netID = name.split("\\s+")[0] + id;
        this.password = "password";
    }
    
    private User() {
        
    }
    
    public static User getNullUser() {
        return new User();
    }
    
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        
        obj.put("id",id);
        obj.put("name",name);
        obj.put("role", role);
        obj.put("room", room);
        obj.put("email",email);
        obj.put("dorm",dorm);
        obj.put("year",year);
        obj.put("major",major);
        obj.put("netID",netID);
        obj.put("password",password);
        
        return obj;
    }
    
    public int getID() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getRoom() {return room;}
    public String getDorm() {return dorm;}
    public int getYear() {return year;}
    public String getYearString() {return Prefs.getYears()[year];}
    public String getMajor() {return major;}
    public String getNetID() {return netID;}
    public String getPassword() {return password;}
    public String getEmail() {return email;}
    public int getRole() {return role;}
    public String getRoleString() {return Prefs.getRoles()[role];}
    
    public void setRole(int role) {
        
        if (role >= 0 && role <= 2) {
            this.role = role;
        }
        
    }
    
    public String toString() {
        return name + " - " + Prefs.getYears()[year] + " " + major + " major (" + dorm + ")";
    }
    
}
