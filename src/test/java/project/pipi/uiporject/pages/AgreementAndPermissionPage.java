package project.pipi.uiporject.pages;

/**
 * @author Charles
 * @className AgreementPage
 * @description TODO
 * @date 2020/10/22 15:56
 */

import com.pipi.base.BasePage;
import com.pipi.base.DeviceInterface;
import com.pipi.base.ViewFactory;
import com.pipi.page.objects.AgreementAndPermissionPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;


public class AgreementAndPermissionPage extends BasePage {

    public ViewFactory viewFactory = new ViewFactory(driver);
    public DeviceInterface runnerInfo;

    AgreementAndPermissionPageObjects agreementAndPermissionPageObjects = new AgreementAndPermissionPageObjects();
    public AgreementAndPermissionPage(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(super.driver), agreementAndPermissionPageObjects);
        runnerInfo = viewFactory.getMobilePlatform();
    }


    public com.pipi.pages.FirstPage acceptAgreementAndPermission() {
        String platform = driver.getPlatformName();
        if (platform == null) {
            System.out.println("Something error!");
        }
        if (platform.equalsIgnoreCase("Android")) {

            Map<String, Object> getCapabilities = driver.getCapabilities().asMap();
            String deviceManufacturer = getCapabilities.get("deviceManufacturer").toString();
            //点击我知道了
            if (hasText("我知道了")) {
                waitForElementToBeClickable(agreementAndPermissionPageObjects.I_KNOW);
                agreementAndPermissionPageObjects.I_KNOW.click();
            }

            if (deviceManufacturer.equalsIgnoreCase("oppo")){
//                waitForPageToLoad(agreementAndPermissionPageObjects.I_KNOW);
                //点击我知道了
//                hasPermissionToast(agreementAndPermissionPageObjects.I_KNOW);
//                agreementAndPermissionPageObjects.I_KNOW.click();
//                hasPermissionToast(agreementAndPermissionPageObjects.OPPO_ANDROID_PERMISSION_ALLOW);
                if (hasText("允许")) {
                    waitForElementToBeClickable(agreementAndPermissionPageObjects.OPPO_ANDROID_PERMISSION_ALLOW);
                    agreementAndPermissionPageObjects.OPPO_ANDROID_PERMISSION_ALLOW.click();
                }
            } if(deviceManufacturer.equalsIgnoreCase("netease")){
//                waitForElementToBeClickable(agreementAndPermissionPageObjects.I_KNOW);
//                agreementAndPermissionPageObjects.I_KNOW.click();
//                hasPermissionToast(agreementAndPermissionPageObjects.MUMU_ANDROID_PERMISSION_ALLOW);
                if (hasText("允许")) {
                    waitForElementToBeClickable(agreementAndPermissionPageObjects.MUMU_ANDROID_PERMISSION_ALLOW);
                    agreementAndPermissionPageObjects.MUMU_ANDROID_PERMISSION_ALLOW.click();
                }
            }
        }

        if (platform.equalsIgnoreCase("iOS")) {
            //点击我知道了
            if (hasText("我知道了")) {
                waitForElementToBeClickable(agreementAndPermissionPageObjects.I_KNOW);
                agreementAndPermissionPageObjects.I_KNOW.click();
            }
            //允许获取位置
            if (hasText("使用App时允许")) {
                waitForElementToBeClickable(agreementAndPermissionPageObjects.IOS_PERMISSION_ALLOW_LOCATION);
                agreementAndPermissionPageObjects.IOS_PERMISSION_ALLOW_LOCATION.click();
            }
            //允许通知
            if (hasText("Allow")) {
                waitForElementToBeClickable(agreementAndPermissionPageObjects.IOS_PERMISSION_ALLOW_MESSAGE);
                agreementAndPermissionPageObjects.IOS_PERMISSION_ALLOW_MESSAGE.click();
            }
        }
        return new com.pipi.pages.FirstPage(driver);
    }



//    private void hasPermissionToast(WebElement element){
//        try {
//            waitForElementToBeClickableWithSeconds(element,5);
//            element.click();
//            hasPermissionToast(element);
//            } catch (Exception exception) {
//            System.out.println("无需要授权的toast");
//
//        }
//    }

    private boolean hasText(String text){
        return driver.getPageSource().contains(text);
    }



}
