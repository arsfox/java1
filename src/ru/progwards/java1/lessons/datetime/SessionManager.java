package ru.progwards.java1.lessons.datetime;

import sun.invoke.empty.Empty;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Arseniy on 25.02.2020.
 */
public class SessionManager {

    private TreeMap<Integer, UserSession> sessionCollection;

    private int sessionValid;

    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
        sessionCollection = new TreeMap<>();
    }

    public void add(UserSession userSession) {
        sessionCollection.put(userSession.getSessionHandle(), userSession);
    }

    public UserSession find(String userName) {
        for(Map.Entry s : this.sessionCollection.entrySet()) {
            UserSession us = (UserSession) s.getValue();
            if(us.getUserName().equals(userName)) {

            }
        }
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

    public boolean isValid(int sessionValid) {
        return lastAccess.plusSeconds(sessionValid).isAfter(LocalDateTime.now());
    }
}
