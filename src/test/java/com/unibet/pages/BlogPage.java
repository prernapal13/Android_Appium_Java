package com.unibet.pages;

import static org.testng.Assert.assertTrue;

import com.unibet.utils.Services;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class BlogPage extends Services {

    private static Logger logger = Logger.getLogger(BlogPage.class.getName());

    private String xpathBlogHeading = "//div[@id='social-content-hub']//div//h1";
    private String xpathBlogPara = "//div[@id='social-content-hub']//div//p";

    private AppiumDriver<MobileElement> driver;

    public BlogPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyBlogPage() {
        waitForElementByXpath(xpathBlogHeading);
        assertTrue(isElementPresentByXpath(xpathBlogHeading));
        logger.info("# Verified blog page has been loaded successfully");
    }

    public void verifySearchTxtPresentInBlog(String searchTxt) {
        List<MobileElement> lstParaEle = driver.findElements(By.xpath(xpathBlogPara));
        boolean isPresent = false;
        for (MobileElement ele : lstParaEle) {
            String actualHeading = ele.getText().toLowerCase();
            if (actualHeading.contains(searchTxt.toLowerCase())) {
                isPresent = true;
                break;
            }
        }
        logger.info("# Verifying blog paragraph being displayed has search string: " + searchTxt);
        assertTrue(isPresent, searchTxt + " is not present in blog.");
    }
}