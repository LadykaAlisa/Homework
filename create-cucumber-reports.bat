@echo off
echo Creating dummy Cucumber JSON reports for testing...
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17.0.17.10-hotspot
set PATH=%JAVA_HOME%\bin;%PATH%

if not exist "target\cucumber-reports" mkdir "target\cucumber-reports"

echo Creating cucumber12.json...
echo {"feature": [{"uri": "src/test/resources/features12/my-bdd-test.feature", "elements": [{"line": 1, "name": "Example scenario", "description": "", "id": "example-scenario", "type": "scenario", "keyword": "Scenario", "steps": [{"result": {"duration": 1000000000, "status": "passed"}, "line": 2, "name": "Given I have a step", "match": {"location": "Homework12.steps.SearchSteps.someStep()"}}, {"result": {"duration": 1000000000, "status": "passed"}, "line": 3, "name": "When I do something", "match": {"location": "Homework12.steps.SearchSteps.doSomething()"}}, {"result": {"duration": 1000000000, "status": "passed"}, "line": 4, "name": "Then I should see a result", "match": {"location": "Homework12.steps.SearchSteps.seeResult()"}}]}]}]} > target\cucumber-reports\cucumber12.json

echo Creating cucumber13.json...
echo {"feature": [{"uri": "src/test/resources/features13/my-universal-test-for-write-in-bdd-devices.feature", "elements": [{"line": 1, "name": "Example scenario", "description": "", "id": "example-scenario", "type": "scenario", "keyword": "Scenario", "steps": [{"result": {"duration": 1000000000, "status": "passed"}, "line": 2, "name": "Given I have a step", "match": {"location": "Homework13.steps.steps.SearchSteps2.someStep()"}}, {"result": {"duration": 1000000000, "status": "passed"}, "line": 3, "name": "When I do something", "match": {"location": "Homework13.steps.steps.SearchSteps2.doSomething()"}}, {"result": {"duration": 1000000000, "status": "passed"}, "line": 4, "name": "Then I should see a result", "match": {"location": "Homework13.steps.steps.SearchSteps2.seeResult()"}}]}]}]} > target\cucumber-reports\cucumber13.json

echo Creating cucumber15.json...
echo {"feature": [{"uri": "src/test/resources/features13/my-universal-test-for-write-in-bdd-devices.feature", "elements": [{"line": 1, "name": "Example scenario", "description": "", "id": "example-scenario", "type": "scenario", "keyword": "Scenario", "steps": [{"result": {"duration": 1000000000, "status": "passed"}, "line": 2, "name": "Given I have a step", "match": {"location": "Homework13.steps.steps.SearchSteps2.someStep()"}}, {"result": {"duration": 1000000000, "status": "passed"}, "line": 3, "name": "When I do something", "match": {"location": "Homework13.steps.steps.SearchSteps2.doSomething()"}}, {"result": {"duration": 1000000000, "status": "passed"}, "line": 4, "name": "Then I should see a result", "match": {"location": "Homework13.steps.steps.SearchSteps2.seeResult()"}}]}]}]} > target\cucumber-reports\cucumber15.json

echo Dummy JSON reports created successfully!
pause