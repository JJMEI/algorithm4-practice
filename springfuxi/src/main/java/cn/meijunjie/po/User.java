package cn.meijunjie.po;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

    private int userId;
    private String userName;
    private String password;
    private String lastIp;
    private Date lastVisit;

    public User(){

    }

    public User(int userId, String userName, String password, String lastIp, Date lastVisit) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.lastIp = lastIp;
        this.lastVisit = lastVisit;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", lastVisit=" + lastVisit +
                '}';
    }
}
