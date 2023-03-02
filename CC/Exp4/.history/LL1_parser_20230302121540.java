public class LL1_parser {
    // LL1 pasrser
    public static void main(String[] args) {
        String input = "i+i*i$";
        String[] input_array = input.split("");
        String[] stack = new String[100];
        int top = 0;
        stack[top] = "$";
        top++;
        stack[top] = "E";
        top++;
        int i = 0;
        while (true) {
            if (stack[top - 1].equals(input_array[i])) {
                System.out.println("Matched " + stack[top - 1]);
                top--;
                i++;
            } else if (stack[top - 1].equals("E")) {
                System.out.println("Reduced E->TE'");
                top--;
                stack[top] = "E'";
                top++;
                stack[top] = "T";
                top++;
            } else if (stack[top - 1].equals("E'")) {
                if (input_array[i].equals("+")) {
                    System.out.println("Reduced E'->+TE'");
                    top--;
                    stack[top] = "E'";
                    top++;
                    stack[top] = "T";
                    top++;
                    stack[top] = "+";
                    top++;
                } else if (input_array[i].equals("$")) {
                    System.out.println("Reduced E'->epsilon");
                    top--;
                }
            } else if (stack[top - 1].equals("T")) {
                System.out.println("Reduced T->FT'");
                top--;
                stack[top] = "T'";
                top++;
                stack[top] = "F";
                top++;
            } else if (stack[top - 1].equals("T'")) {
                if (input_array[i].equals("+")) {
                    System.out.println("Reduced T'->epsilon");
                    top--;
                } else if (input_array[i].equals("*")) {
                    System.out.println("Reduced T'->*FT'");
                    top--;
                    stack[top] = "T'";
                    top++;
                    stack[top] = "F";
                    top++;
                    stack[top] = "*";
                    top++;
                }
            } else if (stack[top - 1].equals("F")) {
                if (input_array[i].equals("i")) {
                    System.out.println("Reduced F->i");
                    top--;
                    stack[top] = "i";
                    top++;
                    i++;
                } else if (input_array[i].equals("(")) {
                    System.out.println("Reduced F->(E)");
                    top--;
                    stack[top] = ")";
                    top++;
                    stack[top] = "E";
                    top++;
                    stack[top] = "(";
                    top++;
                }
            } else if (stack[top - 1].equals("$")) {
                System.out.println("Accepted");
                break;
            }

        }
    }
}