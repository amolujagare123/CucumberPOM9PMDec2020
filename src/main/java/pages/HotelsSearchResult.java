package pages;

import StepDefinition.SharedSD;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HotelsSearchResult extends  BasePage{

    By starRatings = By.xpath("//span[contains(@class,'star-rating-text')]");

    By airportDistTextList = By.xpath("//ul[@class='property-landmarks']/li[2]");

    By hotelList =By.xpath("//a[@class='property-name-link']");


    By dealPriceRaw = By.xpath("//aside[@class='pricing resp-module']//ins");
  //By dealPriceRaw = By.xpath("//div[@class='price']");


   By roomDropDown = By.xpath("//select[@id='qf-0q-rooms']");

   By roomDropDownCounts = By.xpath("//div[@class='widget-query-people']");

   public int getRoomDropDownCounts()
   {
       return SharedSD.getDriver().findElements(roomDropDownCounts).size();
   }


   public void setRooms(String rooms)
   {
       selectFromDropdown(roomDropDown,rooms);
   }


    public int getDealPrice()
    {
        String priceRaw = getTextFromElement(dealPriceRaw);

        String priceWithoutRS = priceRaw.substring(2); //  2,498

        String priceWithoutCommaStr ="";


        for(int i=0;i<priceWithoutRS.length();i++)
        {
            if(priceWithoutRS.charAt(i)!=',')
            {
                priceWithoutCommaStr =priceWithoutCommaStr +priceWithoutRS.charAt(i);
            }

        }

        int price = Integer.parseInt(priceWithoutCommaStr); // int ->  2498


        return  price;
    }


    public ArrayList<String> getHotelList()
    {
        return  getElementTextList(hotelList);
    }


    public ArrayList<Double> getAirportDistList()
    {
       ArrayList<String> distListRow =  getElementTextList(airportDistTextList);
        ArrayList<Double> distList = new ArrayList<>();

       for(int i=0;i<distListRow.size();i++)
       {
           //4.9 km to Chhatrapati Shivaji International Airport (BOM)
           String distStr = distListRow.get(i).split(" ")[0];
           double dist = Double.parseDouble(distStr);

           distList.add(dist);
       }

       return distList;

    }



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
