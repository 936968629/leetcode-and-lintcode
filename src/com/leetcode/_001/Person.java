package com.leetcode._001;

public class Person extends animal{

    private String name;

    private int age;

//    public enum status;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Person(String name) {
        this(name, 17);
    }

    @Override
    public int height() {
        return 11;
    }
}
