package com.bksoftwarevn.duongnt.view;

import com.bksoftwarevn.duongnt.common.AppConst;
import com.bksoftwarevn.duongnt.controller.PersonController;
import com.bksoftwarevn.duongnt.model.Person;

public class Main {
    public static void main(String[] args) {
        AppConst.listPerson.add(new Person(AppConst.count++,
                "admin", (byte) 0, "admin@gmail.com",
                "Ntduong106", "0966186222",
                "Nghệ An", true));
        PersonController personController = new PersonController();
        Person p = personController.signUp();
        System.out.println(personController.signIn());
    }
}
