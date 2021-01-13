package com.core.manager;

import static java.lang.System.getenv;
import static java.util.Optional.ofNullable;

/**
 * @description: some desc
 * @author: charles
 * @date: 2021/1/13 5:59 下午
 */
public enum FileLocation {
    OUTPUT_DIRECTORY(""),
    PARALLEL_XML_LOCATION("parallel.xml"),
    SCREENSHOTS_DIRECTORY("screenshot/");

    private final String filename;

    FileLocation(String filename) {
        this.filename = filename;

    }

    public String get() {
        return filename;
    }



    public static void main(String[] args) {
        System.out.println(FileLocation.OUTPUT_DIRECTORY.get());

    }
}
