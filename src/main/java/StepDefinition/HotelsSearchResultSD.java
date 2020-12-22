package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HotelsSearchResult;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HotelsSearchResultSD {

     HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();



    @Then("^I verify system displays all hotels within \"([^\"]*)\" Km radius of airport$")
    public void i_verify_system_displays_all_hotels_within_something_km_radius_of_airport(String distStr)
   {
    Double expectedDist = Double.parseDouble(distStr);   // 15
     ArrayList<Double> distList =     hotelsSearchResult.getAirportDistList();
     System.out.println(distList);
       boolean flag=true;

     for(int i=0;i<distList.size();i++)
     {
         if(distList.get(i)>expectedDist)
         {
              flag = false;
              System.out.println(distList.get(i));
              break;
         }
     }
       Assert.assertTrue("some distances are greater than:"+expectedDist,flag);
   }


    @And("^I verify \"([^\"]*)\" is within radius$")
    public void i_verify_something_is_within_radius(String hotelName)
             {
// print the hotel list

   ArrayList<String> hotelList= hotelsSearchResult.getHotelList();

   boolean result = true;
                 for (String hotel:hotelList) {
                     System.out.println(hotel);

                     result = hotel.contains(hotelName);
                 }

                 Assert.assertTrue(hotelName+":this hotel is absent in th seach result:"
                         ,result);

             }



    @Then("^I verify todays deal is less than \"([^\"]*)\" rs$")
    public void i_verify_todays_deal_is_less_than_something_rs(String dealPriceStr) {

        int expectedDealPrice = Integer.parseInt(dealPriceStr);

        SharedSD.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        hotelsSearchResult.clikStarRatings("4");

        SharedSD.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        int actualDealPrice = hotelsSearchResult.getDealPrice();

        System.out.println(actualDealPrice);

    }

}
