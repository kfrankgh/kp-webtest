package org.ghc.pages;

import org.ghc.utils.extensions.KPAUIEveryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import static org.ghc.utils.helpers.KPAUIStringHelper.getRegexMatch;
import static org.ghc.utils.helpers.KPAUIStringHelper.getRegexMatches;
import static org.ghc.utils.helpers.KPAUITestHelper.*;
import static org.testng.Assert.fail;

public class KPAUISearchResultsPage extends KPAUIEveryPage {

    public KPAUISearchResultsPage(WebDriver driver) {
        super(driver);
        if (!isCurrent(driver, PAGETITLE_SEARCB))
            fail("The Search Results Page did not load correctly");
    }

    //------------------------------------------------------------------------------------------------------------------

    public static final String PAGETITLE_SEARCB = "Search";


    public static final String NO_RESULTS_MESSAGE =                 "Sorry, no matches were found.";
    public static final String SEARCH_RESULT_REGIX =                "Results \\d+-\\d+ of about (\\d+|\\d,\\d+)";
    public static final String SUGGESTED_SEARCH_REGEX =             "^Did you mean \\w+\\?$";
    public static final String PAGINATION_FOOTER =                  "first.*previous.*next.*last";
    public static final String PAGINATION_HEADER =                  "first.*previous.*page \\d+ of \\d+.*next.*last";

