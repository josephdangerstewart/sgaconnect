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
public class Message {
    
    private int from;
    private String body;
    private long timestamp;
    
    public Message(JSONObject obj) {
        from = obj.getInt("from");
        body = obj.getString("body");
        timestamp = obj.getLong("timestamp");
    }
    
    public Message(int from, String body) {
        this.from = from;
        this.body = body;
        this.timestamp = System.currentTimeMillis();
    }
    
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        
        obj.put("from", from);
        obj.put("body", body);
        obj.put("timestamp",timestamp);
        
        return obj;
    }
    
    public int getFrom() {return from;}
    public String getBody() {return body;}
    public long getTimestamp() {return timestamp;}
    public String getTimestampString() {return Util.getDateFromMili(timestamp);}
    
}
