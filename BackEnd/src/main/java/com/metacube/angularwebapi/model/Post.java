package com.metacube.angularwebapi.model;


public class Post {
    private int id;
    private int userId;
    private String userName;
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "'" + getId() + "','" + getUserId() + "','" + getUserName() + "','" + getBody() + "'";
    }
}
