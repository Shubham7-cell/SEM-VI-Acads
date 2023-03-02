import java.util.*;

public class LL1_parser {

    public static void main(String[] args) {
        LL1_parser parser = new LL1_parser();
        parser.parse();
    }

    // using collection framework
    Set<String> set = new HashSet<String>();
    Stack<String> stack = new Stack<String>();
    String input = "i+i*i$";
    String[] input_array = input.split("");
    int i = 0;

    // used to check if the input string is accepted or not
    public void parse() {
        stack.push("$");
        stack.push("E");
        while (true) {
            if (stack.peek().equals(input_array[i])) {
                System.out.println("Matched " + stack.peek());
                stack.pop();
                i++;

            } else if (stack.peek().equals("E")) {
                System.out.println("Reduced E->TE'");
                stack.pop();
                stack.push("E'");
                stack.push("T");
            } else if (stack.peek().equals("E'")) {
                if (input_array[i].equals("+")) {
                    System.out.println("Reduced E'->+TE'");
                    stack.pop();
                    stack.push("E'");
                    stack.push("T");
                    stack.push("+");
                } else if (input_array[i].equals("$")) {
                    System.out.println("Reduced E'->epsilon");
                    stack.pop();
                }
            } else if (stack.peek().equals("T")) {
                System.out.println("Reduced T->FT'");
                stack.pop();
                stack.push("T'");
                stack.push("F");
            } else if (stack.peek().equals("T'")) {
                if (input_array[i].equals("+")) {
                    System.out.println("Reduced T'->epsilon");
                    stack.pop();
                } else if (input_array[i].equals("*")) {
                    System.out.println("Reduced T'->*FT'");
                    stack.pop();
                    stack.push("T'");
                    stack.push("F");
                    stack.push("*");
                }
            } else if (stack.peek().equals("F")) {
                if (input_array[i].equals("i")) {
                    System.out.println("Reduced F->i");
                    stack.pop();
                    stack.push("i");
                    i++;
                } else if (input_array[i].equals("(")) {
                    System.out.println("Reduced F->(E)");
                    stack.pop();
                    stack.push(")");
                    stack.push("E");
                    stack.push("(");
                }
            } else if (stack.peek().equals("$")) {
                System.out.println("Accepted");
                break;
            }
        }
    }

}