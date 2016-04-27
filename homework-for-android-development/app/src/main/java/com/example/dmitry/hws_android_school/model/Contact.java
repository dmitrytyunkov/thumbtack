package com.example.dmitry.hws_android_school.model;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

/**
 * Created by Dmitry on 27.04.2016.
 */
@RealmClass
public class Contact extends RealmObject {
    @Required
    private String name;
    @Required
    private String lastName;
    @Required
    private String phone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
