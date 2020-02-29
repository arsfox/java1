package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by Arseniy on 25.02.2020.
 */
public class SessionManager {

    private TreeMap<Integer, UserSession> sessionHandleCollection;
    private TreeMap<String, UserSession> sessionUserNameCollection;
    private int sessionValid;

    public SessionManager(int sessionValid) {

    }

    public void add(UserSession userSession) {


    }

    public UserSession find(String userName) {
        return new UserSession("");
    }

    public UserSession get(int sessionHandle) {
        return null;
    }

    public void delete(int sessionHandle) {

    }

    public void deleteExpired() {

    }
}

class UserSession {
    private int sessionHandle;
    private String userName;
    private LocalDateTime lastAccess;

    public UserSession(String userName) {
        this.userName = userName;
        this.sessionHandle = new Random().nextInt();
        this.lastAccess = LocalDateTime.now();
    }

    public int getSessionHandle() {
        return this.sessionHandle;
    }

    public String getUserName(){
        return this.userName;
    }

    public LocalDateTime getLastAccess() {
        return this.lastAccess;
    }

    public void updateLastAccess() {
        this.lastAccess = LocalDateTime.now();
    }
}
