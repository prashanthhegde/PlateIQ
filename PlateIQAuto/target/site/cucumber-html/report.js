$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("resources/Features/Invoice.feature");
formatter.feature({
  "name": "Test opening an invoice and marking as exported",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Invoicescenario"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Test opening an invoice and marking as exported",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Invoicescenario"
    }
  ]
});
formatter.step({
  "name": "I launch the PlateIQ application",
  "keyword": "Given "
});
formatter.step({
  "name": "I Login inside application",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "prashanth-test@test.plateiq.com",
        "piqtest123"
      ]
    }
  ]
});
formatter.step({
  "name": "I verify the text as \"Welcome to Plate IQ, Prashanth.\" in login page",
  "keyword": "Then "
});
formatter.step({
  "name": "I click on the invoices button",
  "keyword": "And "
});
formatter.step({
  "name": "verify the invoices \u003cTabs\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "User clicks on first links in needs attention",
  "keyword": "And "
});
formatter.step({
  "name": "verify if link is opened and More dropdown exists",
  "keyword": "Then "
});
formatter.step({
  "name": "User clicks on mark as exported and validate exported text",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Tabs"
      ]
    },
    {
      "cells": [
        "Needs Attention,Pending Export,Other Documents,All Documents"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Test opening an invoice and marking as exported",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Invoicescenario"
    },
    {
      "name": "@Invoicescenario"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I launch the PlateIQ application",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePage.i_launch_the_plateiq_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I Login inside application",
  "rows": [
    {
      "cells": [
        "prashanth-test@test.plateiq.com",
        "piqtest123"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "HomePage.login(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the text as \"Welcome to Plate IQ, Prashanth.\" in login page",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePage.i_verify_the_text_as_in_loginpage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the invoices button",
  "keyword": "And "
});
formatter.match({
  "location": "Invoices.click_on_the_invoices_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the invoices Needs Attention,Pending Export,Other Documents,All Documents",
  "keyword": "Then "
});
formatter.match({
  "location": "Invoices.validateTabs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on first links in needs attention",
  "keyword": "And "
});
formatter.match({
  "location": "Invoices.validation_first_link_needs_attention()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify if link is opened and More dropdown exists",
  "keyword": "Then "
});
formatter.match({
  "location": "Invoices.verfiylink()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on mark as exported and validate exported text",
  "keyword": "Then "
});
formatter.match({
  "location": "Invoices.exportandverify()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});