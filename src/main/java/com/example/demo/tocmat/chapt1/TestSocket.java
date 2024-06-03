package com.example.demo.tocmat.chapt1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TestSocket {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("baidu.com", 80);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        printWriter.println("abc");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuffer sb = new StringBuffer(8096);
        boolean flag = true;
        while (flag) {
            if ( bufferedReader.ready() ) {
                int i=0;
                while (i!=-1) {
                    i = bufferedReader.read();
                    sb.append((char) i);
                }
                flag = false;
            }
            Thread.sleep(50);
        }
        System.out.println(sb.toString());
    }
}
