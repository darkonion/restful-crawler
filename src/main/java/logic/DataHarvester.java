package logic;

import config.WebDriverConfig;
import logic.pages.HomePage;
import logic.pages.SearchResults;
import model.Hotel;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DataHarvester {

    private final String remoteAddress;
    private final String SITE_ADDRESS = "https://www.phptravels.net/home";

    public DataHarvester(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public List<Hotel> getHotels(String query) {
        WebDriver driver = WebDriverConfig.getDriver(remoteAddress);
        List<Hotel> hotels;

        try {
            driver.get(SITE_ADDRESS);
            new HomePage(driver)
                    .inputQuery(query)
                    .processSearch();
            hotels = new SearchResults(driver).getHotelList();
        } finally {
            driver.quit();
        }

        return hotels;
    }
}
