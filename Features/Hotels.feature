Feature: Hotels.com website testing

  Background: opening the web page
    Given I am on hotels.com home page

# 1
  @starVerify
  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default locations search result screen
    When I select property class <stars>
    Then I verify system displays only <stars> hotels on search result
    Examples:
      | stars   |
      | 5 stars |
   #   | 4 stars |
   #   | 3 stars |

#2
  @verifyDist
  Scenario: List of all of hotel within 6 km radius of airport
    Given I am on default locations search result screen
   # Then I verify system displays all hotels within "25" Km radius of airport
    And I verify "Hyatt" is within radius


#3
  @verifyDeal
  Scenario: Verify todays deal price value
    Given I am on default locations search result screen
    Then I verify todays deal is less than "1000" rs
    # consider first hotels price as todays deal

#4
  @verify
  Scenario Outline: Verify room count dropdown
  #  Given I am on hotels.com home page
    When I select <select_rooms> from room dropdown
    Then I verify <number_of_room_dropdown> is displayed

    Examples:
      |select_rooms           | number_of_room_dropdown             |
      | 2                     | 2              			            |
      | 5                     | 5               			        |
      | 9+                    | 0                   			    |