package com.project.pipi.uiporject.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * @author Charles
 * @className FirstPageObjects
 * @description TODO
 * @date 2020/10/22 17:44
 */
public class FirstPageObjects {

    //首页找陪玩
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.chudiangameplay.android:id/tvHome\").text(\"找陪玩\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"找陪玩\"`]")
    public MobileElement FIRST;

    //首页
    @AndroidFindBy(xpath = "//*[@id = 'com.chudiangameplay.android:id/mybottomtabview']/android.widget.RelativeLayout[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"首页\"`]")
    public MobileElement HOME;

    //聊天室
    @AndroidFindBy(xpath = "//*[@id = 'com.chudiangameplay.android:id/mybottomtabview']/android.widget.RelativeLayout[2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"聊天室\"`]")
    public MobileElement CHAT;

    //消息
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.chudiangameplay.android:id/mybottomtabview']/android.widget.RelativeLayout[4]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"消息\"`]")
    public MobileElement MESSAGE;

    //我的
//    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.chudiangameplay.android:id/mybottomtabview\").childSelector(className(\"android.widget.RelativeLayout\").instance(3))")
//    @AndroidFindBy(id = "\"com.chudiangameplay.android:id/mybottomtabview\"")
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.chudiangameplay.android:id/mybottomtabview']/android.widget.RelativeLayout[4]")

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"我的\"`]")
    public MobileElement MY;


    @AndroidFindBy(id = "com.chudiangameplay.android:id/ivSearch")
    public MobileElement SEARCH;






}
