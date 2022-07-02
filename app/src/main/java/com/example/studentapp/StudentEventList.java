package com.example.studentapp;

public class StudentEventList {
    String Club,Name,Link,Date;

    public StudentEventList(){}

    public StudentEventList(String club, String name, String link, String date) {
        Club = club;
        Name = name;
        Link = link;
        Date = date;
    }

    public String getClub() {
        return Club;
    }

    public void setClub(String club) {
        Club = club;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
