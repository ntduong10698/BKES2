package com.bksoftwarevn.duongnt.controller;

import com.bksoftwarevn.duongnt.common.AppConst;
import com.bksoftwarevn.duongnt.model.Person;

import java.util.Scanner;

public class PersonController {

    //tìm kiếm sign in, sign up, tìm kiếm, làm menu với menu admin.
    Scanner sc = new Scanner(System.in);

    //sign In
    public Person signIn() {
        System.out.println("*****Đăng Nhập*****");
        Person rs = null;
        printInput("email");
        String email = sc.nextLine();
        printInput("mật khẩu");
        String password = sc.nextLine();
        for (Person p : AppConst.listPerson) {
            if(isEmail(email) && isPassword(password) && p.getEmail().equals(email) && p.getPassword().equals(password)) {
                rs = p;
                break;
            }
        }
        if(rs == null) System.out.println("Tài khoản hoặc mật khẩu không đúng");
        return rs;
    }

    //sign Up
    public Person signUp() {
        System.out.println("*****Đăng Ký*****");
        Person rs = new Person(AppConst.count++,
                checkName(), checkSex(), checkEmail(),
                checkPassword(), checkPhoneNumber(),
                checkAddress(), false, (byte) 0);
        AppConst.listPerson.add(rs);
        System.out.println("*****Đăng ký thành công. Vui lòng đăng nhập để sử dụng hệ thống*****");
        return rs;
    }

    public String checkName() {
        String name = "";
        printInput("tên");
        name = sc.nextLine();
        //to do
        return name;
    }

    public String checkEmail() {
        String rs = "";
        while(true) {
            printInput("email");
            rs = sc.nextLine();
            if(isEmail(rs)) {
                if(!checkInitEmail(rs)) {
                    break;
                } else {
                    System.out.println("Email đã tồn tại. Vui lòng nhập lại.");
                }
            } else {
                printError("email");
            }
        }
        //to do
        return rs;
    }

    public String checkPassword() {
        String rs = "";
        printInput("mật khẩu");
        rs = sc.nextLine();
        //to do
        return rs;
    }

    public byte checkSex() {
        byte rs = 0;
        printInput("giới tính");
        try {
            rs = Byte.parseByte(sc.nextLine());
        } catch (Exception ex){
            System.out.println(ex);
        }
        return rs;
    }

    public String checkPhoneNumber() {
        String rs = "";
        printInput("số điện thoại");
        rs = sc.nextLine();
        return rs;
    }

    public String checkAddress() {
        String rs = "";
        printInput("địa chỉ");
        rs = sc.nextLine();
        return rs;
    }

    public boolean isPassword(String password) {
        return password.matches("\\w+");
    }

    public boolean isEmail(String email) {
        return true;
    }

    public boolean checkInitEmail(String email) {
        boolean rs = false;
        for (Person p : AppConst.listPerson) {
            if(p.getStatus() <2 && p.getEmail().equals(email)) rs = true;
        }
        return rs;
    }

    public void printInput(String text) {
        System.out.println("Mời bạn nhâp "+ text+" : ");
    }

    public void printError(String text) {
        System.out.println("Nhập lỗi định dạng của "+ text + ". Vui lòng nhập lại");
    }

    //tìm kiếm
    public void findByName(boolean admin) {
        printInput("tìm kiếm theo tên");
        int count = 0;
        String name = new Scanner(System.in).nextLine();
        for (Person p : AppConst.listPerson) {
            if((p.getStatus() == 0 || (admin && p.getStatus() == 1))
                && p.getName().toUpperCase().indexOf(name.toUpperCase()) > -1){
                count++;
                System.out.println(p);
            }
        }
        if(count == 0) {
            System.out.println("Không có trường thông tin phù hợp tìm kiếm!");
        } else {
            System.out.println("Có "+count+" người dùng phù hợp với tìm kiếm");
        }
    }

    public void findByAddress(boolean admin) {
        String address = new Scanner(System.in).nextLine();
        int count = 0;
        for (Person p : AppConst.listPerson) {
            if((p.getStatus() == 0 || (admin && p.getStatus() == 1))
                    && p.getAddress().toUpperCase().indexOf(address.toUpperCase()) > -1){
                count++;
                System.out.println(p);
            }
        }
        if(count == 0) {
            System.out.println("Không có trường thông tin phù hợp tìm kiếm!");
        } else {
            System.out.println("Có "+count+" người dùng phù hợp với tìm kiếm");
        }
    }
}
