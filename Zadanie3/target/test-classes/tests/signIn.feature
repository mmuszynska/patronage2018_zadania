@test@signIn
Feature: Authentication to the application
  Authentication form for a regular user
  Authenticated users can see the personal information such as first name, last name, email address and date of birth
  Only registered users can authenticate to the application

  Background:
    Given user is not authenticated
    And user is on the main page

  Scenario Outline: Successful authentication with valid credentials
    Given user is registered in the application with valid login and password
    When user clicks 'Sign in' button
    And user enters login "<login>"
    And user enters password "<password>"
    And submit form with the 'Sign in' button
    Then user is redirected to 'My account page'
    When user clicks 'My personal information'
    Then user can see the correct data such as first name, last name, email address and date of birth
    Examples:
      | login                         | password     |
      | firstname.lastname@domain.com | xyz_password |

  Scenario Outline: Unsuccessful authentication with invalid credentials
    When user clicks 'Sign in' button
    And user enters login "<login>"
    And user enters password "<password>"
    And submit form with the 'Sign in' button
    Then user can see relevant validation message: "<error_message>"
    Examples:
      | login                         | password     | error_message              |
      | firstname.lastname@           | xyz_password | Invalid email address.     |
      | firstname.lastname@domain.com | wrong_pass   | Authentication failed.     |
      | tooshort@pass.com             | pass         | Invalid password.          |
      | empty@pass.pl                 |              | Password is required.      |
      |                               | empty_login  | An email address required. |
      | unregistered_email@domain.com | xyz_password | Authentication failed.     |