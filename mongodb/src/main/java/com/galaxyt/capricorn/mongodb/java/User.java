package com.galaxyt.capricorn.mongodb.java;

import org.bson.types.ObjectId;

public class User {

    private Object _id;

    private String name;

    public Object get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
