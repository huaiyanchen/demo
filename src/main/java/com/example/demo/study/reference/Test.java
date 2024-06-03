package com.example.demo.study.reference;

public class Test {

    public static void setA(Integer a) {
        a = 199999990;
        System.out.println("setA=" + a);
    }



    public static void main(String[] args) {
        Integer a = new Integer(19990);
        setA(a);
        System.out.println("mainA=" + a);
    }
}
