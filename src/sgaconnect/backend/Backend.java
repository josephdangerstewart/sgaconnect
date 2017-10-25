package sgaconnect.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.filechooser.FileSystemView;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Use this class as the backend for SGA Connect.
 * If this software were being developed for production,
 this class would be fetching information from a database.
 But this stores data in a plaintext file. This class can
 do basically everything the user can do, create and petitions,
 polls, bulletin posts, and message threads, get users by
 role and by dorm, and get a list of all polls and petitions.
 
 For new items, create an object of their type and then use the
 save() method to add them to the backend file.
 * 
 * @author josephstewart
 */
public class Backend {
    
    private static final int STUDENT_COUNT = 100;
    private static final int SENATOR_COUNT = 10;
    private static final int PRESIDENT_COUNT = 1;
    
    private ArrayList<User> users;
    private ArrayList<Poll> polls;
    private ArrayList<Petition> petitions;
    private ArrayList<MessageThread> messageThreads;
    private ArrayList<BulletinPost> bulletin;
    
    private static final String DORMS[] = {
        "Hart",
        "Stewart",
        "Off Campus",
        "Hope",
        "Horton",
        "Bluff",
        "Alpha",
        "Sigma",
        "Blackstone"
    };
    
    private static final String ROLES[] = {
        "Student",
        "Senator",
        "President"
    };
    
    private static final String YEARS[] = {
        "Freshman",
        "Sophmore",
        "Junior",
        "Senior",
    };
    
    private final String dirname = "sgaconnect";
    private final String filename = "backend.txt";
    private File backendFile;
    private JSONObject backend;
    
    /**
     * Creates a new preferences object to act
     * as the 'backend' of SGA Connect
     * @throws IOException 
     */
    public Backend() throws IOException {
        
        //locate backend file on users System
        File directory = new File(FileSystemView.getFileSystemView().getHomeDirectory(),dirname);
        
        if (!directory.exists()) {
            directory.mkdirs();
        }
        
        backendFile = new File(directory,filename);
        
        if (backendFile.isFile()) {
            BufferedReader reader = new BufferedReader(new FileReader(backendFile));
            String fileContents = "";
            String line;
            while((line=reader.readLine())!= null) {
                fileContents = fileContents + " " + line;
            }
            reader.close();
            backend = new JSONObject(fileContents);
        } else {
            backend = createNewBackend();
            PrintWriter writer = new PrintWriter(backendFile);
            writer.print(backend.toString());
            writer.close();
        }
        
        JSONArray users = backend.getJSONArray("users");
        JSONArray polls = backend.getJSONArray("polls");
        JSONArray petitions = backend.getJSONArray("petitions");
        JSONArray messageThreads = backend.getJSONArray("messageThreads");
        JSONArray bulletin = backend.getJSONArray("bulletin");
        
        this.users = new ArrayList<User>();
        this.polls = new ArrayList<Poll>();
        this.petitions = new ArrayList<Petition>();
        this.messageThreads = new ArrayList<MessageThread>();
        this.bulletin = new ArrayList<BulletinPost>();
        
        for (int i = 0; i < users.length(); i++) {
            this.users.add(new User(users.getJSONObject(i)));
        }
        
        for (int i = 0; i < polls.length(); i++) {
            this.polls.add(new Poll(polls.getJSONObject(i)));
        }
        
        for (int i = 0; i < petitions.length(); i++) {
            this.petitions.add(new Petition(petitions.getJSONObject(i)));
        }
        
        for (int i = 0; i < messageThreads.length(); i++) {
            this.messageThreads.add(new MessageThread(messageThreads.getJSONObject(i)));
        }
        
        for (int i = 0; i < bulletin.length(); i++) {
            this.bulletin.add(new BulletinPost(bulletin.getJSONObject(i)));
        }
        
    }
    
