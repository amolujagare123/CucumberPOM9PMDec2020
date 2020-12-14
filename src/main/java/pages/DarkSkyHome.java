package pages;

import org.openqa.selenium.By;

public class DarkSkyHome extends BasePage{


    By curTempRow = By.xpath("//span[@class='summary swap']");
 //54˚ Clear.

By timeLineTemRow = By.xpath("//span[@class='first']//span");//55°


    public int getCurrentTemp() // -> 54 in int
    {
        String tempRow  =  getTextFromElement(curTempRow); //54˚ Clear.

        String temp = tempRow.split("˚")[0]; //==> {"54","Clear."}

        return  Integer.parseInt(temp);
    }

    public int getTimelineTemp() // -> 55 in int
    {
        String tempRow  =  getTextFromElement(timeLineTemRow); //55°

        String temp = tempRow.split("°")[0]; //==> {"55"}

        return  Integer.parseInt(temp);
    }


}
