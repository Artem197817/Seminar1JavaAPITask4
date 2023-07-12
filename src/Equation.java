import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Equation {
    public static String getSolution(String str) throws IOException {
        // Введите свое решение ниже
        Path pathtext = Paths.get(str);
        byte[] bytes = Files.readAllBytes(pathtext);
        String contents = new String(bytes);

        String[] temp = contents.replace(" ", "").split("");
        String[] temp2 = new String[temp.length];
        String[] temp1 = new String [3];
        System.arraycopy(temp, 0, temp2, 0, temp.length);
        boolean flag = false;

        for (int m = 0; m < 10; m++) {
            for (int k = 0; k < temp.length; k++) {
                if (temp2[k].equals("?")) {
                    temp2[k] = Integer.toString(m);
                }
            }
            temp1 = arrTemp(temp2);
            flag = isFlag(temp1);
            if (flag) break;
            System.arraycopy(temp, 0, temp2, 0, temp.length);
        }

        if (flag) return "Given the equation: " + contents + "\n" + "Result: " +
                temp1 [0] + " + " + temp1[1] + " = " + temp1[2];
            else return "No solution";
    }
    public static String[] arrTemp(String[] str) {
        boolean flag = false;
        String[] temp1 = new String[3];
        Arrays.fill(temp1, "");
        int i = 0;
        for (String val : str) {
            if (val.equals("+") || val.equals("=")) i++;
            else temp1[i] += val;
        }
        return temp1;
    }
    public static boolean isFlag (String [] temp1){
        return Integer.parseInt(temp1[0]) + Integer.parseInt(temp1[1]) == Integer.parseInt(temp1[2]);
    }

}