    private JSONObject createNewBackend() {
        
        /*
            BACKEND SCHEMA
            ============
        
            {
                users: [
                    {
                        id:1,
                        name:"John Doe",
                        role:0,
                        email:"john.d@biola.edu",
                        room:"203",
                        dorm:"Horton",
                        year:0,
                        major:"Computer Science",
                        netID:"johnd12",
                        password:"password"
                    }
                ],
                
                polls: [
                    {
                        id:1092,
                        isLocked:false,
                        creatorID:1,
                        createdOn: <long data type>
                        question:"Do you like polls?",
                        options: [
                            "yes",
                            "no",
                        ],
                        responses: [
                            {
                                userID:45,
                                response:"yes"
                            }
                        ]
                    }
                ],
                
                petitions: [
                    {
                        id:902,
                        creatorID:90,
                        createdOn: <long data type>
                        title:"No more tofu!",
                        scope: "ALL CAMPUS",
                        body:"We the people of Biola University hereby do formally request that all tofu be taken out...",
                        signerIDs: [
                            45,
                            23,
                            56,
                            12
                        ],
                        comments: [
                            {
                                userID:65,
                                comment:"I like this idea very much",
                                timestamp:0l,
                            }
                        ]
                    }
                ],
                
                messageThreads: [
                    {
                        id:2203,
                        userIDs: [
                          5,
                          23
                        ],
                        subject:"Hey bud",
                        messages: [
                            {
                                from:5,
                                body:"Hey! How's it going!",
                                timestamp:0l
                            }
                        ]
                    }
                ]
        
                bulletin: [
                    {
                        userID:0,
                        body:"here is a bulletin post",
                        timestamp: <long data type>
                    }
                ]
        
                events: [
                    {
                        timestamp: <long data type>,
                        type: "poll response",
                        body: "So and so just responded to a poll!"
                    }
                ]
            }
        */
        
        
        
        JSONObject mainBackend = new JSONObject();
        JSONArray users = new JSONArray();
        JSONArray polls = new JSONArray();
        JSONArray petitions = new JSONArray();
        JSONArray messageThreads = new JSONArray();
        JSONArray bulletin = new JSONArray();
        
        for (int i = 0; i < STUDENT_COUNT; i++) {
            User user = new User(i,0);
            users.put(user.toJSON());
        }
        
        for (int i = STUDENT_COUNT; i < SENATOR_COUNT+STUDENT_COUNT; i++) {
            User user = new User(i,1);
            users.put(user.toJSON());
        }
        
        for (int i = STUDENT_COUNT + SENATOR_COUNT; i < SENATOR_COUNT+STUDENT_COUNT+PRESIDENT_COUNT; i++) {
            User user = new User(i,2);
            users.put(user.toJSON());
        }
        
        Poll poll = new Poll(0,STUDENT_COUNT);
        poll.setQuestion("What is your favorite color?");
        poll.addOption("red");
        poll.addOption("blue");
        poll.addOption("green");
        poll.respond(1, "red");
        poll.respond(2, "blue");
        poll.respond(1, "green");
        polls.put(poll.toJSON());
        
        Petition petition = new Petition(0,0);
        petition.setTitle("No more tofu!!");
        petition.setBody("We the people of Biola university hereby demand that they take tofu out of all eatieries on campus. This includes but is not limited to the caf, eagles, the talon, commons, and blackstone cafe");
        petition.comment(103, "It is done!");
        petition.sign(5);
        petition.sign(23);
        petition.sign(23);
        petition.sign(10);
        petitions.put(petition.toJSON());
        
        MessageThread thread = new MessageThread(0,new int[]{23,108},"Applying for SGA");
        thread.sendMessage(23, "Hi! How do you go about applying for SGA");
        thread.sendMessage(108, "Well that's simple! Just go to www.sga.com/apply");
        messageThreads.put(thread.toJSON());
        
        BulletinPost post = new BulletinPost(115,"There is something going on tonight!");
        BulletinPost post2 = new BulletinPost(113,"There is another important thing tonight!");
        bulletin.put(post.toJSON());
        bulletin.put(post2.toJSON());
        
        mainBackend.put("users", users);
        mainBackend.put("polls", polls);
        mainBackend.put("petitions",petitions);
        mainBackend.put("messageThreads",messageThreads);
        mainBackend.put("bulletin", bulletin);
        
        return mainBackend;
    }
    
    private void writeToFile() {
        try {
            PrintWriter writer = new PrintWriter(backendFile);
            writer.println(backend.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @return an array of all senator users
     */
    public User[] getSenators() {
        ArrayList<User> senators = new ArrayList<User>();
        
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRole() == 1) {
                senators.add(users.get(i));
            }
        }
        
        return senators.toArray(new User[0]);
    }
    
    /**
     * @return an array of all student users
     */
    public User[] getStudents() {
        ArrayList<User> students = new ArrayList<User>();
        
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRole() == 0) {
                students.add(users.get(i));
            }
        }
        
