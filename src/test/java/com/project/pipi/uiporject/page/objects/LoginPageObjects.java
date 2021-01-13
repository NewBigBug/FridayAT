package com.project.pipi.uiporject.page.objects;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class LoginPageObjects {
    //手机号登录
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"手机号登录\"`]")
    @AndroidFindBy(id = "com.chudiangameplay.android:id/rl_submit")
    public MobileElement CHOOSE_MOBILE_LOGIN;



}
