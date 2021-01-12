package project.pipi.uiporject;

import project.pipi.uiporject.pages.AgreementAndPermissionPage;
import project.pipi.uiporject.pages.FirstPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author Charles
 * @className MyTest
 * @description TODO
 * @date 2020/10/22 21:31
 */
public class MyTest {
    DesiredCapabilities caps = new DesiredCapabilities();
    public AppiumDriver<MobileElement> driver;
    public static Properties prop = new Properties();
    static InputStream input = null;

//    LoginPage loginPage;
//    AccountsPage accountsPage;
//    UserCredentials credentials;
    AgreementAndPermissionPage agreementPage;
    FirstPage firstPage;

    @BeforeClass
    public AppiumDriver<MobileElement> getDriver() throws IOException {
//        input = new FileInputStream("property/android.properties");
//        prop.load(input);
//        if (prop.getProperty("platform").equals("android")) {
//            androidSetup();
//        } else {
//            if (prop.getProperty("platform").equals("ios")) {
//                iosSetup();
//            }
//        }
        androidSetup();
//        iosSetup();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public void androidSetup() throws MalformedURLException {
//        caps.setCapability("platformVersion", "10");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("deviceName", "748cf1dd");
        caps.setCapability("app", "/Users/charles/code/IdeaProjects/PipiRunner/apps/app-debug(38).apk");
        caps.setCapability("noReset", true);
        caps.setCapability("appActivity", "com.chudiangameplay.android.ui.activity.MainActivity");
        caps.setCapability("settings[waitForIdleTimeout]",100);
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

    }

    public void iosSetup() throws MalformedURLException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/apps/");
        File app = new File(appDir, "pipi.ipa");
        caps.setCapability("platformVersion", "14.1");
        caps.setCapability("deviceName", "iPhone 12");
        caps.setCapability("udid", "8446952c7a0577088b83cad427c68b5c790829d3");
        caps.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

//    @Test
//    public void mobileLoginWithValidUser() throws InterruptedException, IOException {
//
//
//        AgreementAndPermissionPage agreementAndPermissionPage;
//
//
//        UserCredentials credentials;
//        credentials = new UserCredentials("18062100932","2222");
//
//        agreementAndPermissionPage = new AgreementAndPermissionPage(driver);
//        FirstPage firstPage = agreementAndPermissionPage.acceptAgreementAndPermission();
//        Assert.assertTrue(firstPage.isFirstPage());
//        LoginPage loginPage =  firstPage.clickMyNotLogin();
//        Assert.assertTrue(loginPage.isLoginPage());
//        MobileLoginPage mobileLoginPage =  loginPage.chooseMobileLogin();
//        Assert.assertTrue(mobileLoginPage.isMobileLoginPage());
//        firstPage = mobileLoginPage.login(credentials);
//        Assert.assertTrue(firstPage.isFirstPage());
//
//
//    }

    @Test
    public void myTestByOneStep() throws InterruptedException, IOException {
//        driver.findElement("id","com.chudiangameplay.android:id/tv_ok").click();
//        driver.findElement("id","com.android.packageinstaller:id/permission_allow_button");
        MobileElement findPlayer = driver.findElement("id","com.chudiangameplay.android:id/tvHome");
        Assert.assertTrue(findPlayer.isDisplayed());
        driver.findElement("xpath","//*[@resource-id = 'com.chudiangameplay.android:id/mybottomtabview']/android.widget.RelativeLayout[4]").click();
        Thread.sleep(1000);
        //        driver.findElement("xpath","//*[@text = '我的']").click();




    }




}