    @FindBy(css = "[id^=\"doc-Ndoc\"]")                             private List<WebElement> firstSearchResult;
    @FindBy(linkText = "all")                                       private WebElement narrowSearchAll;
    @FindBy(linkText = "fewer")                                     private WebElement narrowSearchFewer;
    @FindBy(xpath = "//ul/li[1]/div/div[2]/a")                      private WebElement narrowSearchFirstResult;
    @FindBy(xpath = "//ul/li[1]/div/div[2]/span")                   private WebElement narrowSearchFirstResultCount;
    @FindBy(xpath = "//*[@id=\"clusters-content\"]")                private WebElement narrowSearchForm;
    @FindBy(linkText = "more")                                      private WebElement narrowSearchMore;
    @FindBy(linkText = "remix")                                     private WebElement narrowSearchRemix;
    @FindBy(linkText = "unmix")                                     private WebElement narrowSearchUnmix;
    @FindBy(css = "div.list-more.list-more-bottom")                 private WebElement paginationFooter;
    @FindBy(xpath = "//*[@id=\"document-list\"]/div[2]")            private WebElement paginationHeader;
    @FindBy(linkText = "first")                                     private List<WebElement> paginationFirst;
    @FindBy(linkText = "last")                                      private List<WebElement> paginationLast;
    @FindBy(linkText = "next")                                      private List<WebElement> paginationNext;
    @FindBy(linkText = "previous")                                  private List<WebElement> paginationPrevious;
    @FindBy(xpath = "//table/tbody/tr/td[2]/input")                 private WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"input-query\"]")                     private WebElement searchField;
    @FindBy(xpath = "//*[@id=\"search-details\"]")                  private WebElement searchResultsHeader;
    @FindBy(css = "#spotlight-1-content a")                         private WebElement spotlightFirstLink;
    @FindBy(xpath = "//*[@id=\"document-list\"]/div[2]/span")       private WebElement suggestedSearchDidYouMean;
    @FindBy(xpath = "//*[@id=\"document-list\"]/div[2]/span/a")     private WebElement suggestedSearchLink;
    @FindBy(xpath = "//*[@id=\"search-details\"]")                  private WebElement suggestedSearchSorryText;

    public  WebElement getFirstSearchResult()                       { return firstSearchResult.get(0); }
    private WebElement getNarrowSearchAll()                         { return narrowSearchAll; }
    private WebElement getNarrowSearchFewer()                       { return narrowSearchFewer; }
    public  WebElement getNarrowSearchFirstResult()                 { return narrowSearchFirstResult; }
    public  WebElement getNarrowSearchForm()                        { return narrowSearchForm; }
    private WebElement getNarrowSearchMore()                        { return narrowSearchMore; }
    private WebElement getNarrowSearchRemix()                       { return narrowSearchRemix; }
    private WebElement getNarrowSearchUnmix()                       { return narrowSearchUnmix; }
    public  List<WebElement> getNarrowSearchToList()                { return driver.findElements(By.xpath("//li/div/div[2]/a")); }
    public  WebElement getPaginationFooter()                        { return paginationFooter; }
    public  WebElement getPaginationHeader()                        { return paginationHeader; }
    private List<WebElement> getPaginationFirst()                   { return paginationFirst; }
    private List<WebElement> getPaginationLast()                    { return paginationLast; }
    private List<WebElement> getPaginationNext()                    { return paginationNext; }
    private List<WebElement> getPaginationPrevious()                { return paginationPrevious; }
    public  WebElement getSearchButton()                            { return searchButton; }
    public  WebElement getSearchField()                             { return searchField; }
    public  WebElement getSearchResultsHeader()                     { return searchResultsHeader; }
    private WebElement getSpotlightFirstLink()                      { return spotlightFirstLink; }
    public  WebElement getSuggestedSearchDidYouMean()               { return suggestedSearchDidYouMean; }
    private WebElement getSuggestedSearchLink()                     { return suggestedSearchLink; }
    public  WebElement getSuggestedSearchSorryText()                { return suggestedSearchSorryText; }


    /** Clicks on the "All" link in the narrow search field
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage clickAllLink(){
        getNarrowSearchAll().click();
        return new KPAUISearchResultsPage(driver);
    }

    /** Clicks on the "Fewer" link in the narrow search field
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage clickFewerLink(){
        getNarrowSearchFewer().click();
        return new KPAUISearchResultsPage(driver);
    }

    /** Clicks on the "More" link in the narrow search field
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage clickMoreLink(){
        getNarrowSearchMore().click();
        return new KPAUISearchResultsPage(driver);
    }

    /** Clicks on the "Remix" link in the narrow search field
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage clickRemixLink(){
        getNarrowSearchRemix().click();
        return new KPAUISearchResultsPage(driver);
    }

    /** Clicks on the "Unmix" link in the narrow search field
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage clickUnmixLink(){
        getNarrowSearchUnmix().click();
        return new KPAUISearchResultsPage(driver);
    }

    /** Clicks on the suggested search link when the user types a misspelled word
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage clickSuggestedSearchLink(){
        getSuggestedSearchLink().click();
        return new KPAUISearchResultsPage(driver);
    }

    /** Returns the page count next to the Narrow Search Topic eg 34 in 'Cancer(34)'
     * @return - The page count in the form of a string
     */
    public String getNarrowSearchFirstResultCount() {
        return getRegexMatch(narrowSearchFirstResultCount.getText(), "\\d+");
    }

    /** Returns the Current page number from the Search Results Header
     * @return - The page number in the form of a String
     */
    public String getSearchResultsCurrentPageNum(){
        return getRegexMatches(getPaginationHeader().getText(), "\\d+").get(0);
    }

    /** Returns the Total pages from the Search Results Header
     * @return - The page number in the form of a String
     */
    public String getSearchResultsTotalPages(){
        return getRegexMatches(getPaginationHeader().getText(), "\\d+").get(1);
    }

    /** Returns the total Search Results Count of the query eg '1250'
     * @return - The string form of the Total Result Count
     */
    public String getTotalSearchResultCount() {
        return getRegexMatch(getSearchResultsHeader().getText()
                .replace(",",""), "((?<=of about.)|(?<=of.))(\\d+)(|in)");
    }

    /** Opens the 'First' Link from the Bottom Pagination Bar
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage openBottomPaginationFirstLink(){
        getPaginationFirst().get(1).click();
        return new KPAUISearchResultsPage(driver);
    }

    /** Opens the 'Last' Link from the Bottom Pagination Bar
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage openBottomPaginationLastLink(){
        getPaginationLast().get(1).click();
        return new KPAUISearchResultsPage(driver);
    }

    /** Opens the 'Next' Link from the Bottom Pagination Bar
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage openBottomPaginationNextLink(){
        getPaginationNext().get(1).click();
        return new KPAUISearchResultsPage(driver);
    }

    /** Opens the 'Previous' Link from the Bottom Pagination Bar
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage openBottomPaginationPreviousLink(){
        getPaginationPrevious().get(1).click();
        return new KPAUISearchResultsPage(driver);
    }

    /** Opens the Care Options page from the Spotlight Tab when 'urgent' is queried
     * @return - KPAUICareOptionsPage
     */
    public KPAUICareOptionsPage openCareOptionsFromSpotLight() {
        getSpotlightFirstLink().click();
        return new KPAUICareOptionsPage(driver);
    }

    /** Opens the 'First' Link from the Top Pagination Bar
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage openTopPaginationFirstLink(){
        getPaginationFirst().get(0).click();
        return new KPAUISearchResultsPage(driver);
    }

    /** Opens the 'Last' Link from the Top Pagination Bar
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage openTopPaginationLastLink(){
        getPaginationLast().get(0).click();
        return new KPAUISearchResultsPage(driver);
    }

    /** Opens the 'Next' Link from the Top Pagination Bar
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage openTopPaginationNextLink(){
        System.out.println("this" + getPaginationNext().size());
        getPaginationNext().get(0).click();
        System.out.println("made it here");
        return new KPAUISearchResultsPage(driver);
    }

    /** Use the search bar on the Search Results Page to make another search
     * @param searchString - The String you would like to search for
     * @return - New KPAUISearchResultsPage
     */
    public KPAUISearchResultsPage searchFromResultsPage(String searchString){
        clearField(getSearchField());
        getSearchField().sendKeys(searchString);
        getSearchButton().click();
        return new KPAUISearchResultsPage(driver);
    }

    /** Verifies that the Spotlight Tab displays when it should and does not when it
     * @param searchResultsPage
     * @param spotlightTabExpected
     * @return
     */
    public static boolean verifySearchResultsSpotlightTabDisplays(KPAUISearchResultsPage searchResultsPage,
                                                                  boolean spotlightTabExpected){
        if (spotlightTabExpected)
            return searchResultsPage.getSpotlightFirstLink().isDisplayed();
        else
            try { return !searchResultsPage.getSpotlightFirstLink().isDisplayed();
        } catch(Exception ex){return true;}
    }
}
