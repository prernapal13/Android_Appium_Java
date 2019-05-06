package com.unibet.test;

import com.unibet.pages.BlogPage;
import com.unibet.pages.HomePage;
import com.unibet.pages.SearchResultPage;
import com.unibet.utils.Init;
import org.testng.annotations.Test;

public class TestSearchBlog extends Init {

    @Test
    public void testSearchBlog() {
        HomePage homePage = new HomePage(driver);
        homePage.verifyUnibetHomePage();
        homePage.acceptCookiesCollection();
        homePage.openMenuOptions();
        String searchTxt = "Poker";
        homePage.searchForAText(searchTxt);

        SearchResultPage searchResult = new SearchResultPage(driver);
        searchResult.verifySearchResultPage();
        searchResult.verifySearchTxt(searchTxt);

        searchResult.verifySearchedResult(searchTxt);
    }

    @Test
    public void testNoSearchResults() {
        HomePage homePage = new HomePage(driver);
        homePage.verifyUnibetHomePage();
        homePage.acceptCookiesCollection();
        homePage.openMenuOptions();

        String searchTxt = "Prerna";
        homePage.searchForAText(searchTxt);

        SearchResultPage searchResult = new SearchResultPage(driver);
        searchResult.verifySearchResultPage();
        searchResult.verifySearchTxt(searchTxt);
        searchResult.verifyNoSearchResults();
    }

    @Test
    public void testSearchBlogAutoSuggestion() {
        HomePage homePage = new HomePage(driver);
        homePage.verifyUnibetHomePage();
        homePage.acceptCookiesCollection();
        homePage.openMenuOptions();
        String searchTxt = "Prerna";

        homePage.searchForAText(searchTxt);

        SearchResultPage searchResult = new SearchResultPage(driver);
        searchResult.verifySearchResultPage();
        searchResult.verifySearchTxt(searchTxt);
        searchResult.verifyNoSearchResults();

        searchTxt = "Poker";
        searchResult.enterSearchTxt(searchTxt);
        searchResult.verifyAutoSuggestionList(searchTxt);
        searchResult.clickOnSuggestion();
        BlogPage blogPage = new BlogPage(driver);
        blogPage.verifyBlogPage();
        blogPage.verifySearchTxtPresentInBlog(searchTxt);
    }
}
