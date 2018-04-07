package org.ghc.tests.pages;

import org.ghc.pages.KPAUISearchResultsPage;
import org.ghc.pages.KPAUIUnAuthenticatedHomePage;
import org.ghc.utils.extensions.KPAUIEveryTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.List;

import static org.ghc.pages.KPAUISearchResultsPage.*;

import static org.ghc.utils.helpers.KPAUITestHelper.assertContains;
import static org.ghc.utils.helpers.KPAUITestHelper.assertMatches;
import static org.testng.Assert.*;

public class KPAUISearchTests extends KPAUIEveryTest {
    private KPAUIUnAuthenticatedHomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        homePage = super.initializeTest(method);
    }

    //------------------------------------------------------------------------------------------------------------------

    @DataProvider(name = "searchParameters")
    public Object[][] searchParameters(){
        return new Object[][]{
                {"doctor", true, false},
                {"pain", false, false},
                {"doctor", true, true},
                {"pain", false, true}

        };
    }

    @Test(description = "Verify search results formatting. Verify result of misspelled search. Verify search results" +
            "from suggested search link. Verify search results from search spotlight.",
            dataProvider = "searchParameters", groups = {"smoke", "qa", "prod"})
    public void validateSearchMultiplePagesPublicSearch(String searchQuery, boolean spotlight, boolean signIn) {

        KPAUISearchResultsPage searchResultsPage = homePage.getSearchResultsPage(searchQuery, signIn, homePage);

        // Test For General Formatting and Objects Display
        String searchResults = searchResultsPage.getFirstSearchResult().getText();

        assertTrue(searchResultsPage.getSearchButton().isDisplayed());
        assertTrue(searchResultsPage.getSearchField().isDisplayed());
        assertTrue(searchResultsPage.getNarrowSearchForm().isDisplayed());
        assertTrue(searchResultsPage.getSearchResultsHeader().isDisplayed());

        assertMatches(searchResultsPage.getSearchResultsHeader().getText(), SEARCH_RESULT_REGIX );
        assertMatches(searchResultsPage.getPaginationFooter().getText(), PAGINATION_FOOTER);
        assertMatches(searchResultsPage.getPaginationHeader().getText(), PAGINATION_HEADER);
        assertTrue(searchResultsPage.getNarrowSearchForm().isDisplayed());
        verifySearchResultsSpotlightTabDisplays(searchResultsPage, spotlight);

        // Test For Misspelled words and recommended link
        searchResultsPage.searchFromResultsPage("urgentt");
        assertContains(searchResultsPage.getSuggestedSearchSorryText().getText(), NO_RESULTS_MESSAGE);
        assertMatches(searchResultsPage.getSuggestedSearchDidYouMean().getText(), SUGGESTED_SEARCH_REGEX);

        // Confirm that different Search options return different Search results
        searchResultsPage.clickSuggestedSearchLink();
        assertNotEquals(searchResultsPage.getFirstSearchResult(), searchResults);

        // Test the functionality of Search Spotlight
        if (spotlight) searchResultsPage.openCareOptionsFromSpotLight();
    }

    @Test(description = "Verify the pagination Next, Previous, First, Last, and Page Number links opens expected page",
            dataProvider = "searchParameters", groups = {"qa", "prod"})
    public void validateTopPaginationNextPreviousLinks(String searchQuery, boolean spotlight, boolean signIn){

        KPAUISearchResultsPage searchResultsPage = homePage.getSearchResultsPage(searchQuery, signIn, homePage);
        String expectedPageCount = searchResultsPage.getSearchResultsTotalPages();

        //Verify clicking Top/Bottom pagination Next & Previous links opens expected page
        String page1Result = searchResultsPage.getFirstSearchResult().getText();
        assertEquals("1", searchResultsPage.getSearchResultsCurrentPageNum());

        searchResultsPage.openTopPaginationNextLink();
        String page2Result = searchResultsPage.getFirstSearchResult().getText();
        assertEquals("2", searchResultsPage.getSearchResultsCurrentPageNum());
        assertNotEquals(page2Result, page1Result);

        searchResultsPage.openBottomPaginationPreviousLink();
        assertEquals(page1Result, searchResultsPage.getFirstSearchResult().getText());

        searchResultsPage.openBottomPaginationNextLink();
        assertEquals(page2Result, searchResultsPage.getFirstSearchResult().getText());

        //Verify clicking the Top/Bottom pagination Last & First links opens expected page
        searchResultsPage.openTopPaginationLastLink();
        System.out.println("Expected page count: " + expectedPageCount);
        assertEquals(expectedPageCount, searchResultsPage.getSearchResultsCurrentPageNum());
        String lastPageResult = searchResultsPage.getFirstSearchResult().getText();
        assertNotEquals(lastPageResult, page1Result);

        searchResultsPage.openBottomPaginationFirstLink();
        assertEquals(page1Result, searchResultsPage.getFirstSearchResult().getText());

        searchResultsPage.openBottomPaginationLastLink();
        assertEquals(lastPageResult, searchResultsPage.getFirstSearchResult().getText());

        searchResultsPage.openTopPaginationFirstLink();
        assertEquals(page1Result, searchResultsPage.getFirstSearchResult().getText());
    }

    @Test(description = "Verify Narrow Search By Topic, remix, more, less, and all links work as expected.",
            dataProvider = "searchParameters", groups = {"qa", "prod"})
    public void validateNarrowSearchByTopicLinks(String searchQuery, boolean spotlight, boolean signIn) {
        KPAUISearchResultsPage searchResultsPage = homePage.getSearchResultsPage(searchQuery, signIn, homePage);
        String totalFullResultsCount = searchResultsPage.getTotalSearchResultCount();


        //Verify remix link changes the order of the links displayed
        List<WebElement> narrowSearchLinksList = searchResultsPage.getNarrowSearchToList();
        String narrowSearchFirstLinkText = narrowSearchLinksList.get(0).getText();
        String narrowSearchRemixLinkText = searchResultsPage.clickRemixLink().getNarrowSearchFirstResult().getText();
        String narrowSearchUnmixLinkText = searchResultsPage.clickUnmixLink().getNarrowSearchFirstResult().getText();

        List<WebElement> moreLinksList = searchResultsPage.clickMoreLink().getNarrowSearchToList();
        List<WebElement> allLinksList = searchResultsPage.clickAllLink().getNarrowSearchToList();
        List<WebElement> fewerLinksList = searchResultsPage.clickFewerLink().getNarrowSearchToList();

        assertNotEquals(narrowSearchFirstLinkText, narrowSearchRemixLinkText);
        assertEquals(narrowSearchFirstLinkText, narrowSearchUnmixLinkText);
        assertTrue(narrowSearchLinksList.size() < moreLinksList.size());
        assertTrue(moreLinksList.size() < allLinksList.size());
        assertTrue(fewerLinksList.size() < allLinksList.size());

        //Verify Narrow Search Link reduces the number of search results
        String expectedNarrowedResultsCount = searchResultsPage.getNarrowSearchFirstResultCount();
        searchResultsPage.getNarrowSearchFirstResult().click();
        String narrowedResultsCount = searchResultsPage.getTotalSearchResultCount();
        assertEquals(narrowedResultsCount, expectedNarrowedResultsCount);
        assertNotEquals(totalFullResultsCount, narrowedResultsCount);
    }
}
