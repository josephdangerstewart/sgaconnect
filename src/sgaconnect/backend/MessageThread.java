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
public class MessageThread {
    
    private int id;
    private String subject;
    private ArrayList<Integer> userIDs;
    private ArrayList<Message> messages;
    
    public MessageThread(JSONObject obj) {
        id = obj.getInt("id");
        subject = obj.getString("subject");
        
        JSONArray userIDs = obj.getJSONArray("userIDs");
        JSONArray messages = obj.getJSONArray("messages");
        
        this.userIDs = new ArrayList<Integer>();
        this.messages = new ArrayList<Message>();
        
        for (int i = 0; i < userIDs.length(); i++) {
            this.userIDs.add(userIDs.getInt(i));
        }
        
        for (int i = 0; i < messages.length(); i++) {
            this.messages.add(new Message(messages.getJSONObject(i)));
        }
    }
    
    public MessageThread(int id, int[] userIDs, String subject) {
        this.id = id;
        this.subject = subject;
        this.userIDs = new ArrayList<Integer>();
        
        for (int i = 0; i < userIDs.length; i++) {
            this.userIDs.add(userIDs[i]);
        }
        
        this.messages = new ArrayList<Message>();
    }
    
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        
        obj.put("id",id);
        obj.put("subject",subject);
        
        JSONArray userIDs = new JSONArray();
        JSONArray messages = new JSONArray();
        
        for (int i = 0; i < this.userIDs.size(); i++) {
            userIDs.put(this.userIDs.get(i));
        }
        
        for (int i = 0; i < this.messages.size(); i++) {
            messages.put(this.messages.get(i).toJSON());
        }
        
        obj.put("userIDs",userIDs);
        obj.put("messages",messages);
        
        return obj;
    }
    
    public ArrayList<Message> getMessages() {return messages;}
    public ArrayList<Integer> getUsers() {return userIDs;}
    public int getID() {return id;}
    public String getSubject() {return subject;}
    
    public boolean isUserOnThread(int user) {
        for (int i = 0; i < userIDs.size(); i++) {
            if (user == userIDs.get(i)) return true;
        }
        return false;
    }
    
    public void sendMessage(int userID, String body) {
        this.messages.add(new Message(userID, body));
    }
    
}
