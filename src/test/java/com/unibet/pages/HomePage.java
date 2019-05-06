package com.unibet.pages;

import org.apache.log4j.Logger;

import com.unibet.utils.Services;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage extends Services {
	
	private static Logger logger = Logger.getLogger(HomePage.class.getName());

    private static String idUnibetLogo = "logo";
    private static String idacceptCookies = "CybotCookiebotDialogBodyButtonAccept";
    private static String xpathMenuIcon = "//div[@id='social-content-hub']//*[name()='svg']/*[name()='g' and @class='svg-icon']";
    private static String xpathSearchInputText = "//input[@placeholder='Search in blog']";

    private AppiumDriver<MobileElement> driver;

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyUnibetHomePage() {
        waitForElementById(idUnibetLogo);
        isElementPresentById(idUnibetLogo);
        logger.info("# Verified Unibet logo is displayed in page");
    }

    public void acceptCookiesCollection() {
        waitForElementById(idacceptCookies);
        assertAndClickById(idacceptCookies);
        logger.info("# Clicked on OK button to allow cookie collection");
    }

    public void openMenuOptions() {
        assertAndClickByXpath(xpathMenuIcon);
        logger.info("# Clicked on Blog Menu button to view options");
    }

    public void searchForAText(String searchString) {
        assertAndClickByXpath(xpathSearchInputText);
        assertAndTypeByXpath(xpathSearchInputText, searchString);
        pressEnter(xpathSearchInputText);
        logger.info("# Performed search for string: " + searchString);
    }
}