        return students.toArray(new User[0]);
    }
    
    /**
     * Use this function to log in a user into the system 
     * Hypothetically, this function would pull
     * from the Biola student database and return a user that
     * way but this function just returns a user based on a
     * locally stored list of users. Returns
     * @param netID users Biola netID
     * @param password user netID password
     * @return a user object describing logged in user if user exists, null otherwise
     */
    public User logIn(String netID, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getNetID().equals(netID) && users.get(i).getPassword().equals(password)) {
                return users.get(i);
            }
        }
        return null;
    }
    
    /**
     * @param dorm the dorm of the senator to look up
     * @return an array of all senator users in a particular dorm
     */
    public User[] getSenatorsOf(String dorm) {
        ArrayList<User> senators = new ArrayList<User>();
        
        System.out.println("Getting senators of " + dorm);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getDorm().equals(dorm) && users.get(i).getRole() == 1) {
                System.out.println("Found senator!");
                senators.add(users.get(i));
            }
        }
        
        return senators.toArray(new User[0]);
    }
    
    /**
     * @param dorm the dorm to look up
     * @return an array of student users that are associated with a particular dorm
     */
    public User[] getStudentsOf(String dorm) {
        ArrayList<User> students = new ArrayList<User>();
        
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getDorm().equals(dorm) && users.get(i).getRole() == 0) {
                students.add(users.get(i));
            }
        }
        
        return students.toArray(new User[0]);
    }
    
    /**
     * @return an array of all users with president status
     */
    public User[] getPresidents() {
        ArrayList<User> presidents = new ArrayList<User>();
        
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRole() == 0) {
                presidents.add(users.get(i));
            }
        }
        
        return presidents.toArray(new User[0]);
    }
    
    /**
     * @return all users in system
     */
    public User[] getAllUsers() {
        User[] allUsers = new User[users.size()];
        
        for (int i = 0; i < users.size(); i++) {
            allUsers[i] = users.get(i);
        }
        
        return allUsers;
    }
    
    /**
     * @param id
     * @return user object corresponding to the given id
     */
    public User getUserByID(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID() == id) {
                return users.get(i);
            }
        }
        return User.getNullUser();
    }
    
    /**
     * @param id
     * @return petition object corresponding to the given id
     */
    public Petition getPetitionByID(int id) {
        for (int i = 0; i < petitions.size(); i++) {
            if (petitions.get(i).getID() == id) {
                return petitions.get(i);
            }
        }
        return null;
    }
    
    /**
     * @param id
     * @return poll object corresponding to the given id
     */
    public Poll getPollByID(int id) {
        for (int i = 0; i < polls.size(); i++) {
            if (polls.get(i).getID() == id) {
                return polls.get(i);
            }
        }
        return null;
    }
    
    /**
     * @param id
     * @return message thread object corresponding to the given id
     */
    public MessageThread getMessageThreadByID(int id) {
        for (int i = 0; i < messageThreads.size(); i++) {
            if (messageThreads.get(i).getID() == id) {
                return messageThreads.get(i);
            }
        }
        return null;
    }
    
    /**
     * This fetches an array of message threads that contain
     * a given user
     * @param userId user to check for
     * @return all message threads that involve user
     */
    public MessageThread[] getAllMessageThreads(int userId) {
        ArrayList<MessageThread> threads = new ArrayList<MessageThread>();
        
        for (int i = 0; i < messageThreads.size(); i++) {
            if (messageThreads.get(i).isUserOnThread(userId)) {
                threads.add(messageThreads.get(i));
            }
        }
        
        return threads.toArray(new MessageThread[0]);
    }
    
    /**
     * This compiles a description of all of the polls
     * and returns them in JSON format with the following
     * fields
     *  "id" (int)
     *  "question" (String)
     *  "creator" (String)
     * @return a description of all the polls
     */
    public JSONObject[] getAllPolls() {
        JSONObject[] objects = new JSONObject[polls.size()];
        
        for (int i = 0; i< polls.size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("question",polls.get(i).getQuestion());
            obj.put("creator",getUserByID(polls.get(i).getCreatorId()).getName());
            obj.put("id", polls.get(i).getID());
            objects[i] = obj;
        }
        
        return objects;
    }
    
    /**
     * Returns a JSONObject that is a lightweight 
     * visual representation of all the petitions.
     * It has the following fields:
     *  "title" (String)
     *  "creator" (String)
     *  "signerCount" (int)
     *  "id" (int)
     * @return a description of all the petitions
     */
    public JSONObject[] getAllPetitions() {
        
        JSONObject[] objects = new JSONObject[petitions.size()];
        
        for (int i = 0; i < petitions.size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("title",petitions.get(i).getTitle());
            obj.put("creator",getUserByID(petitions.get(i).getCreatorID()).getName());
            obj.put("signerCount", petitions.get(i).getSignerCount());
            obj.put("id", petitions.get(i).getID());
            objects[i] = obj;
        }
        
        return objects;
    }
    
    /**
     * @return the next available petition id for a new petition
     */
    public int getNextPetitionId() {
        int maxId = Integer.MIN_VALUE;
        
        for (int i = 0; i < petitions.size(); i++) {
            if (petitions.get(i).getID() > maxId) {
                maxId = petitions.get(i).getID();
            }
        }
        
        return maxId+1;
    }
    
    /**
     * @return the next available poll id for a new poll
     */
    public int getNextPollId() {
        int maxId = Integer.MAX_VALUE;
        
        for (int i = 0; i < polls.size(); i++) {
            if (polls.get(i).getID() > maxId) {
                maxId = petitions.get(i).getID();
            }
        }
        
        return maxId + 1;
    }
    
    public BulletinPost[] getBulletinPosts() {
        return bulletin.toArray(new BulletinPost[0]);
    }
    
    /**
     * Saves a user object to the text file
     * @param user user to be saved
     */
    public void save(User user) {
        boolean newUser = true;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getID() == user.getID()) {
                users.set(i,user);
                newUser = false;
            }
        }
        
        if (newUser)
            users.add(user);
        
        JSONArray users = new JSONArray();
        
        for (int i = 0; i < this.users.size(); i++) {
            users.put(this.users.get(i).toJSON());
        }
        
        backend.put("users", users);
        
        writeToFile();
    }
    
    /**
     * Saves a poll object to the text file
     * @param poll poll to be saved
     */
    public void save(Poll poll) {
        boolean newPoll = true;
        for (int i = 0; i < polls.size(); i++) {
            if (polls.get(i).getID() == poll.getID()) {
                polls.set(i, poll);
                newPoll = false;
            }
        }
        
        if (newPoll)
            polls.add(poll);
        
        JSONArray polls = new JSONArray();
        
        for (int i = 0; i < this.polls.size(); i++) {
            polls.put(this.polls.get(i).toJSON());
        }
        
        backend.put("polls", polls);
        
        writeToFile();
    }
    
    /**
     * Saves a petition object to the text file
     * @param petition petition object to be saved
     */
    public void save(Petition petition) {
        boolean newPetition = true;
        for (int i = 0; i < petitions.size(); i++) {
            if (petitions.get(i).getID() == petition.getID()) {
                petitions.set(i, petition);
                newPetition = false;
            }
        }
        
        if (newPetition)
            petitions.add(petition);
        
        JSONArray petitions = new JSONArray();
        
        for (int i = 0; i < this.petitions.size(); i++) {
            petitions.put(this.petitions.get(i).toJSON());
        }
        
        backend.put("petitions", petitions);
        
        writeToFile();
    }
    
    /**
     * Saves a message thread object to the text file
     * @param messageThread the message thread to be saved
     */
    public void save(MessageThread messageThread) {
        boolean newThread = true;
        for (int i = 0; i < messageThreads.size(); i++) {
            if (messageThreads.get(i).getID() == messageThread.getID()) {
                messageThreads.set(i, messageThread);
                newThread = false;
            }
        }
        
        if (newThread)
            messageThreads.add(messageThread);
        
        JSONArray messageThreads = new JSONArray();
        
        for (int i = 0; i < this.messageThreads.size(); i++) {
            messageThreads.put(this.messageThreads.get(i).toJSON());
        }
        
        backend.put("messageThreads", messageThreads);
        
        writeToFile();
    }
    
    public static String[] getDorms() {
        return DORMS;
    }
    
    public static String[] getRoles() {
        return ROLES;
    }
    
    public static String[] getYears() {
        return YEARS;
    }
    
}
