package com.metacube.angularwebapi.model;

public class Comment {
    
    private int postId;
    private int id;
    private int userId;
    private String username;
    private String body;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

   public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    @Override
    public String toString() {
        return "'" + getId() + "','" + getPostId() + "','" + getUserId()+ "','" + getUsername() + "','" + getBody() + "'";
    }
    
}
