# HelloFresh

The framework uses cucumber for BDD scenarios and java(selenium) to define the steps. The tests can be run in firefox or chrome.


Run the tests from command line with the following commands ( make sure the current folder is qa-test-hf) :

1) run just the ui tests :
>mvn test -Dcucumber.options="--tags @HelloFresh" -DBROWSER="chrome" -P dev

The test will be run in chrome. and the url will be used from the "dev" profile from pom file. the url from "dev" will be loaded. there is also
a "qa" profile. Currently only dev has a valid url.

2) run just the api tests :
>mvn test -Dcucumber.options="--tags @HelloFreshAPI" -P dev

3) run tests based on tags :
>mvn test -Dcucumber.options="--tags @Login" -DBROWSER="firefox" -P dev
this will run the test in firefox browser.

4) run all the tests :
>mvn test -DBROWSER="chrome" -P de


Results :
The html results will be stored in reports folder. Screenshots would be embedded for failed tests.
