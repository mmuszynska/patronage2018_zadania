@loginForm
Feature: Authentication to the application
  Authentication form for a regular user
  Authenticated users can see the account details such as name, surname, email address and mailing address
  Only registered users can authenticate to the application

  Background:
    Given user is on the login page
    And there is no authenticated user

  Scenario: Successful authentication with valid credentials in both of authentication fields
    Given user is registered
      | email@domain.com | some_password |
    When user enters valid credentials
      | firstname.lastname@domain.com | some_other_password |
      | email@domain.com              | some_password       |
      | email@subdomain.domain.com    | password            |
      | firstname+lastname@domain.com | some_password       |
      | email@123.123.123.123         | 123$_password       |
      | "email"@domain.com            | passwordXYZ         |
      | 1234567890@domain.com         | _password?123       |
      | email@domain-one.com          | %password0.AWSD-key |
      | _______@domain.com            | password+#1         |
      | email@domain.name             | xyz_password        |
      | email@domain.co.jp            | pretty_password     |
      | firstname-lastname@domain.com | ugly_password       |
    And clicks the 'Log In' button
    Then user is redirected to the page with an account details view

  Scenario: Unsuccessful authentication with valid login and invalid password or none password
    Given user is registered
      | email@domain.com | some_password |
    When user enters the correct login
    And user enters the wrong password or none password
      | some_wrong_password |
      |                     |
    And clicks the 'Log in' button
    Then 'Authentication failed. Login or password are incorrect' message should be displayed

  Scenario: Unsuccessful authentication with enter none credentials in both of authentication fields
    Given user is registered
      | email@domain.com | some_password |
    When user enters no login
      |  |
    And user enters no password
      |  |
    And clicks the 'Log in' button
    Then 'Authentication failed. Login or password are incorrect' message should be displayed

  Scenario: Unsuccessful authentication due to unauthorized entry
    Given user is not registered
    When user enters any login
    And user enters any password
    Then 'Authentication failed. Login or password are incorrect' message should be displayed

  Scenario: Unsuccessful authentication with an invalid login (missing @ sign or a fully domain name and other reasons)
    Given user is registered
      | email@domain.com | some_password |
    When user enters an invalid login
      | Joe Smith <email@domain.com> |
      | email.domain.com             |
      | email@domain@domain.com      |
      | .email@domain.com            |
      | email.@domain.com            |
      | email..email@domain.com      |
      | あいうえお@domain.com             |
      | email@domain.com (Joe Smith) |
      | email@domain                 |
      | email@-domain.com            |
      | email@domain.web             |
      | email@111.222.333.44444      |
      | email@domain..com            |
      | @domain.com                  |
      | #@%^%#$@#$@#.com             |
      | plainaddress                 |
    And user enters any password
    And clicks the 'Log in' button
    Then some relevant validation message should be displayed

  Scenario Outline: Authentication with a valid number of characters in the login field
    Given user is registered
      | email@domain.com | some_password |
    When user enters a valid "<number of characters>" in the login field
    Then the "<expected outcome>" is 'System should accept'
    And user is redirected to the page with an account details view
    Examples:
      | number of characters                                         | expected outcome     |
      | loginwith-exactly-60-characters@have60characters.thatissixty | system should accept |
      | user-loginwith59characters@have59characters.thatisfiftynine  | system should accept |
      | a@b                                                          | system should accept |
      | a@bc                                                         | system should accept |

  Scenario Outline: Authentication with an invalid number of characters in the login field
    Given user is registered
      | email@domain.com | some_password |
    When user enters an invalid "<number of characters>" in the login field
    Then the "<expected outcome>" is 'System should not accept'
    And some relevant validation message should be displayed
    Examples:
      | number of characters                                          | expected outcome         |
      | loginlonger-than-60-characters@have61characters.morethansixty | system should not accept |
      | a@                                                            | system should not accept |