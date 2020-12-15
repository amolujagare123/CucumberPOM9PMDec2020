package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkSkyHome;

import java.util.ArrayList;
import java.util.Collections;

public class DarkSkySD {

    DarkSkyHome darkSkyHome = new DarkSkyHome();

    @Given("^I am on Darksky Home Page$")
    public void i_am_on_darksky_home_page() throws Throwable {

        Assert.assertEquals("This is not a darkSky home page",
                "Dark Sky - Sansad Marg, New Delhi, Delhi"
                     ,SharedSD.getDriver().getTitle()
                );
    }

    @Then("^I verify current temp is equal to Temperature from Daily Timeline$")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline()
             {

                 int expected = darkSkyHome.getCurrentTemp();
                 int actual = darkSkyHome.getTimelineTemp();

                 System.out.println("expected="+expected);
                 System.out.println("actual="+actual);

                 Assert.assertEquals("the temperatures are not same",expected,actual);
    }


    @Then("^I verify timeline is displayed with two hours incremented$")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented()
           {

             ArrayList<Integer> timeListist = darkSkyHome.getTimeList();

               ArrayList<Integer> timeDiffList = new ArrayList<>();

               for(int i=0;i<timeListist.size()-1;i++)
               {
                   int time1 = timeListist.get(i);
                   int time2 = timeListist.get(i+1);
                   int timeDiff = 0;

                   if(time2>time1)
                       timeDiff = time2 - time1;
                   if(time1>time2)
                       timeDiff = (time2 +12)- time1;

                   timeDiffList.add(timeDiff);
               }

               System.out.println(timeDiffList);

               int occurance = Collections.frequency(timeDiffList,2);
               // this method checks the occarance of the given object in the list
               int size = timeDiffList.size();

                    boolean result =  (occurance == size); // true / false

               Assert.assertTrue("All the differences are not = 2",result);


    }

    @Then("^I verify today's lowest and highest temp is displayed correctly$")
    public void i_verify_todays_lowest_and_highest_temp_is_displayed_correctly()
           {




    }

}
