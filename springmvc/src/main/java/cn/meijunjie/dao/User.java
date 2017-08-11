package cn.meijunjie.dao;

import java.io.Serializable;

public class User implements Serializable{

    private String userName;
    private String passeword;
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasseword() {
        return passeword;
    }

    public void setPasseword(String passeword) {
        this.passeword = passeword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passeword='" + passeword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
