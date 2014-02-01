escaper
====

The purpose of this project is to read an arbitrary file and convert it to a String (that will work with Javascript, XML, whatever).  Currently I've only implemented Javascript, but I'll expand on this so it works for more languages.

Building:
====

    mvn clean install

Running:
====

    mvn clean install exec:java -Dexec.args="/tmp/test.xml" 



