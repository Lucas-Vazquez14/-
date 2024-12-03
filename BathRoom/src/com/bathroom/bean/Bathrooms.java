package com.bathroom.bean;

public class Bathrooms {
    private long id;
    private boolean status;

    public Bathrooms() {
    }

    public Bathrooms(long id, boolean status) {
        this.id = id;
        this.status = status;
    }

    public Bathrooms(boolean status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bathrooms{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
