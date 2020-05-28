package com.bksoftwarevn.duongnt.controller;

import com.bksoftwarevn.duongnt.common.AppConst;
import com.bksoftwarevn.duongnt.model.Person;

import java.util.Scanner;

public class PersonController {

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
                checkAddress(), false);
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
                }
                System.out.println("Email đã tồn tại. Vui lòng nhập lại.");
            }
            printError("email");
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
            if(p.getEmail().equals(email)) rs = true;
        }
        return rs;
    }

    public void printInput(String text) {
        System.out.println("Mời bạn nhâp "+ text+" : ");
    }

    public void printError(String text) {
        System.out.println("Nhập lỗi định dạng của "+ text + ". Vui lòng nhập lại");
    }

}