package project.pipi.uiporject.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * @author Charles
 * @className AgreementAndPermissionPageObjects
 * @description TODO
 * @date 2020/10/22 15:45
 */

public class AgreementAndPermissionPageObjects {

    //我知道了
    @AndroidFindBy(id = "com.chudiangameplay.android:id/tv_ok")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"我知道了\"`]")
    public MobileElement I_KNOW;


    //Android权限点击
    //mumu模拟器
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public MobileElement MUMU_ANDROID_PERMISSION_ALLOW;
    //OPPO
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public MobileElement OPPO_ANDROID_PERMISSION_ALLOW;


    //iOS权限点击
    //查找并连接设备
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"好\"`]")
    public MobileElement IOS_PERMISSION_ALLOW_CONNECT;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"使用App时允许\"`]")
    public MobileElement IOS_PERMISSION_ALLOW_LOCATION;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Allow\"`]")
    public MobileElement IOS_PERMISSION_ALLOW_MESSAGE;

}
