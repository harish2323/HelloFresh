$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("HelloFresh.feature");
formatter.feature({
  "line": 2,
  "name": "First test",
  "description": "",
  "id": "first-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@HelloFresh"
    }
  ]
});
formatter.scenarioOutline({
  "line": 21,
  "name": "Login functionality is tested",
  "description": "",
  "id": "first-test;login-functionality-is-tested",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 20,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "I load the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "I click the sign in link",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I login with \u003cEmail\u003e,\u003cPassword\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I verify login is successful \u003cName\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 27,
  "name": "",
  "description": "",
  "id": "first-test;login-functionality-is-tested;",
  "rows": [
    {
      "cells": [
        "Email",
        "Password",
        "Name"
      ],
      "line": 28,
      "id": "first-test;login-functionality-is-tested;;1"
    },
    {
      "cells": [
        "hf_challenge_123456@hf12345.com",
        "12345678",
        "Joe Black"
      ],
      "line": 29,
      "id": "first-test;login-functionality-is-tested;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1943980,
  "status": "passed"
});
formatter.before({
  "duration": 26205842809,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Login functionality is tested",
  "description": "",
  "id": "first-test;login-functionality-is-tested;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 20,
      "name": "@Login"
    },
    {
      "line": 1,
      "name": "@HelloFresh"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "I load the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "I click the sign in link",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I login with hf_challenge_123456@hf12345.com,12345678",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I verify login is successful Joe Black",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "HelloFreshSteps.I_load_the_home_page()"
});
formatter.result({
  "duration": 2274268517,
  "status": "passed"
});
formatter.match({
  "location": "HelloFreshSteps.I_click_the_sign_in_link()"
});
formatter.result({
  "duration": 3960487686,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "hf_challenge_123456@hf12345.com",
      "offset": 13
    },
    {
      "val": "12345678",
      "offset": 45
    }
  ],
  "location": "HelloFreshSteps.I_login_with_email_password(String,String)"
});
formatter.result({
  "duration": 3701842254,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Joe Black",
      "offset": 29
    }
  ],
  "location": "HelloFreshSteps.I_verify_login_successful(String)"
});
formatter.result({
  "duration": 350104897,
  "status": "passed"
});
formatter.after({
  "duration": 2013828828,
  "status": "passed"
});
});