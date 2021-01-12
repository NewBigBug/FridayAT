package project.pipi.uiporject.tests;

import com.core.appium.manager.AppiumDriverManager;
import com.pipi.pages.FirstPage;
import com.pipi.pages.LoginPage;
import org.testng.Assert;

import java.io.IOException;

public class EnterWithLoginTest {
    FirstPage firstPage;




    public void enterWithLogin() throws InterruptedException, IOException {
        firstPage = new FirstPage(AppiumDriverManager.getDriver());
        Assert.assertTrue(firstPage.isFirstPage());
        LoginPage loginPage = firstPage.clickMyNotLogin();
        Assert.assertTrue(loginPage.isLoginPage());
        System.out.println("333333333333333333333333333333333333333333333333333333333333333333333333");
    }
}
