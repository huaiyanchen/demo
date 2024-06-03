package com.example.demo.service.impl;

import com.example.demo.service.TestService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestServiceImpl implements TestService {
    @Override
    public void test() {
        System.out.println("Test nmd");

    }

    public void test2() {
        int a = 2 / 0;
        System.out.println("Test nmd");

    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("qwe");
        list1.add("asd");
        list1.add("zxc");
        list1.add("123");

        final List<String> list2 = new ArrayList<>();
        list2.add("qwe");
        list2.add("asd");

        List<String> collect = list1.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println(collect);
    }
}
