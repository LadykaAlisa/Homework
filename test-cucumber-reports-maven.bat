@echo off
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17.0.17.10-hotspot
set PATH=%JAVA_HOME%\bin;%PATH%

echo Testing Cucumber report generation...
echo Running Maven cucumber reporting plugin...

set CLASSPATH=C:\Users\User-2022\.m2\repository\net\masterthought\maven-cucumber-reporting\5.8.2\maven-cucumber-reporting-5.8.2.jar;C:\Users\User-2022\.m2\repository\net\masterthought\cucumber-reporting\5.8.2\cucumber-reporting-5.8.2.jar;C:\Users\User-2022\.m2\repository\com\google\code\gson\gson\2.10.1\gson-2.10.1.jar;C:\Users\User-2022\.m2\repository\org\apache\commons\commons-lang3\3.14.0\commons-lang3-3.14.0.jar;C:\Users\User-2022\.m2\repository\org\freemarker\freemarker\2.3.32\freemarker-2.3.32.jar;C:\Users\User-2022\.m2\repository\commons-io\commons-io\2.21.0\commons-io-2.21.0.jar;C:\Users\User-2022\.m2\repository\org\velocity\velocity-engine-core\2.4.1\velocity-engine-core-2.4.1.jar;C:\Users\User-2022\.m2\repository\apache\commons\commons-collections4\4.4\commons-collections4-4.4.jar;C:\Users\User-2022\.m2\repository\org\slf4j\slf4j-api\2.0.13\slf4j-api-2.0.13.jar;C:\Users\User-2022\.m2\repository\org\slf4j\slf4j-simple\2.0.13\slf4j-simple-2.0.13.jar;C:\Users\User-2022\.m2\repository\joda-time\joda-time\2.12.7\joda-time-2.12.7.jar;C:\Users\User-2022\.m2\repository\org\codehaus\mojo\animal-sniffer-annotations\1.23\animal-sniffer-annotations-1.23.jar;C:\Users\User-2022\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.20.1\jackson-databind-2.20.1.jar;C:\Users\User-2022\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.20.1\jackson-core-2.20.1.jar;C:\Users\User-2022\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.20.1\jackson-annotations-2.20.1.jar

echo Using Maven to generate reports...
java -cp "%CLASSPATH%" org.apache.maven.cli.MavenCli clean verify -DskipTests

echo Report generation completed!
pause