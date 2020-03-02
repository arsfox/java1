package ru.progwards.java1.lessons.datetime;

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
                us.updateLastAccess();
                return us;
            }
        }
        return null;
    }

    public UserSession get(int sessionHandle) {
        UserSession us = this.sessionCollection.get(sessionHandle);
        if(us != null){
            if (us.isValid(sessionValid)) {
                us.updateLastAccess();
                return us;
            }
        }
        return null;
    }

    public void delete(int sessionHandle) {
        this.sessionCollection.remove(sessionHandle);
    }

    public void deleteExpired() {
        Iterator<Map.Entry<Integer, UserSession>> usb = this.sessionCollection.entrySet().iterator();
        while (usb.hasNext()) {
            UserSession us = usb.next().getValue();
            if (!us.isValid(sessionValid)) {
                usb.remove();
            }
        }
//        for(Map.Entry s : this.sessionCollection.entrySet()) {
//            UserSession us = (UserSession) s.getValue();
//            if (!us.isValid(sessionValid)) {
//                this.sessionCollection.remove(us.getSessionHandle());
//            }
//        }
    }

    public static void main(String[] args) {
        SessionManager mgr = new SessionManager(3);
        UserSession u1 = new UserSession("user");
        if (mgr.find("user") == null) mgr.add(u1);
//        System.out.println(mgr.get(u1.getSessionHandle()));
//        System.out.println(mgr.get(u1.getSessionHandle()));
//        System.out.println(mgr.get(u1.getSessionHandle()));
        System.out.println(mgr.get(u1.getSessionHandle()));
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

    @Override
    public String toString() {
        return userName + " " + sessionHandle + " " + lastAccess;
    }
}
