package com.colasoft;

/**
 * Hello world!
 *
 */
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class App {

  public static void main(String args[]) throws Exception {

  	if(args.length < 1) {
  		System.out.println("Error, you must provide an XML file path to convert");
  		return;
  	}

  	File file = new File(args[0]);

  	String fileData = FileUtils.readFileToString(file, null);
  	System.out.println(StringEscapeUtils.escapeJavaScript(fileData));



    // String unescapedJava = "Are you for real?";
    // System.err.println(
    //   StringEscapeUtils.escapeJava(unescapedJava));

    // String unescapedJavaScript = "What's in a name?";
    // System.err.println(
    //   StringEscapeUtils.escapeJavaScript(unescapedJavaScript));

    // String unescapedSql = "Mc'Williams";
    // System.err.println(
    //   StringEscapeUtils.escapeSql(unescapedSql));

    // String unescapedXML = "<data>";
    // System.err.println(
    //   StringEscapeUtils.escapeXml(unescapedXML));

    // String unescapedHTML = "<data>";
    // System.err.println(
    //   StringEscapeUtils.escapeHtml(unescapedHTML));

  }
}
