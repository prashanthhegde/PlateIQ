@AllDocuments
Feature: Test opening an invoice in the All documents tab and marking as Not Exported
  
  @AllDocuments
  Scenario Outline: Test opening an invoice and marking as exported
    Given I launch the PlateIQ application
   	And I Login inside application
   	|prashanth-test@test.plateiq.com| piqtest123|
   	Then I verify the text as "Welcome to Plate IQ, Prashanth." in login page
    And I click on the invoices button
    Then verify the invoices <Tabs>
   	And  User clicks on first links in all documents
   	Then verify if link is opened and More dropdown exists
   	Then User clicks on mark as  not exported and validate absence of exported status
    Examples: 
     |Tabs 			  |
     |Needs Attention,Pending Export,Other Documents,All Documents|