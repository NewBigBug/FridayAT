package com.project.pipi.uiporject.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchPageObjects {
    //全局搜索

    //搜索框
    @AndroidFindBy(id = "com.chudiangameplay.android:id/et_search")
    public MobileElement SEARCH_EDIT_TEXT;

    //搜索button
    @AndroidFindBy(id = "com.chudiangameplay.android:id/tv_search")
    public MobileElement SEARCH_BUTTON;

    //搜索结果列表，头像，会返回多个，返回list
    @AndroidFindBy(id = "com.chudiangameplay.android:id/iv_head")
    public MobileElement FIRST_SEARCH_RESULT;



}
