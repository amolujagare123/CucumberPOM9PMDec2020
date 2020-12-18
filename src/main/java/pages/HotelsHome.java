package pages;

import StepDefinition.SharedSD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HotelsHome extends BasePage{

    By destinationTxt = By.xpath("//input[@id='qf-0q-destination']");

    By searchButton = By.xpath("//button[@type='submit']");


    public void setDestination(String destination)
    {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("arguments[0].setAttribute('value','"+destination+"')",
                SharedSD.getDriver().findElement(destinationTxt));
    }


    public void clickSearch()
    {
        clickOn(searchButton);
    }

}
