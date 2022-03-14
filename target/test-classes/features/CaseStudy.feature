Feature: Case Study Scenario

Scenario: Add a items to cart
    Given Login into App
    When Add an item to cart
    Then Items must be added to cart
    
    Scenario: Delete an Item
    Given Login into App
    When List of Items should be available in cart
    Then Delete an item from Cart


Scenario: Place Order
    Given Login into App
    And Items should be available in Cart
    When Place Order
    Then Purchase Items

 