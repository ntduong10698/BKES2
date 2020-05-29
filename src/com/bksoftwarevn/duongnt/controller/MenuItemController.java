package com.bksoftwarevn.duongnt.controller;

import com.bksoftwarevn.duongnt.common.AppConst;
import com.bksoftwarevn.duongnt.model.MenuItem;
import com.bksoftwarevn.duongnt.model.Person;

import java.util.Scanner;

public class MenuItemController {

    PersonController personController = new PersonController();

    //tuong tự làm thêm thằng show menu đăng nhập
    public void showMenuHome() {
        System.out.println(AppConst.nameProject);
        MenuItem dangNhap = new MenuItem(1, "Đăng Nhâp");
        MenuItem dangKy = new MenuItem(2, "Đăng Ký");
        MenuItem thoat = new MenuItem(0, "Thoát");
        int option = 0;
        while (true) {
            System.out.println("\n*****Menu Home*****");
            showMenu(dangNhap, dangKy, thoat);
            System.out.println("Mời bạn chọn chức năng hiện thị trên menu:");
            option = new Scanner(System.in).nextInt();
            handleMenuHome(option);
        }
    }

    public void showMenu(MenuItem ...listMenu) {
        int size = listMenu.length;
        for (int i = 0; i < size; i++) {
            System.out.println(listMenu[i]);
        }
    }

    public void handleMenuHome(int option) {
        switch (option) {
            case 1:
                Person p = personController.signIn();
                break;
            case 2:
                personController.signUp();
                break;
            case 0:
                System.out.println("Cảm ơn bạn đã sử dụng hệ thống. Hẹn gặp lại bạn sớm nhất.");
                System.exit(0);
                break;
            default:
                System.out.println("Chức năng chưa được phát triển. Xin vui lòng chọn những chức năng hiện thi!");
        }
    }
}
