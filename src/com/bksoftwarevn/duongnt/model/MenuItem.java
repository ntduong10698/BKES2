package com.bksoftwarevn.duongnt.model;

public class MenuItem {
    private int code;
    private String name;

    public MenuItem(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public MenuItem() {
    }

    @Override
    public String toString() {
        return code + ". " + name +".";
    }
}
