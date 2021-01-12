package project.pipi.uiporject.tests;

/**
 * @author Charles
 * @className EnterInApp
 * @description TODO
 * @date 2020/10/22 17:57
 */

import com.core.appium.manager.AppiumDriverManager;
import com.pipi.pages.AgreementAndPermissionPage;
import com.pipi.pages.FirstPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class EnterInAppTest {
    AgreementAndPermissionPage agreementAndPermissionPage;


    @BeforeTest
    public void firstEnter(){
        agreementAndPermissionPage = new AgreementAndPermissionPage(AppiumDriverManager.getDriver());
        FirstPage firstPage = agreementAndPermissionPage.acceptAgreementAndPermission();
        Assert.assertTrue(firstPage.isFirstPage());

    }

}
