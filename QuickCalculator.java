import java.io.PrintWriter;

public class QuickCalculator {

    public static String concat(String[] args) {
        String result = "";
        for (String arg : args) {
          result += (arg + " ");
        }
        return result;
      }
    public static void main(String[] args) throws Exception{
        BFCalculator myBFCalculator = new BFCalculator();
        PrintWriter pen = new PrintWriter(System.out, true);
        Fraction result = myBFCalculator.evaluate(concat(args));
        pen.println("Result fraction: " + result);
    } 
}
