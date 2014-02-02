package com.colasoft;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.io.FileUtils;
import java.io.File;

/**
 * Tool that uses Apache Commons Lang to escape strings for you into various output formats.
 */
public class App {

  public static void main(String args[]) throws Exception {

    Params params = parseCLI(args);

    // First, open the file:
    File file = new File(params.inputFile);
  	String fileData = FileUtils.readFileToString(file, null);

    // Now - go get the appropriate output format:
    String output = null;

    switch(params.outputType) {
      case JavaString: {
        output = "String data=\"" + StringEscapeUtils.escapeJava(fileData) + "\";";
        break;
      }

      case JavaScriptString: {
        output = "var data='" + StringEscapeUtils.escapeJavaScript(fileData) + "';";
        break;
      }

      case SqlString: {
        output = StringEscapeUtils.escapeSql(fileData);
        break;
      }

      case XmlString: {
        output = StringEscapeUtils.escapeXml(fileData);
        break;
      }

      case HtmlString: {
        output = StringEscapeUtils.escapeHtml(fileData);
        break;
      }

      default: {
        System.err.println("Error, unknown escape type");
      }
    }

    if(null != params.outputFile) {
      FileUtils.writeStringToFile(new File(params.outputFile), output, null);
    } else {
  	 System.out.println(output);
    }
  }

  /** Enum to keep track of output types.  */
  private enum OutputType {
    JavaString("-java"),
    JavaScriptString("-javascript"),
    SqlString("-sql"),
    XmlString("-xml"),
    HtmlString("-html");

    private String arg;

    public String getArg() {
      return arg;
    }

    OutputType(String arg) {
      this.arg = arg;
    }

    static OutputType getOutputType(String arg) {
      for(OutputType type : OutputType.values()) {
        if(type.getArg().equals(arg)) {
          return type;
        }
      }
      return null;
    }
  }

  /** Private "struct" to keep track of CLI parameters.  */
  private static class Params {
    private String inputFile;
    private String outputFile;
    private OutputType outputType;
  }

  /** Routine to parse CLI arguments.  */
  private static Params parseCLI(String[] args) {
    Params params = new Params();

    if(args.length>1) {
      int paramIndex = 0;
      for(int i=0; i<args.length; i++) {
        String arg = args[i];
        OutputType type = OutputType.getOutputType(arg);
        if(type!=null) {
          params.outputType = type;
          paramIndex = i;
          break;
        } else if("-help".equals(arg)) {
          usage();
          System.exit(0);
        }
      }

      params.inputFile = args[paramIndex+1];
      if(args.length>paramIndex+2) {
        params.outputFile = args[paramIndex+2];
      }

    } else if(args.length == 1 && "-help".equals(args[0])) {
      usage();
      System.exit(0);

    } else {
      
      System.err.println("Error, incorrect usage");
      usage();
      System.exit(-1);

    }

    return params;
  }

  /** Produces Usage Message.  */
  private static void usage() {
    String usage="Usage:\n\tescaper <output_type> <input_file> [output_file]\n\nParameters:\n\toutput_type - The desired output type (what to escape the input file to).  You can use any one of the following:\n\t\t-java \n\t\t\tProduces a Java String\n\t\t-javascript\n\t\t\tProduces a Javascript String\n\t\t-sql\n\t\t\tProduces a SQL String\n\t\t-xml\n\t\t\tProduces an XML String\n\t\t-html\n\t\t\tProduces an HTML String\n\n\tinput_file - The Path (relative or absolute) to the input file you would like to escape\n\n\toutput_file - The (optional) path (relative or absolute) to the output file you would like to write the string to.  If you don't provide this, it will just be written to STDOUT.\n\n";
    System.out.println(usage);
  }

}
