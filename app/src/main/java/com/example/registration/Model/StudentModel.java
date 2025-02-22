package com.example.registration.Model;

public class StudentModel {

    private String fname,lname,mail,gender,dob,password;

    public StudentModel(String fname, String lname, String mail, String gender, String dob, String password) {
        this.fname = fname;
        this.lname = lname;
        this.mail = mail;
        this.gender = gender;
        this.dob = dob;
        this.password = password;
    }

    public StudentModel() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
