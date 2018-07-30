@HelloFreshAPI
Feature: Hello Fresh API Tests

  @CountryAPI
  Scenario: Country API get all and verify US , GB , DE
    Given I send the country request
    Then I verify response code is success
    And I verify US in the response
    And I verify DE in the response
    And I verify GB in the response

  @US @GB @DE
  Scenario Outline: Country API get US , DE, GB
    Given I send get country request <country>
    Then I verify response code is success
    And I verify <response> exists

    Examples:
    |country| response           |
    |US     | "alpha2_code":"US" |
    |GB     | "alpha2_code":"GB" |
    |DE     | "alpha2_code":"DE" |
    |disney | No matching country found for requested code [disney].|

  @POSTAPI
  Scenario Outline: POST API
    Given I send add country <PostRequest>
    Then I verify bad response

    Examples:
    | PostRequest                                               |
    |{name: "Test Country",alpha2_code: "TC",alpha3_code: "TCY"}|

