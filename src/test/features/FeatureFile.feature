Feature: Verify features on BBC sports page

  Scenario: Output all team names with a match today.

    Given User is on Score & Fixture page
    Then I will record all the teams names who is playing today

  Scenario: Output of first heading and the last heading of articles related to ‘sports’.

    Given User is on Score & Fixture page
    When User enter sports in the search box
    And click on Search
    Then first and last heading should be displayed

  Scenario Outline: Verify negative scenario of sign in feature

    Given User is on Score & Fixture page
    When User click on sign In
    And Enter an incorrect <username> and <password>
    And Click on sign in button
    Then Error <expected result> should be displayed

    Examples:
      | username              | password  | expected result                                                                                       |
      | jillulislam@yahoo.com | test013   | Sorry, that password is too short                                                                     |
      | jillulislam@yahoo.com | 12345675  | Sorry, that password isn't valid                                                                      |
      | jillulislam@yahoo.com | abcderghj | Sorry, that password isn't valid                                                                      |
      | test1@yahoo.com       | abcd12345 | Sorry, we can’t find an account with that email. You can register for a new account or get help here. |
      |                       |           | Something's missing                                                                                   |
      | jillulislam@yahoo.com |           | Something's missing                                                                                   |
      |                       | abcd12345 | Sorry, those details don't match                                                                      |


