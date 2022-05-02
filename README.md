# SeleniumBDDNew
Description:
This project is to demonstrate the feature of cucumber BDD, selenium, testNG and maven.

To work with this project please make sure following pre-requisites are meeting
1. Java is installed and its path is added
2. Intellij Idea is installed 
3. Java is installed 
4. TestNG, Cucumber and Maven plugins are installed in intellij 
5. Apache maven path is added


To execute this project, please follow below-mentioned steps
1. Open the feature file available under src->test->resources->features
2. Select a scenario which you are willing to execute and copy the tag of it
3. Find the runner class (e.g. chrome runner) under src->test->com->anz->runners
4. Paste the tag copied in step 2 withing "" for tag field
5. Select a runner xml(e.g. chromeRunner.xml) then right click and run
6. Wait for the execution to complete
7. Refresh the target folder and you will see chromeOutput folder
8. Open the html file in the browser and analyse the report