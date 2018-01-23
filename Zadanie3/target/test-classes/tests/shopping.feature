@test@shopping
Feature: Possibility to buy sth from the Internet shop
  Authenticated users can buy sth from the Internet shop using a bank wire or a check

  Background:
    Given user is not authenticated
    And user is on the main page

  Scenario: User can order sth and select payment by bank wire
    Given user is registered and logged in to the application
    When user clicks 'Home' button
    When user provides search phase
    Then user should see search results
    When user adds to cart first item on the page
    Then user can see 'there is an item added to cart' message
    And user proceeds to checkout
    And user proceeds from summary to checkout
    And user proceeds from address to checkout
    And user agrees to TOS
    And user proceeds from shipping to checkout
    And user selects 'Pay by bank wire' payment method
    And user confirms an order
    And user clicks 'Back to orders'
    Then user is redirected to the order history
    When user clicks 'Details'
    Then user can see details of his orders

  Scenario: User can order sth and select payment by cheque
    Given user is registered and logged in to the application
    When user clicks 'Home' button
    When user provides search phase
    Then user should see search results
    When user adds to cart first item on the page
    And user proceeds to checkout
    And user proceeds from summary to checkout
    And user proceeds from address to checkout
    And user agrees to TOS
    And user proceeds from shipping to checkout
    And user selects 'Pay by cheque' payment method
    And user confirms an order
    And user clicks 'Back to orders'
    Then user is redirected to the order history
    When user clicks 'Details'
    Then user can see details of his orders