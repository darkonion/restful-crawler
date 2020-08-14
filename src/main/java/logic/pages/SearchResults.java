package logic.pages;

import logic.WaitUtil;
import model.Hotel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingDouble;
import static logic.WaitUtil.waitUntil;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SearchResults {

    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='product-long-item-wrapper']")
    private WebElement mainProductWrapper;

    @FindBy(xpath = "//div[@class='product-long-item-wrapper']/div")
    private List<WebElement> productWrappers;


    public SearchResults(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public List<Hotel> getHotelList() {
        List<Hotel> hotels = new ArrayList<>();

        waitUntil(visibilityOf(mainProductWrapper), driver);

        //iterating through results list
        productWrappers.forEach(p -> {
            List<WebElement> title = p.findElements(xpath(".//h5/a"));
            List<WebElement> price = p.findElements(xpath(".//div[@class='price']/span"));
            List<WebElement> score = p.findElements(xpath(".//p[contains(@class,'rating-text')]/span[@class='bg-primary']"));

            //check if every result is complete and ready to map into object
            if (!title.isEmpty() && !price.isEmpty() && !score.isEmpty()) {
                hotels.add(Hotel.builder()
                                .name(title.get(0).getText())
                                .price(price.get(0).getText())
                                .score(Double.parseDouble(score.get(0).getText()))
                                .build());
            }
        });
        hotels.sort(comparingDouble(Hotel::getScore).reversed());
        return hotels;
    }
}
