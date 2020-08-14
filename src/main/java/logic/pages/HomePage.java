package logic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static logic.WaitUtil.waitUntil;
import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HomePage {

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@id='s2id_autogen16']/a")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"hotels\"]/div/div/form/div/div/div[4]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input[@class='select2-input select2-focused']")
    private WebElement inputState;

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public HomePage inputQuery(String query) {
        searchField.click();
        searchInput.sendKeys(query);

        //waiting for search suggestions list to load
        waitUntil(visibilityOf(inputState), driver);
        searchInput.sendKeys(ENTER);
        return this;
    }

    public HomePage processSearch() {

        //waiting for suggestions list invisible 'cloak' to descent
        waitUntil(elementToBeClickable(searchButton), driver);
        searchButton.click();
        return this;
    }
}
