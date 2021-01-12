package project.pipi.uiporject.pages;

import project.pipi.uiporject.base.BasePage;
import project.pipi.uiporject.credentials.UserCredentials;
import project.pipi.uiporject.page.objects.MobileLoginPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MobileLoginPage extends BasePage {

    MobileLoginPageObjects mobileLoginPageObjects = new MobileLoginPageObjects();

    public MobileLoginPage(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), mobileLoginPageObjects);
    }

    public boolean isMobileLoginPage(){
        waitForElementsToBeAppear(mobileLoginPageObjects.MOBILE);
        return mobileLoginPageObjects.MOBILE.isDisplayed();
    }


    public FirstPage login(UserCredentials userCredentials) throws InterruptedException {
        //输入手机号
        mobileLoginPageObjects.MOBILE.sendKeys(userCredentials.getUserName());
        //点击获取验证码
        mobileLoginPageObjects.GET_VERIFY_CODE.click();
        waitForElementToBeClickable(mobileLoginPageObjects.SET_VERIFY_CODE);
        mobileLoginPageObjects.SET_VERIFY_CODE.sendKeys(userCredentials.getPassWord());
        return new FirstPage(driver);

    }




}
