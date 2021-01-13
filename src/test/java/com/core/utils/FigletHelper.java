package com.core.utils;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

/**
 * @description: figlet日志打印工具，便于日志内容识别
 * @author: charles
 * @date: 2021/1/13 4:51 下午
 */

public class FigletHelper {
    public static void figlet(String text) {
        String asciiArt1 = null;
        try {
            asciiArt1 = FigletFont.convertOneLine(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(asciiArt1);
    }
}