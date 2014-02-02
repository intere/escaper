escaper
====

The purpose of this project is to read an arbitrary file and convert it to a String (that will work with Javascript, XML, whatever).  Currently I've only implemented Javascript, but I'll expand on this so it works for more languages.

Building:
====

    mvn clean install

Running:
====

    mvn clean install exec:java -Dexec.args="/tmp/test.xml" 


Usage:
====

    escaper <output_type> <input_file> [output_file]

    Parameters:
      output_type - The desired output type (what to escape the input file to).  You can use any one of the following:
        -java
          Produces a Java String
        -javascript
          Produces a Javascript String
        -sql
          Produces a SQL String
        -xml
          Produces an XML String
        -html
          Produces an HTML String

      input_file - The Path (relative or absolute) to the input file you would like to escape

      output_file - The (optional) path (relative or absolute) to the output file you would like to write the string to.  If you don't provide this, it will just be written to STDOUT.

    