@PhaseOne
Feature: Tasks Functionality

@RegressionTest
Scenario: Create new Tasks
Given User is logged in
When User create a new Tasks

@Integrationtest
Scenario: View Tasks details
Given User is logged in
When User view Tasks details

Scenario: Edit Tasks details
Given User is logged in
When User edit Tasks details


