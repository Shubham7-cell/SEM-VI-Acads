import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixToInfix {

    int tCount = 0;

    List<String> tableRow = new ArrayList<String>();

    public PostfixToInfix() {

        tableRow.add("Operator\tArg1\tArg2\tResult");

    }

    public String postfixToInfix(String postfix) {

        Stack<String> stack = new Stack<String>();

        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            // System.out.println("token: " + token + "");
            if (isOperator(token)) {

                String operand2 = stack.pop();

                String operand1 = stack.pop();

                String result = "(" + operand1 + " " + token + " " + operand2 + ")";
                // System.out.println("result: " + result + "");
                stack.push(result);
            } else {
                stack.push(token);
            }
        }
        // System.out.println("Stack length: " + stack.size() + "");

        String result = stack.peek().substring(1, stack.peek().length() - 1);

        return result;
        // return stack.toString();
    }

    public boolean isOperator(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("="))

        {
            return true;
        }

        else {
            return false;
        }
    }

    // quadraple representation table
    public void quadrapleRepresentation(String postfix) {

        Stack<String> stack = new Stack<String>();

        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            // System.out.println("token: " + token + "");
            if (isOperator(token)) {

                String operand2 = stack.pop();

                String operand1 = stack.pop();

                String result = "t" + tCount;

                tCount++;

                String row = token + "\t" + operand1 + "\t" + operand2 + "\t" + result;

                tableRow.add(row);

                stack.push(result);
            } else {
                stack.push(token);
            }
        }
        // System.out.println("Stack length: " + stack.size() + "");

        String result = stack.peek().substring(1, stack.peek().length() - 1);

        // return result;
        // return stack.toString();
    }

    public void printTable() {

        for (String row : tableRow) {
            System.out.println(row);
        }
    }

    public static void main(String[] args) {

        PostfixToInfix postfix = new PostfixToInfix();

        String input = "A B C + D E - * =";

        // input = input.replace(" =", "");

        String infix = postfix.postfixToInfix(input);

        System.out.println(infix);

        postfix.quadrapleRepresentation(input);

        postfix.printTable();

    }

}