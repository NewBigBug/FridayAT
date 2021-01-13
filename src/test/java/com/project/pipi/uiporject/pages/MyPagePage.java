package com.project.pipi.uiporject.pages;

import com.project.pipi.uiporject.base.BasePage;
import com.project.pipi.uiporject.page.objects.MyPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MyPagePage extends BasePage {


    MyPageObjects myPageObjects = new MyPageObjects();

    public MyPagePage(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myPageObjects);
    }

//    public boolean isSystemStingPage(){
//        waitForElementsToBeAppear(mobileLoginPageObjects.MOBILE);
//        return mobileLoginPageObjects.MOBILE.isDisplayed();
//    }

    public SystemStingPage ClickSting() throws InterruptedException {
        Thread.sleep(2000);
        swipeUp();
        myPageObjects.XI_TONG_SHE_ZHI.click();
        return new SystemStingPage(driver);
    }

}
