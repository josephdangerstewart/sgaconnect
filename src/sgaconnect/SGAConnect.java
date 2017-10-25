/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import sgaconnect.backend.*;

/**
 *
 * @author josephstewart
 */
public class SGAConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Backend backend;
        try {
            backend = new Backend();
            
            //gets all users with the role of senator
            User[] allSenators = backend.getSenators();
            
            //gets all senators of the dorm 'Hart'
            User[] hartSenators = backend.getSenatorsOf("Signma");
            
            //gets all users in the bluff
            User[] bluffStudents = backend.getStudentsOf("Bluff");
            
            //logs in student with net id of user23
            User loggedInUser = backend.logIn("user23","password");
            
            System.out.println("ALL SENATORS");
            for (int i = 0; i < allSenators.length; i++) {
                System.out.println(allSenators[i]);
            }
            System.out.println();
            
            System.out.println("ALL SENATORS OF HART");
            for (int i = 0; i < hartSenators.length; i++) {
                System.out.println(hartSenators[i]);
            }
            System.out.println();
            
            System.out.println("STUDENTS IN BLUFF");
            for (int i = 0; i < bluffStudents.length; i++) {
                System.out.println(bluffStudents[i]);
            }
            System.out.println();
            
            System.out.println("LOGGED IN USER");
            System.out.println(loggedInUser);
            System.out.println();
            
            //get a description of all petitions
            JSONObject[] allPetitions = backend.getAllPetitions();
            
            System.out.println("ALL PETITIONS");
            for (int i = 0; i < allPetitions.length; i++) {
                System.out.println("Petition " + allPetitions[i].getInt("id") + 
                        " - " + allPetitions[i].getString("title") + " by " + 
                        allPetitions[i].getString("creator") + " (" + 
                        allPetitions[i].getInt("signerCount") + " signers)");
            }
            System.out.println();
            
            //get a description of all polls
            JSONObject[] allPolls = backend.getAllPolls();
            
            for (int i = 0; i < allPolls.length; i++) {
                System.out.println("Poll " + allPolls[i].getInt("id") + " - " + 
                        allPolls[i].getString("question") + " by " + 
                        allPetitions[i].getString("creator"));
            }
            
            //create a petition object with the next available id
            Petition petition = new Petition(backend.getNextPetitionId(),2);
            petition.setTitle("Stop spending money!");
            petition.setBody("Please stop spending all money!");
            petition.comment(102, "We cannot stop spending money");
            petition.setScope("ALL CAMPUS");
            petition.sign(24);
            petition.sign(24);
            
            //create a poll object with the next available id
            Poll poll = new Poll(backend.getNextPollId(),106);
            poll.setQuestion("What is your favorite color?");
            poll.addOption("Red");
            poll.addOption("Blue");
            poll.respond(6, "Red");
            
            //save poll and petition to text file
            backend.save(petition);
            backend.save(poll);
            
            //get all bulletin posts
            BulletinPost[] bulletin = backend.getBulletinPosts();
            
            System.out.println("All bulletin posts");
            for (int i = 0; i < bulletin.length; i++) {
                System.out.println(bulletin[i]);
            }
            System.out.println();
            
            //get all message threads involving user 23
            MessageThread[] threads = backend.getAllMessageThreads(23);
            
            System.out.println("Message Threads");
            for (int i = 0; i < threads.length; i++) {
                System.out.println("Message " + threads[i].getID() + " - " + threads[i].getSubject());
            }
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
