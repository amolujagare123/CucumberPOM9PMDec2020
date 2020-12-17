package pages;

import org.openqa.selenium.By;

public class DarkSkyLogin  extends  DarkSkyAPI{

    By loginButton = By.xpath("//button[@type='submit']");

    public void clickLoginButton()
    {
        clickOn(loginButton);
    }
}
