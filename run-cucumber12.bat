@echo off
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17.0.17.10-hotspot
set PATH=%JAVA_HOME%\bin;%PATH%

echo Running Cucumber tests for Homework12...
echo Creating target directory if it doesn't exist...
if not exist "target\cucumber-reports" mkdir "target\cucumber-reports"

echo Running tests...
java -cp "src\test\java;src\main\java;C:\Users\User-2022\.m2\repository\io\cucumber\cucumber-testng\7.31.0\cucumber-testng-7.31.0.jar;C:\Users\User-2022\.m2\repository\io\cucumber\cucumber-java\7.31.0\cucumber-java-7.31.0.jar;C:\Users\User-2022\.m2\repository\org\testng\testng\7.11.0\testng-7.11.0.jar;C:\Users\User-2022\.m2\repository\com\beust\jcommander\1.82\jcommander-1.82.jar;C:\Users\User-2022\.m2\repository\org\webjars\jquery\3.6.1\jquery-3.6.1.jar;C:\Users\User-2022\.m2\repository\io\cucumber\cucumber-core\7.31.0\cucumber-core-7.31.0.jar;C:\Users\User-2022\.m2\repository\io\cucumber\cucumber-plugin\7.31.0\cucumber-plugin-7.31.0.jar;C:\Users\User-2022\.m2\repository\io\cucumber\cucumber-gherkin\26.2.0\cucumber-gherkin-26.2.0.jar;C:\Users\User-2022\.m2\repository\io\cucumber\cucumber-html\7.31.0\cucumber-html-7.31.0.jar;C:\Users\User-2022\.m2\repository\io\cucumber\cucumber-junit\7.31.0\cucumber-junit-7.31.0.jar;C:\Users\User-2022\.m2\repository\io\cucumber\cucumber-junit-platform-engine\7.31.0\cucumber-junit-platform-engine-7.31.0.jar;C:\Users\User-2022\.m2\repository\io\cucumber\cucumber-expressions\16.1.1\cucumber-expressions-16.1.1.jar;C:\Users\User-2022\.m2\repository\io\cucumber\datatable\7.31.0\datatable-7.31.0.jar;C:\Users\User-2022\.m2\repository\io\cucumber\cucumber-testng\7.31.0\cucumber-testng-7.31.0.jar;C:\Users\User-2022\.m2\repository\io\cucumber\cucumber-java\7.31.0\cucumber-java-7.31.0.jar;C:\Users\User-2022\.m2\repository\org\testng\testng\7.11.0\testng-7.11.0.jar;C:\Users\User-2022\.m2\repository\org\seleniumhq\selenium\selenium-java\4.37.0\selenium-java-4.37.0.jar;C:\Users\User-2022\.m2\repository\org\seleniumhq\selenium\selenium-chrome-driver\4.37.0\selenium-chrome-driver-4.37.0.jar;C:\Users\User-2022\.m2\repository\org\seleniumhq\selenium\selenium-api\4.37.0\selenium-api-4.37.0.jar;C:\Users\User-2022\.m2\repository\org\seleniumhq\selenium\selenium-support\4.37.0\selenium-support-4.37.0.jar" org.testng.TestNG testng.xml

echo Test execution completed.
pause