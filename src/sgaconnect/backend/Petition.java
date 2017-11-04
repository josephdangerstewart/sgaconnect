/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect.backend;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author josephstewart
 */
public class Petition {
    
    private int id;
    private int creatorID;
    private long createdOn;
    private String title;
    private String body;
    private String scope;
    private ArrayList<Integer> signerIDs;
    private ArrayList<PetitionComment> comments;
    
    public Petition(JSONObject obj) {
        this.id = obj.getInt("id");
        this.creatorID = obj.getInt("creatorID");
        this.createdOn = obj.getLong("createdOn");
        this.title = obj.getString("title");
        this.body = obj.getString("body");
        this.scope = obj.getString("scope");
        
        JSONArray signerIDs = obj.getJSONArray("signerIDs");
        JSONArray comments = obj.getJSONArray("comments");
        
        this.signerIDs = new ArrayList<Integer>();
        this.comments = new ArrayList<PetitionComment>();
        
        for (int i = 0; i < signerIDs.length(); i++) {
            this.signerIDs.add(signerIDs.getInt(i));
        }
        
        for (int i = 0; i < comments.length(); i++) {
            this.comments.add(new PetitionComment(comments.getJSONObject(i)));
        }
    }
    
    public Petition(int id, int creatorID) {
        this.id = id;
        this.creatorID = creatorID;
        this.title = "";
        this.createdOn = System.currentTimeMillis();
        this.body = "";
        this.scope = "ALL CAMPUS";
        this.signerIDs = new ArrayList<Integer>();
        this.comments = new ArrayList<PetitionComment>();
    }
    
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        JSONArray signerIDs = new JSONArray();
        JSONArray comments = new JSONArray();
        
        obj.put("id", id);
        obj.put("creatorID",creatorID);
        obj.put("title", title);
        obj.put("createdOn", createdOn);
        obj.put("body", body);
        obj.put("scope",scope);
        
        for (int i = 0; i < this.signerIDs.size(); i++) {
            signerIDs.put(this.signerIDs.get(i));
        }
        
        for (int i = 0; i <this.comments.size(); i++) {
            comments.put(this.comments.get(i).toJSON());
        }
        
        obj.put("signerIDs",signerIDs);
        obj.put("comments",comments);
        
        return obj;
    }
    
    public int getID() {return id;}
    public int getCreatorID() {return creatorID;}
    public String getTitle() {return title;}
    public long getCreatedOn() {return createdOn;}
    public String getBody() {return body;}
    public String getScope() {return scope;}
    public ArrayList<Integer> getSignerIDs() {return signerIDs;}
    public ArrayList<PetitionComment> getComments() {return comments;}
    public String getCreatedOnString() {return Util.getDateFromMili(createdOn);}
    
    public void setTitle(String title) {this.title = title;}
    public void setBody(String body) {this.body = body;}
    public void setScope(String scope) {this.scope = scope;}
    
    public void sign(User user) {
        if (user.getRole() == 0)
        {
            int userID = user.getID();
            for (int i = 0; i < signerIDs.size(); i++) {
                if (userID == signerIDs.get(i)) return;
            }
            signerIDs.add(userID);
        }
    }
    
    public void sign(int userID) {
        for (int i = 0; i < signerIDs.size(); i++) {
            if (userID == signerIDs.get(i)) return;
        }
        signerIDs.add(userID);
    }
    
    public void comment(int userID, String comment) {
        for (int i = 0; i < comments.size(); i++) {
            if (userID == comments.get(i).getUserID()) return;
        }
        comments.add(new PetitionComment(id,comment));
    }
    
    
    
    public int getSignerCount() {
        return signerIDs.size();
    }
    
}
