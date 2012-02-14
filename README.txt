1) On the project root directory, use the following Commands to

a) build the source:
mvn compile

b) run unit tests:
mvn test

c) package the project into a executable jar:
mvn package

2) Run sample testcase:
java -jar target/Analytics-1.0.jar src/test/testdata/SampleInput.txt

sample outout:

"
java -jar target/Analytics-1.0.jar src/test/testdata/SampleInput.txt
1 The
1 fox
1 the
1 back
1 lazy
1 over
2 brown
1 dog's
1 quick
1 jumped
"