package page;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HomePage {
	
	private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By searchBox = By.id("ybar-sbq");
    private By autoSuggestFirstEntry =By.cssSelector("ul.modules-module_list__hi5kT li[data-test='srch-sym']");
     


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // Initialize explicit wait
    }

    // Enter stock symbol in the search box
    public void searchStock(String stockSymbol) {
        WebElement searchBoxElement = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBoxElement.sendKeys(stockSymbol);
    }

    // Click on the first autosuggest entry
    public void clickFirstAutoSuggestEntry() {
        WebElement suggestionElement = wait.until(ExpectedConditions.elementToBeClickable(autoSuggestFirstEntry));
        suggestionElement.click();
    }

    // Verify first autosuggest entry text
    public String getFirstAutoSuggestText() {
        WebElement suggestionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(autoSuggestFirstEntry));
        return suggestionElement.getText();
    }
}