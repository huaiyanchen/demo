package com.example.demo.study.File;

import java.io.*;

public class Test {
    public static void getLogTxtByThreadName(String threadName, String filePath) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(filePath));
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);

        int line = 0;
        String lines = "";
        FileWriter fileWriter = new FileWriter("output.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.newLine();
        while ((lines = bf.readLine()) != null) {
            if (lines.contains(threadName)) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            line++;
        }
        System.out.println("line = " + line);
        bf.close();
    }

    public static void main(String[] args) throws IOException {
        getLogTxtByThreadName("C:/Users/hyc/Desktop/fsdp2_service.log",
                "C:/Users/hyc/Desktop/","CglibAopProxy.java:778" );
    }


    public static void getLogTxtByThreadName(String inputFilePath, String outPutFilePath, String keyWord) {
        try {
            File file = new File(inputFilePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String name = file.getName();
            //:文件名不能包含英文冒号，
            String fileNameKeyWord = keyWord.replaceAll("\\.", "").replaceAll(":", "");
            String fileName = outPutFilePath + name + "-" + fileNameKeyWord + ".txt";
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(keyWord)) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();;
                }
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
