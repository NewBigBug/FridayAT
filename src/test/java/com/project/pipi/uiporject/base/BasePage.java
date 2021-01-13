package com.project.pipi.uiporject.base;

/**
 * @author Charles
 * @className BasePage
 * @description TODO
 * @date 2020/10/22 16:25
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;


public class BasePage {
    public AppiumDriver<MobileElement> driver;


    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    //等待元素到可点击状态
    public void waitForElementToBeClickable(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    //等待元素到可点击状态，可传指定时间参数
    public void waitForElementToBeClickableWithSeconds(WebElement id,Integer seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Optional.ofNullable(seconds).orElse(5));
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    //等待元素，直到元素消失
    public void waitForElementToBeDisAppear(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfAllElements(id));
    }

    //等待直到元素显示
    public void waitForElementsToBeAppear(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(id));
    }

    public void swipeRight() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.9);
        int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;
        new TouchAction(driver).press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endx,starty)).release().perform();
    }

    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.8);
        int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;
        new TouchAction(driver).press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endx,starty)).release();
    }

    public void swipeUp() {
        Dimension size = driver.manage().window().getSize();
        int startx = size.width / 2;
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.4);
        new TouchAction(driver).press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(startx,endy)).release().perform();
    }


}
