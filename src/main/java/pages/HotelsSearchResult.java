package pages;

import StepDefinition.SharedSD;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HotelsSearchResult extends  BasePage{

    By starRatings = By.xpath("//span[contains(@class,'star-rating-text')]");

    public ArrayList<String> getStarList()
    {
        return  getElementTextList(starRatings);
    }


    public void clikStarRatings(String star)
    {
        SharedSD.getDriver()
                .findElement(By.xpath("//input[@id='f-star-rating-"+star+"']"))
                .click();

        SharedSD.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
