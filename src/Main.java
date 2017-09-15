import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String str = "53*245-29*70/35+78";
        String pattern1 = "[\\*\\+-/]";
        String pattern2 = "[0-9]+";
        String[] operand = str.split(pattern1);
        String[] operator = str.split(pattern2);

        List<String> operands = new ArrayList<>(Arrays.asList(operand));
        List<String> operators = new ArrayList<>(Arrays.asList(operator));

       for (int i = 0; i < operators.size(); ++i) {
            if (operators.get(i).equals("*") || operators.get(i).equals("/")) {
                int operand2 = Integer.parseInt(operands.remove(i));
                int operand1 = Integer.parseInt(operands.remove(i-1));
                if (operators.remove(i).equals("*")) {
                    int result = operand1 * operand2;
                    operands.add(i-1, String.valueOf(result));
                } else{
                    int result = operand1 / operand2;
                    operands.add(i-1, String.valueOf(result));
                }
                --i;
            }
        }
        for (int i = 0; i < operators.size(); ++i) {
            if (operators.get(i).equals("+") || operators.get(i).equals("-")) {
                int operand2 = Integer.parseInt(operands.remove(i));
                int operand1 = Integer.parseInt(operands.remove(i-1));
                if (operators.remove(i).equals("+")) {
                    int result = operand1 + operand2;
                    operands.add(i-1, String.valueOf(result));
                } else{
                    int result = operand1 - operand2;
                    operands.add(i-1, String.valueOf(result));
                }
                --i;
            }
        }

        System.out.println(operands.get(0));

    }
}
