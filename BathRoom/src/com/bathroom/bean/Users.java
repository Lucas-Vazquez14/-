package com.bathroom.bean;

public class Users {
    private long id;
    private String name;
    private String password;
    private int num;

    public Users() {
    }

    public Users(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Users(long id, String name, String password, int num) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.num = num;
    }

    public Users(String name, String password, int num) {
        this.name = name;
        this.password = password;
        this.num = num;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", num=" + num +
                '}';
    }
}
