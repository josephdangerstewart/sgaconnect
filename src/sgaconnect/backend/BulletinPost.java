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
public class BulletinPost {
    
    private int userID;
    private String body;
    private long timestamp;
    
    public BulletinPost(JSONObject obj) {
        this.userID = obj.getInt("userID");
        this.body = obj.getString("body");
        this.timestamp = obj.getLong("timestamp");
    }
    
    public BulletinPost(int userID, String body) {
        this.userID = userID;
        this.body = body;
        this.timestamp = System.currentTimeMillis();
    }
    
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        
        obj.put("userID", userID);
        obj.put("body",body);
        obj.put("timestamp", timestamp);
        
        return obj;
    }
    
    public int getUserID() {return userID;}
    public String getBody() {return body;}
    public long getTimestamp() {return timestamp;}
    public String getTimestampString() {return Util.getDateFromMili(timestamp);}
    
}
