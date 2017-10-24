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
public class PollResponse {
    private int id = -1;
    private String response = "UNDEFINED";
    
    public PollResponse(int id, String response) {
        this.id = id;
        this.response = response;
    }
    
    public PollResponse(JSONObject response) {
        try {
            this.response = response.getString("response");
            this.id = response.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        
        obj.put("id", id);
        obj.put("response", response);
        
        return obj;
    }
    
    public int getID() {
        return id;
    }
    
    public String getResponse() {
        return response;
    }
}
