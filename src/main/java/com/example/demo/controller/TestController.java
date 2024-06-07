package com.example.demo.controller;

import org.openqa.selenium.devtools.v85.runtime.Runtime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.jvm.hotspot.oops.Array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public Object testMethod(@RequestParam("name") String  name) {
        Map<String, String> aMap = new HashMap<>();
        System.out.println(name);
        aMap.put("asd", "Asdasd");
        return aMap;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public Object testMethod2(String name) {
        Map<String, String> aMap = new HashMap<>();
        System.out.println(name);
        aMap.put("asd", "Asdasd");
        return aMap;
    }

    public static void main(String[] args) throws Exception {
        String fileName = "D:/123.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String res = "";
        String brs = "";
        while ((brs = br.readLine()) != null) {
            res += "'" + brs + "',";
        }

        System.out.println("[" + res + "]");
    }
}
