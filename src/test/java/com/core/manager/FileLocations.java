package com.core.manager;

import static java.lang.System.getenv;

/**
 * @description: some desc
 * @author: charles
 * @date: 2021/1/13 5:59 下午
 */
public enum FileLocations {
    OUTPUT_DIRECTORY(""),
    PARALLEL_XML_LOCATION("parallel.xml"),
    SCREENSHOTS_DIRECTORY("screenshot/"),
    ANDROID_SCREENSHOTS_DIRECTORY("screenshot/android/"),
    IOS_SCREENSHOTS_DIRECTORY("screenshot/iOS/"),
    APPIUM_LOGS_DIRECTORY("appiumlogs/"),
    ADB_LOGS_DIRECTORY("adblogs/"),
    DEVICE_LOGS_DIRECTORY("reports/deviceLogs/"),
    DERIVED_DATA("derivedData/");

    private final String fileDir;

    FileLocations(String fileDir) {
        this.fileDir = fileDir;
    }

    public String getFileLocation(){
        String root = System.getenv("OUTPUT_DIRECTORY") != null ? "/" + System.getenv("OUTPUT_DIRECTORY") + "/" : "/target/";
        return root + fileDir;
    }

//    public static void main(String[] args) {
//        System.out.println(FileLocations.ANDROID_SCREENSHOTS_DIRECTORY.getFileLocation());
//
//    }
}
