@Invoicescenario
Feature: Test opening an invoice and marking as exported
  
  @Invoicescenario
  Scenario Outline: Test opening an invoice and marking as exported
    Given I launch the PlateIQ application
   	And I Login inside application
   	|prashanth-test@test.plateiq.com| piqtest123|
   	Then I verify the text as "Welcome to Plate IQ, Prashanth." in login page
    And I click on the invoices button
    Then verify the invoices <Tabs>
   	And  User clicks on first links in needs attention
   	Then verify if link is opened and More dropdown exists
   	Then User clicks on mark as exported and validate exported text
   	
    Examples: 
     |Tabs 			  |
     |Needs Attention,Pending Export,Other Documents,All Documents|