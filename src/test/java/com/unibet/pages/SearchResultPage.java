package com.unibet.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.unibet.utils.Services;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SearchResultPage extends Services {

    private static Logger logger = Logger.getLogger(SearchResultPage.class.getName());

    private static final String NO_SEARCH_RESULTS = "No search results";
    private String xpathSearchField = "//div[@id='social-content-hub']//input[@type='text']";
    private String xpathNoSearchResults = "//div[@id='social-content-hub']//h1";
    private String xpathAutoSuggestion = "//div[@id='social-content-hub']//ul//li";
    private String xpathSearchPara = "//div[@id='social-content-hub']//div//p";

    private AppiumDriver<MobileElement> driver;

    public SearchResultPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifySearchResultPage() {
        waitForElementByXpath(xpathSearchField);
        assertTrue(isElementPresentByXpath(xpathSearchField));
        logger.info("# Verified search result page has been loaded successfully");
    }

    public void verifySearchTxt(String searchTxt) {
        String actualSearchTxt = assertAndGetTextByXpath(xpathSearchField, "value");
        logger.info("# Verifying searched text '" + searchTxt + "' is present in the blog");
        assertEquals(actualSearchTxt, searchTxt);
    }

    public void verifyNoSearchResults() {
        String actualSearchResult = assertAndGetTextByXpath(xpathNoSearchResults);
        logger.info("# Verifying '" + NO_SEARCH_RESULTS + "' is being displayed on screen");
        assertEquals(actualSearchResult, NO_SEARCH_RESULTS);
    }

    public void enterSearchTxt(String searchTxt) {
        assertAndTypeByXpath(xpathSearchField, searchTxt);
        logger.info("# Entered search text '" + searchTxt + "'");
    }

    public void verifyAutoSuggestionList(String searchTxt) {
        waitForElementByXpath(xpathAutoSuggestion);
        List<MobileElement> lstEle = driver.findElements(By.xpath(xpathAutoSuggestion));
        for (MobileElement ele : lstEle) {
            String actualTxt = ele.getText().toLowerCase();
            logger.info("# Verifying searched text '" + searchTxt + "' is present auto-suggestion '"
                + actualTxt + "'");
            assertTrue(actualTxt.contains(searchTxt.toLowerCase()));
        }
    }

    public void verifySearchedResult(String searchTxt) {
        List<MobileElement> lstParaEle = driver.findElements(By.xpath(xpathSearchPara));
        for (int i = 0; i < lstParaEle.size(); i++) {
            String actualHeading = lstParaEle.get(i).getText().toLowerCase();
            logger.info("# Verifying searched text '" + searchTxt + "' is present in paragraph '"
                + actualHeading + "'");
            assertTrue(actualHeading.contains(searchTxt.toLowerCase()),
                searchTxt + " is not present in paragraph " + actualHeading);
        }
    }

    public void clickOnSuggestion() {
        assertAndClickByXpath(xpathAutoSuggestion);
        logger.info("# Clicked on auto-suggestion");
    }
}
