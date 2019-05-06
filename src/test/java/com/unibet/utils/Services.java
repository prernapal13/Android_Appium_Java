package com.unibet.utils;

import static org.testng.Assert.assertTrue;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Services {

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public Services(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    protected void waitForElementById(String id) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    protected void waitForElementByXpath(String xpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    protected boolean isElementPresentByXpath(String xpath) {
        try {
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception e) {
            System.out.println("Element is not present by xpath: " + xpath);
        }
        return false;
    }

    protected boolean isElementPresentById(String id) {
        try {
            driver.findElement(By.id(id));
            return true;
        } catch (Exception e) {
            System.out.println("Element is not present by id: " + id);
        }
        return false;
    }

    protected void assertAndClickById(String id) {
        waitForElementById(id);
        assertTrue(isElementPresentById(id), "Element by id " + id + "should be present.");
        driver.findElement(By.id(id)).click();
    }

    protected void assertAndClickByXpath(String xpath) {
        waitForElementByXpath(xpath);
        assertTrue(isElementPresentByXpath(xpath), "Element " + xpath + "should be present.");
        driver.findElement(By.xpath(xpath)).click();
    }

    protected void assertAndTypeByXpath(String xpath, String txt) {
        waitForElementByXpath(xpath);
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(txt);
    }

    protected void pressEnter(String xpath) {
        driver.findElement(By.xpath(xpath)).sendKeys(Keys.RETURN);
    }

    protected String assertAndGetTextByXpath(String xpath) {
        waitForElementByXpath(xpath);
        return driver.findElement(By.xpath(xpath)).getText();
    }

    protected String assertAndGetTextByXpath(String xpath, String attr) {
        waitForElementByXpath(xpath);
        return driver.findElement(By.xpath(xpath)).getAttribute(attr);
    }
}