@PhaseOne
Feature: Contact Functionality

Background: User login
Given User is logged in

@RegressionTest
Scenario: Create new Contact
When User create a new contact

@SmokeTest
Scenario: View contact details
When User view contact details

Scenario: Edit contact details
When User edit contact details

@RegressionTest @SmokeTest
Scenario: User Logout
When User logout from app
