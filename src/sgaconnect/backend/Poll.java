/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect.backend;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author josephstewart
 */
public class Poll {
    
    private int id = -1;
    private boolean isLocked = false;
    private int creatorID = -1;
    private String question = "UNDEFINED";
    private ArrayList<String> options = new ArrayList<String>();
    private long createdOn = 0l;
    private ArrayList<PollResponse> responses = new ArrayList<PollResponse>();
    
    public Poll(JSONObject poll) {
        id = poll.getInt("id");
        creatorID = poll.getInt("creatorID");
        question = poll.getString("question");
        createdOn = poll.getLong("createdOn");
        isLocked = poll.getBoolean("isLocked");
        
        JSONArray options = poll.getJSONArray("options");
        this.options = new ArrayList<String>();
        for (int i = 0; i < options.length(); i++) {
            this.options.add(options.getString(i));
        }
        
        JSONArray responses = poll.getJSONArray("responses");
        this.responses = new ArrayList<PollResponse>();
        for (int i = 0; i < responses.length(); i++) {
            this.responses.add(new PollResponse(responses.getJSONObject(i)));
        }
    }
    
    public Poll(int id, int creatorID) {
        this.id = id;
        this.question = "";
        this.creatorID = creatorID;
        this.createdOn = System.currentTimeMillis();
        this.responses = new ArrayList<PollResponse>();
        this.options = new ArrayList<String>();
        this.isLocked = false;
    }
    
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        JSONArray responses = new JSONArray();
        JSONArray options = new JSONArray();
        
        obj.put("id", id);
        obj.put("creatorID", creatorID);
        obj.put("createdOn", createdOn);
        obj.put("question",question);
        obj.put("isLocked",isLocked);
        
        for (int i = 0; i < this.responses.size(); i++) {
            responses.put(this.responses.get(i).toJSON());
        }
        
        for (int i = 0; i < this.options.size(); i++) {
            options.put(this.options.get(i));
        }
        
        obj.put("responses",responses);
        obj.put("options",options);
        
        return obj;
    }
    
    public int getID() {return id;}
    public String getQuestion() {return question;}
    public long getCreatedOn() {return createdOn;}
    public int getCreatorId() {return creatorID;}
    public ArrayList<String> getOptions() {return options;}
    public ArrayList<PollResponse> getResponses() {return responses;}
    public boolean isLocked() {return isLocked;}
    
    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }
    
    public String getCreatedOnString() {
        return Util.getDateFromMili(createdOn);
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    
    public void addOption(String option) {
        this.options.add(option);
    }
    
    public void removeOption(int index) {
        this.options.remove(index);
    }
    
    public void removeAllOptions() {
        this.options.clear();
    }
    
    public boolean hasResponded(User user) {
        int signerID = user.getID();
        for (int i = 0; i < responses.size(); i++) {
            if (responses.get(i).getID() == id) return true;
        }
        return false;
    }
    
    public boolean respond(int signerID,String response) {
        if (!isLocked) {
            for (int i = 0; i < responses.size(); i++) {
                if (responses.get(i).getID() == signerID) return false;
            }

            this.responses.add(new PollResponse(signerID,response));
            return true;
        }
        return false;
    }
    
}
