Feature:
  Authentication to the application

  Background:
    Given I am a registered user

  Scenario Outline: Successful authentication
    Given I am on the login page
    When I fill login field with <login>
    And I fill password field with <correct-password>
    And click Login button
    Then I am redirected to the page with my account details
    And I can see account details view with name, surname, email address and mailing address
    Examples:
      | login         | correct-password |
      | user1@xxx.yyy | password1        |
      | user2@xx.yy   | password2        |

  Scenario Outline: Unsuccessful authentication 1
    Given I am on the login page
    When I fill login field with <login>
    And I fill password field with <incorrect-password>
    And click Login button
    Then I am informed about an unsuccessful authentication
    Examples:
      | login         | incorrect-password |
      | user1@xxx.yyy | password0          |
      | user2@xx.yy   | 1_sjsyslndidmsuisk |

  Scenario Outline: Unsuccessful authentication 2
    Given I am on the login page
    When I fill login field with <incorrect-login>
    And I fill password field with <password>
    And click Login button
    Then I am informed about an unsuccessful authentication
    Examples:
      | incorrect-login    | password  |
      | user1@xxx          | password1 |
      | @xxx               | password2 |
      | user1@.yy          | password1 |
      | @xxx.yy            | password2 |
      | user1(...)@xxx.yyy | password1 |

# the last one is an invalid login with more than 60 characters

  Scenario: Unauthorized entry
    Given I am not logged in
    When I try to go to the dashboard page
    Then I am redirected to the login page