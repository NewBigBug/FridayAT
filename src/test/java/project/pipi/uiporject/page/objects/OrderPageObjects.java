package project.pipi.uiporject.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OrderPageObjects {
    //下单页面

    @AndroidFindBy(id = "com.chudiangameplay.android:id/iv_pinlei_text")
    public MobileElement CHOOSE_CATEGORY;

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.chudiangameplay.android:id/list_content']/android.widget.TextView[1]")
    public MobileElement CHOOSE_FIRST_CATEGORY;

    @AndroidFindBy(id = "com.chudiangameplay.android:id/iv_paymode_text")
    public MobileElement CHOOSE_PAY_WAY;

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.chudiangameplay.android:id/list_content']/android.widget.TextView[3]")
    public MobileElement CHOOSE_PIPIBI_PAY;

    @AndroidFindBy(id = "com.chudiangameplay.android:id/et_remark")
    public MobileElement EDIT_REMARK;

    @AndroidFindBy(id = "com.chudiangameplay.android:id/tv_submit")
    public MobileElement DO_ORDER;








}
