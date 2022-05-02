@ECHO OFF


java -jar "%~dp0../lib/cucumber-sandwich.jar" -r "EdgeReport" -f "%~dp0../target/edgeOutput" -o "%~dp0../target/edgeOutput" -n

end