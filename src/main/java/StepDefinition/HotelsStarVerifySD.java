package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HotelsHome;
import pages.HotelsSearchResult;

import java.util.ArrayList;
import java.util.Collections;

public class HotelsStarVerifySD {

    HotelsHome hotelsHome = new HotelsHome();
    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Given("^I am on hotels.com home page$")
    public void i_am_on_hotelscom_home_page() throws Throwable {
        Assert.assertEquals("This is not a Hotels.com home page",
                "Hotels.com India"
                ,SharedSD.getDriver().getTitle()
        );
    }

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {

        hotelsHome.setDestination("Mumbai, Maharashtra, India");
        hotelsHome.clickSearch();


    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars)
    {

        // stars = "5 stars"

        hotelsSearchResult.clikStarRatings(stars.split(" ")[0]);

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {
        // stars = "5 stars" z| 5-star

        String expected = stars.split(" ")[0]+"-star"; // 5-star

        ArrayList<String> starList = hotelsSearchResult.getStarList();
        System.out.println(stars);
        System.out.println(starList);

        int occarance = Collections.frequency(starList,expected);
        int size = starList.size();

      boolean result =   occarance == size;

      Assert.assertTrue("all the stars are not equal",result);


    }

}
