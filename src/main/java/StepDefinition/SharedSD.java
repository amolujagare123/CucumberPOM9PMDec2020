package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static util.ConfigReader.getUrl;

public class SharedSD {
    public static WebDriver driver;

    @Before
    public void openUrl() throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(getUrl());

    }

    @After
    public  void closeBrowser()
    {
       // driver.close();
    }

    @After
    public void forFaiureScreenshot(Scenario scenario) throws IOException {
        if(scenario.isFailed())
        {
            // 1. create a refernce of an Interface  TakesScreenshot
            // assign the driver to it
            TakesScreenshot ts = (TakesScreenshot) driver;

            // 2. create object file using the method  getScreenshotAs
            byte[] scrFile = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(scrFile,"image/png","screenshot");

        }


    }

    public static  WebDriver getDriver()
    {
        return  driver;
    }
}
