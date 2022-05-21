package com.hackathon.healthmap.model;

import java.util.ArrayList;
import java.util.Date;
public class User {
    private String firstName;
    private String lastName;
    private Address address;
    private int points;
    private int badges;
    private ArrayList<MeditationLog> logs;
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        points = 0;
        badges = 0;
    }

    public ArrayList<MeditationLog> getLogs() {
        return logs;
    }

    public void setLogs(ArrayList<MeditationLog> logs) {
        this.logs = logs;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPoints(){
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    public int getBadges(){
        return badges;
    }
    public void setBadges(int badges) {
        this.badges = badges;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void meditate(){
        points+=10;
        if (points>0&&points%100==0) //add a badge for every 100 points
        {
            badges++;
            rewardsMessage();
            //ideally sends out a reward message
        }
    }
    public void log (Date startDate, Date endDate) {
        MeditationLog log = new MeditationLog(startDate, endDate);
        logs.add(log);
    }
    public String rewardsMessage() {
        return "Hey " + firstName + ", you have achieved " + points + " points and " + badges + " badges!";
    }
    public String reminderMessage () {
        return "Hey " + firstName + ", this is a reminder to start your meditation app";
    }
}