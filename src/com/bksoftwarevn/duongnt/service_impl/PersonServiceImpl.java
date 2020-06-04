package com.bksoftwarevn.duongnt.service_impl;

import com.bksoftwarevn.duongnt.common.AppConst;
import com.bksoftwarevn.duongnt.model.Person;
import com.bksoftwarevn.duongnt.service.PersonService;
import java.util.Scanner;

public class PersonServiceImpl implements PersonService {
    @Override
    public Person signIn() {
        System.out.println("*****Đăng Nhập*****");
        Person rs = null;
        printInput("email");
        String email = new Scanner(System.in).nextLine();
        printInput("mật khẩu");
        String password = new Scanner(System.in).nextLine();
        for (Person p : AppConst.listPerson) {
            if(isEmail(email) && isPassword(password) && p.getEmail().equals(email) && p.getPassword().equals(password)) {
                rs = p;
                break;
            }
        }
        if(rs == null) System.out.println("Tài khoản hoặc mật khẩu không đúng");
        return rs;
    }

    @Override
    public Person signUp() {
        return null;
    }

    public boolean isPassword(String password) {
        return password.matches("\\w+");
    }

    public boolean isEmail(String email) {
        return true;
    }
    public void printInput(String text) {
        System.out.println("Mời bạn nhâp "+ text+" : ");
    }

    public void printError(String text) {
        System.out.println("Nhập lỗi định dạng của "+ text + ". Vui lòng nhập lại");
    }
}
