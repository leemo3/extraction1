package exercise12_12;
import java.util.*;
import java.io.*;

public class Exercise12_12 {
  /**Main method*/
  public static void main(String[] args) throws Exception {
    // Check command line parameter usage
    extracted1(args);

    // Check if source file exists
    File sourceFile = extracted(args);

    StringBuilder buffer = new StringBuilder();
    Scanner input = new Scanner(sourceFile);

    extracted(buffer, input);

    input.close();

    // Write buffer into the file
    PrintWriter output = new PrintWriter(sourceFile);
    output.print(buffer.toString());
    output.close();
  }

  private static void extracted1(String[] args) {
    extracted3(args);
  }

  private static void extracted3(String[] args) {
    if (args.length != 1) {
      System.out.println(
        "Usage: java Exercise12_12 filename");
      System.exit(1);
    }
  }

  private static void extracted(StringBuilder buffer, Scanner input) {
    while (input.hasNext()) {
      String s = input.nextLine();
      String s1 = s.trim();
      if (s1.charAt(0) == '{') {
        buffer.append(" {");
        if (s1.length() > 1) buffer.append("\r\n" + s.replace('{', ' '));
      }
      else
        buffer.append("\r\n" + s);
    }
  }

  private static File extracted(String[] args) {
    File sourceFile = new File(args[0]);
    if (!sourceFile.exists()) {
       System.out.println("Source file " + args[0] + " not exist");
       System.exit(2);
    }
    return sourceFile;
  }
}
