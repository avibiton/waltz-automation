java -jar sl-build-scanner.jar -pom -configfile slmaven-auto.json -workspacepath .
pause
mvn test -DrunFunctionalTests=true -Dmaven.test.failure.ignore=true
pause
java -jar sl-build-scanner.jar -restore -workspacepath . 
