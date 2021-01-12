package project.pipi.uiporject.tests;


import com.core.appium.manager.AppiumDriverManager;
import com.pipi.base.JSonParser;
import com.pipi.credentials.UserCredentials;
import com.pipi.pages.*;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.core.appium.utils.FigletHelper.figlet;

public class LoginTest {
    FirstPage firstPage;
    AgreementAndPermissionPage agreementAndPermissionPage;


    UserCredentials credentials;


    @Test
    public void mobileLoginWithValidUser() throws InterruptedException, IOException {
        figlet("mobileLoginWithValidUser");
        credentials = new UserCredentials(getUserName(), getPassword());
        agreementAndPermissionPage = new AgreementAndPermissionPage(AppiumDriverManager.getDriver());
        FirstPage firstPage = agreementAndPermissionPage.acceptAgreementAndPermission();
        Assert.assertTrue(firstPage.isFirstPage());
        LoginPage loginPage =  firstPage.clickMyNotLogin();
        Assert.assertTrue(loginPage.isLoginPage());
        MobileLoginPage mobileLoginPage =  loginPage.chooseMobileLogin();
        Assert.assertTrue(mobileLoginPage.isMobileLoginPage());
        firstPage = mobileLoginPage.login(credentials);
        Assert.assertTrue(firstPage.isFirstPage());
    }


    @Test
    public void userLogOut() throws InterruptedException, IOException {
        figlet("userLogOut");
        firstPage = new FirstPage(AppiumDriverManager.getDriver());
        Assert.assertTrue(firstPage.isFirstPage());
        MyPagePage myPagePage = firstPage.clickMyIsLogin();
        SystemStingPage systemStingPage = myPagePage.ClickSting();
        FirstPage firstPage = systemStingPage.ClickLogOut();
        Assert.assertTrue(firstPage.isFirstPage());
    }


    public String getUserName() {
        System.out.println(Thread.currentThread().getName().toString());
        String[] crds = Thread.currentThread().getName().toString().split("-");
        JSONObject user = new JSonParser().getUserData(Integer.parseInt(crds[2])-1);
        return user.get("userName").toString();
    }

    public String getPassword() {
        String[] crds = Thread.currentThread().getName().toString().split("-");
        JSONObject user = new JSonParser().getUserData(Integer.parseInt(crds[2])-1);
        return user.get("password").toString();
    }

}
