Feature:
  @Skip
  Scenario: Сheck 1the logs are displayed
    Given I open JDI GitHub site
    And I login as user "Roman" with password "Jdi1234"
    And I click on "Service" button in Header
    And I open Different Elements Page
    When I select checkbox Water
    And  I select checkbox Wind
    And  I select radio button Selen
    And  I select color from dropdown menu
    Then Log entry matche to checkbox Water is displayed
    And Log entry matche to checkbox Wind is displayed
    And Log entry match to radio button Selen is displayed
    And Log entry match color Yellow is displayed
