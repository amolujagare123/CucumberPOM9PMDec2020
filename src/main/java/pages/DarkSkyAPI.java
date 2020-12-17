package pages;

import org.openqa.selenium.By;

public class DarkSkyAPI extends  DarkSkyHome{
    By loginLnk = By.xpath("//a[@class='button']");

    public void clickLoginLink()
    {
        clickOn(loginLnk);
    }

}
