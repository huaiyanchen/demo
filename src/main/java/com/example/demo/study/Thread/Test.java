package com.example.demo.study.Thread;

public class Test {

    public static void printThreadName(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        printThreadName();
    }
}
