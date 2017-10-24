/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect.backend;

import org.json.JSONObject;

/**
 *
 * @author josephstewart
 */
public class PetitionComment {
    
    private int userID = -1;
    private String comment = "";
    private long timestamp = 0l;
    
    public PetitionComment(JSONObject obj) {
        this.userID = obj.getInt("userID");
        this.comment = obj.getString("comment");
        this.timestamp = obj.getLong("timestamp");
    }
    
    public PetitionComment(int userID, String comment) {
        this.userID = userID;
        this.comment = comment;
        this.timestamp = System.currentTimeMillis();
    }
    
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("userID", userID);
        obj.put("comment", comment);
        obj.put("timestamp", timestamp);
        
        return obj;
    }
    
    public int getUserID() {return userID;}
    public String getComment() {return comment;}
    public long getTimestamp() {return timestamp;}
    public String getTimestampString() {return Util.getDateFromMili(timestamp);}
    
}
