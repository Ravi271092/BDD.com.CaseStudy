@PhaseTwo
Feature: Deals Functionality

@RegressionTest
Scenario: Create new Deals
Given User is logged in
When User create a new Deals

@SmokeTest
Scenario: View Deals details
Given User is logged in
When User view Deals details

Scenario: Edit Deals details
Given User is logged in
When User edit Deals details


