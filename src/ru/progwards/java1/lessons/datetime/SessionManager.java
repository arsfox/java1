package ru.progwards.java1.lessons.datetime;

import java.util.Date;
import java.util.List;

/**
 * Created by Arseniy on 25.02.2020.
 */
public class SessionManager {

    private List<UserSession> sessions;
    private int sessionValid;

    public SessionManager(int sessionValid) {

    }

    public void add(UserSession userSession) {


    }

    public UserSession find(String userName) {
        return new UserSession("");
    }

    public UserSession get(int sessionHandle) {

    }

    public void delete(int sessionHandle) {

    }

    public void deleteExpired() {

    }
}

class UserSession {
    private int sessionHandle;
    private String userName;
    private Date lastAccess;

    public UserSession(String userName) {

    }

    public void updateLastAccess() {

    }


}
