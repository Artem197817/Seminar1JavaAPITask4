import java.io.IOException;

public class Printer {
    public static void main(String[] args) throws IOException {
        String file = "input.txt";

        //if (args.length == 0) {
      //      file = "input.txt";
     //   }
       // else{
      //      file = args[0];
      //  }

        Equation eq = new Equation();
        String result = eq.getSolution(file);
        System.out.println(result);
    }
}
