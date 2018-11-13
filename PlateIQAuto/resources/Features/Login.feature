@Login
Feature: Logging into PlateIQ
  
  @Login
  Scenario: Test the login functionality.
    Given I launch the PlateIQ application 
   	And I Login inside application
   	|prashanth-test@test.plateiq.com| piqtest123|
   	Then I verify the text as "Welcome to Plate IQ, Prashanth." in login page
   