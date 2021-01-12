package project.pipi.uiporject.page.objects;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class MobileLoginPageObjects {
    //短信登录页面

    //手机号输入框
    @AndroidFindBy(id = "com.chudiangameplay.android:id/et_phone")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"请输入手机号\"`]")
    public MobileElement MOBILE;

    @AndroidFindBy(id = "com.chudiangameplay.android:id/tv_get_code")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"获取短信验证码\"`]")
    public MobileElement GET_VERIFY_CODE;

//    @AndroidFindBy(id = "com.chudiangameplay.android:id/et_phone")
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.chudiangameplay.android:id/cl_edit']/android.widget.EditText")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"请输入验证码\"`]")
    public MobileElement SET_VERIFY_CODE;

    @AndroidFindBy(id = "com.chudiangameplay.android:id/tv_get_code")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"登录\"`]")
    public MobileElement MOBILE_LOGIN;

}
