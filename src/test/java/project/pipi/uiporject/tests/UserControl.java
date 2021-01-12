package project.pipi.uiporject.tests;


import com.pipi.base.JSonParser;
import com.pipi.credentials.UserCredentials;
import com.pipi.pages.AgreementAndPermissionPage;
import com.pipi.pages.FirstPage;
import com.pipi.pages.LoginPage;
import com.pipi.pages.MobileLoginPage;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserControl {
    FirstPage firstPage;
    AgreementAndPermissionPage agreementAndPermissionPage;


    UserCredentials credentials;


    @Test(description = "手机号登录")
    public void mobileLoginWithValidUser() throws InterruptedException, IOException {
        credentials = new UserCredentials(getUserName(), getPassword());
        LoginPage loginPage =  firstPage.clickMyNotLogin();
        Assert.assertTrue(loginPage.isLoginPage());
        MobileLoginPage mobileLoginPage =  loginPage.chooseMobileLogin();
        Assert.assertTrue(mobileLoginPage.isMobileLoginPage());
        firstPage = mobileLoginPage.login(credentials);
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
