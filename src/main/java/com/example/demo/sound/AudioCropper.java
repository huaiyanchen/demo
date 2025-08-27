package com.example.demo.sound;

import javax.sound.sampled.*;
import java.io.*;

public class AudioCropper {

    public static void cropWav(File inputFile, File outputFile, 
                              double startSeconds, double endSeconds) 
                              throws UnsupportedAudioFileException, IOException {
        // 读取输入文件
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputFile);
        AudioFormat format = audioInputStream.getFormat();
        
        // 计算截取范围（帧数）
        long startFrame = (long)(startSeconds * format.getFrameRate());
        long endFrame = (long)(endSeconds * format.getFrameRate());
        long framesToCopy = endFrame - startFrame;

        // 跳过起始帧
        audioInputStream.skip(startFrame * format.getFrameSize());

        // 创建目标音频流
        AudioInputStream croppedStream = new AudioInputStream(
            audioInputStream, format, framesToCopy);

        // 写入新文件
        AudioSystem.write(croppedStream, AudioFileFormat.Type.WAVE, outputFile);
        audioInputStream.close();
    }

    public static void main(String[] args) throws Exception {
        // 示例：截取input.wav的10秒到25秒
        cropWav(new File("C:\\Users\\18712\\Desktop\\1.wav"), new File("33.wav"), 69.0, 89.0);
    }
}
