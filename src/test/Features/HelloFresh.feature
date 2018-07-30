@HelloFresh
Feature: First test

  @Signup
  Scenario Outline: Signin functionality is tested
    Given I load the home page
    And I click the sign in link
    And I enter email and click the create account button
    And I enter personal details <Salutation>,<Firstname>,<Lastname>,<Password>,<Day>,<Month>,<Year>
    And I enter address details <Company>,<City>,<State>,<Postcode>
    And I click the register button
    Then I verify registration is successful <Firstname>,<Lastname>


  Examples:
    |Salutation | Firstname | Lastname | Password  | Day | Month  | Year | Company   | City   | State   | Postcode |
    |Mrs.       | Magdalena | Kyrios   | Australia | 19  | October| 1983 | HelloFresh| NewYork| Colorado| 12345    |


  @Login
  Scenario Outline: Login functionality is tested
    Given I load the home page
    And I click the sign in link
    And I login with <Email>,<Password>
    Then I verify login is successful <Name>

    Examples:
    |Email                           | Password | Name      |
    |hf_challenge_123456@hf12345.com | 12345678 | Joe Black |

  @Checkout
  Scenario Outline: Checkout functionality is tested
    Given I load the home page
    And I click the sign in link
    And I login with <Email>,<Password>
    And I click the women tab
    And I select the product <Product>
    And I click add to cart
    And I click proceed to checkout
    And I click pay by wire
    And I click confirm order
    And I verify order is successful


    Examples:
      |Email                           | Password | Name      | Product                     |
      |hf_challenge_123456@hf12345.com | 12345678 | Joe Black | Faded Short Sleeve T-shirts |