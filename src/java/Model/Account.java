/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ngoc
 */
public class Account {
    private int id;
    private String nickname;
    private String password;
    private String email;
    private String fullname;
    private String address;
    private int phonenumber;
    private boolean isAdmin;

    public Account() {
    }

    public Account(int id, String nickname, String password, String email, String fullname, String address, int phonenumber, boolean isAdmin) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", nickname=" + nickname + ", password=" + password + ", email=" + email + ", fullname=" + fullname + ", address=" + address + ", phonenumber=" + phonenumber + ", isAdmin=" + isAdmin + '}';
    }
    
}
