package project.pipi.uiporject.pages;

import project.pipi.uiporject.base.BasePage;
import project.pipi.uiporject.page.objects.SystemStingPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SystemStingPage extends BasePage {

    SystemStingPageObjects systemStingPageObjects = new SystemStingPageObjects();

    public SystemStingPage(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), systemStingPageObjects);
    }

    public FirstPage ClickLogOut(){
        systemStingPageObjects.LOG_OUT.click();
        systemStingPageObjects.LOG_OUT_COMMIT.click();
        return new FirstPage(driver);
    }
}
