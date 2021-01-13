package com.project.pipi.uiporject.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OrderDetailPageObjects {
    //订单详情

    //title
    @AndroidFindBy(id = "com.chudiangameplay.android:id/tv_title")
    public MobileElement PAGE_TITLE;

    @AndroidFindBy(id = "com.chudiangameplay.android:id/tv_orderno")
    public MobileElement ORDER_NO;





}
