package project.pipi.uiporject.pages;

import project.pipi.uiporject.base.BasePage;
import project.pipi.uiporject.page.objects.FirstPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Charles
 * @className FisrtPage
 * @description TODO
 * @date 2020/10/22 16:24
 */
public class FirstPage extends BasePage {

    FirstPageObjects fisrtPageObjects = new FirstPageObjects();
    public FirstPage(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(super.driver), fisrtPageObjects);
    }

    public boolean isFirstPage(){
        waitForElementToBeClickable(fisrtPageObjects.FIRST);
        return fisrtPageObjects.FIRST.isDisplayed();
    }

    public LoginPage clickMyNotLogin(){
        waitForElementToBeClickable(fisrtPageObjects.MY);
        fisrtPageObjects.MY.click();
        return new LoginPage(driver);
    }

    public MyPagePage clickMyIsLogin(){
        waitForElementToBeClickable(fisrtPageObjects.MY);
        fisrtPageObjects.MY.click();
        return new MyPagePage(driver);
    }

}
