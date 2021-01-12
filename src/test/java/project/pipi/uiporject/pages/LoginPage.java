package project.pipi.uiporject.pages;

import project.pipi.uiporject.page.objects.LoginPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import project.pipi.uiporject.base.BasePage;

public class LoginPage extends BasePage {


    LoginPageObjects loginPageObjects = new LoginPageObjects();
    public LoginPage(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPageObjects);
    }

    public boolean isLoginPage(){
        waitForElementToBeClickable(loginPageObjects.CHOOSE_MOBILE_LOGIN);
        return loginPageObjects.CHOOSE_MOBILE_LOGIN.isDisplayed();

    }



    public MobileLoginPage chooseMobileLogin(){
        //点击手机号登录
        loginPageObjects.CHOOSE_MOBILE_LOGIN.click();
        return new MobileLoginPage(driver);
    }




}
