package com.bathroom.bean;

public class reservations {
    private long id;
    private String user_name;
    private long bathroom_id;

    public reservations() {
    }

    public reservations(String user_name, long bathroom_id) {
        this.user_name = user_name;
        this.bathroom_id = bathroom_id;
    }

    public reservations(long id, String user_name, long bathroom_id) {
        this.id = id;
        this.user_name = user_name;
        this.bathroom_id = bathroom_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public long getBathroom_id() {
        return bathroom_id;
    }

    public void setBathroom_id(long bathroom_id) {
        this.bathroom_id = bathroom_id;
    }

    @Override
    public String toString() {
        return "reservations{" +
                "id=" + id +
                ", user_name=" + user_name +
                ", bathroom_id=" + bathroom_id +
                '}';
    }
}
