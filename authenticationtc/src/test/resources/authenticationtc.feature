@loginForm
Feature: Authentication to the application
  Authentication form for a regular user
  Authenticated users can see the account details such as name, surname, email address and mailing address
  Only registered users can authenticate to the application

  Background:
    Given user is on the login page
    And user is not authenticated

  Scenario: Successful authentication with valid credentials in both of authentication fields
    Given user with email is registered in the application "example_email@domain.com"
    When user enters valid credentials
      | loginwith-exactly-60-characters@have60characters.thatissixty | password            |
      | user-loginwith59characters@have59characters.thatisfiftynine  | example_password    |
      | firstname.lastname@domain.com                                | some_other_password |
      | email@domain.com                                             | some_password       |
      | email@subdomain.domain.com                                   | password            |
      | firstname+lastname@domain.com                                | some_password       |
      | email@123.123.123.123                                        | 123$_password       |
      | "email"@domain.com                                           | passwordXYZ         |
      | 1234567890@domain.com                                        | _password?123       |
      | email@domain-one.com                                         | %password0.AWSD-key |
      | _______@domain.com                                           | password+#1         |
      | email@domain.name                                            | xyz_password        |
      | email@domain.co.jp                                           | pretty_password     |
      | firstname-lastname@domain.com                                | ugly_password       |
      | a@b.pl                                                       | example_password    |
    And clicks the 'Log In' button
    Then user is redirected to the page with an account details view

  Scenario Outline: Unsuccessful authentication with valid login or none login and invalid password or none password
    Given user with email is registered in the application "example_email@domain.com"
    When user enters "<login>"
    And user enters "<password>"
    And clicks the 'Log in' button
    Then 'Authentication failed. Login or password are incorrect' message should be displayed
    Examples:
      | login            | password            |
      | email@domain.com | some_wrong_password |
      |                  | empty_login         |
      | empty@pass.pl    |                     |

  Scenario: Unsuccessful authentication due to submit blank form
    Given user with email is registered in the application "example_email@domain.com"
    When user enters no login
    And user enters no password
    And clicks the 'Log in' button
    Then 'Login and password are required' message should be displayed

  Scenario: Unsuccessful authentication due to unauthorized entry
    Given user is not registered
    When user enters any login
    And user enters any password
    Then 'Authentication failed. Login or password are incorrect' message should be displayed

  Scenario Outline: Unsuccessful authentication with an invalid login (missing @ sign or a fully domain name and case with an incorrect number of characters)
    Given user with email is registered in the application "example_email@domain.com"
    When user enters an invalid "<login>"
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
      | a@                           |
    And user enters any "<password>"
    And clicks the 'Log in' button
    Then 'Authentication failed. Login or password are incorrect' message should be displayed
    Then user can see "<expected_error_message>"
    Examples:
      | login                                                         | password      | expected_error_message                                                  |
      | loginlonger-than-60-characters@have61characters.morethansixty | some_password | Invalid login. Valid login should have email format up to 60 characters |
