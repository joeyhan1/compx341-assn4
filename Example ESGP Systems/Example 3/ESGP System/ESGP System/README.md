# COMPX341_Assignment3

### To compile the program

```
javac -cp "lib/gs-core-1.3.jar;lib/gs-ui-1.3.jar;lib/junit-platform-console-standalone-1.10.0-M1.jar" *.java
```

### To run the program

```
java -cp ".;lib/gs-core-1.3.jar;lib/gs-ui-1.3.jar;" Main
```

### To compile JUnit tests

```
 javac -cp "lib/gs-core-1.3.jar;lib/gs-ui-1.3.jar;lib/junit-platform-console-standalone-1.10.0-M1.jar" *.java
```

### To run JUnit tests

```
java -jar "lib/junit-platform-console-standalone-1.10.0-M1.jar" -cp ".;lib/gs-core-1.3.jar;lib/gs-ui-1.3.jar" -c testAccountLogin
java -jar "lib/junit-platform-console-standalone-1.10.0-M1.jar" -cp ".;lib/gs-core-1.3.jar;lib/gs-ui-1.3.jar" -c testCategorisingDevices
java -jar "lib/junit-platform-console-standalone-1.10.0-M1.jar" -cp ".;lib/gs-core-1.3.jar;lib/gs-ui-1.3.jar" -c testCategorisingUsers
java -jar "lib/junit-platform-console-standalone-1.10.0-M1.jar" -cp ".;lib/gs-core-1.3.jar;lib/gs-ui-1.3.jar" -c testCommunityFeatures
java -jar "lib/junit-platform-console-standalone-1.10.0-M1.jar" -cp ".;lib/gs-core-1.3.jar;lib/gs-ui-1.3.jar" -c testEncostFeatures
java -jar "lib/junit-platform-console-standalone-1.10.0-M1.jar" -cp ".;lib/gs-core-1.3.jar;lib/gs-ui-1.3.jar" -c testGraphDataType
java -jar "lib/junit-platform-console-standalone-1.10.0-M1.jar" -cp ".;lib/gs-core-1.3.jar;lib/gs-ui-1.3.jar" -c testLoadingDefaultDataset
```
