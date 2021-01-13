package com.project.pipi.uiporject.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PlayeeHomePageObjects {
    //陪玩师主页

    //下单，不指定品类
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.chudiangameplay.android:id/ll_bottom']/android.widget.TextView[3]")
    public MobileElement TO_ORDER_NO_TYPE;




}
