package com.bksoftwarevn.duongnt.model;

import java.util.Date;

public class Person {
    private int id;
    private String name;
    private byte sex; //0 là nam, 1 là nữa, 2 là khác
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private byte status; //0 là đang hoạt động bình thường
    // người dùng nào cũng tìm thấy, 1 là khóa tạm thời
    // (admin vẫn thấy, các người dùng khác ko thấy) sau ...
    // xóa vính viễn, và admin xóa vĩnh viên tức là mọi người
    // đều ko nhìn thấy
    // Nếu tài khoản trùng email với tài khoản có status là 1 thì vẫn tình là trùng, còn 2 thì là không trùng.
    private boolean admin; //true là admin.

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", admin=" + admin +
                '}';
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Person(int id, String name, byte sex, String email, String password, String phoneNumber, String address, boolean admin) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.admin = admin;
    }

    public Person() {
    }

    public Person(String name) {
        this.id = id;
        this.name = name;
    }

    public void printThis() {
        System.out.println(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name, byte sex, String email, String password, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public byte getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
