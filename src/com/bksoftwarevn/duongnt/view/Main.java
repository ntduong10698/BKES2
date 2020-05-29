package com.bksoftwarevn.duongnt.view;

import com.bksoftwarevn.duongnt.common.AppConst;
import com.bksoftwarevn.duongnt.controller.MenuItemController;
import com.bksoftwarevn.duongnt.controller.PersonController;
import com.bksoftwarevn.duongnt.model.Person;

public class Main {
    public static void main(String[] args) {
        MenuItemController menuItemController = new MenuItemController();
        AppConst.listPerson.add(new Person(AppConst.count++,
                "admin", (byte) 0, "admin@gmail.com",
                "Ntduong106", "0966186222",
                "Nghệ An", true, (byte) 0));
        AppConst.listPerson.add(new Person(AppConst.count++,
                "admin1", (byte) 0, "admin1@gmail.com",
                "Ntduong106", "0966186222",
                "Nghệ An", true, (byte) 1));
        menuItemController.showMenuHome();
    }
}
