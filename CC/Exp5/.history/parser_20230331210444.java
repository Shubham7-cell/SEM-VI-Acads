import java.util.*;
import java.util.stream.*;

public class Parser {
    private final List<List<String>> production = Arrays.asList(
            Arrays.asList("E", "sub", "E", "sup", "E"),
            Arrays.asList("E", "sub", "E"),
            Arrays.asList("E", "sup", "E"),
            Arrays.asList("E", "{", "E", "}"),
            Arrays.asList("E", "c")
    );

    private final Integer[][] table = new Integer[][]{
            {2, null, null, null, 3, null, 1},
            {null, null, 5, 4, null, -1, null},
            {2, null, null, null, 3, null, 6},
            {null, 5, 5, 5, null, 5, -1},
            {2, null, null, null, 3, null, 7},
            {2, null, null, null, 3, null, 8},
            {null, 9, 5, 4, null, null, -1},
            {null, 2, 4, 10, null, 2, -1},
            {null, 3, 5, 4, null, 3, -1},
            {null, 4, 4, 4, null, 4, -1},
            {2, null, null, null, 3, null, 11},
            {null, 1, 5, 4, null, 1, -1}
    };

    private final Map<String, Integer> terminals = new HashMap<String, Integer>() {{
        put("{", 0);
        put("}", 1);
        put("sup", 2);
        put("sub", 3);
        put("c", 4);
        put("$", 5);
    }};

    private final Map<String, Integer> nonTerminals = new HashMap<String, Integer>() {{
        put("S", 0);
        put("E", 1);
    }};

    public boolean parse(String input) {
        List<String> tokens = Arrays.stream(input.split(" ")).collect(Collectors.toList());
        tokens.add("$");

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int ptr = 0;
        boolean error = false;

        while (true) {
            System.out.print("Stack: ");
            System.out.println(stack);

            int sd = stack.peek();
            int bd = terminals.get(tokens.get(ptr));
            Integer ptd = table[sd][bd];

            // Error Occurence
            if (ptd == null) {
                error = true;
                break;
            }

            // String accepted
            if (ptd == -1) {
                break;
            }

            // REDUCE Case
            if (ptd < 0) {
                List<String> prod = production.get(-ptd - 1);
                int l = prod.get(1).equals("") ? 1 : prod.size();

                if (stack.size() < 2 * l) {
                    error = true;
                    break;
                }

                for (int i = 0; i < 2 * l; i++) {
                    stack.pop();
                }

                sd = stack.peek();
                bd = nonTerminals.get(prod.get(0));

                if (table[sd][bd] == null) {
                    error = true;
                    break;
                }

                stack.push(bd);
                stack.push(table[sd][bd]);
            }

            // SHIFT Case
           
            else {
                stack.push(ptd);
                ptr++;
            }
        }

        if (error) {
            System.out.println("Error: Invalid input");
            return false;
        } else {
            System.out.println("Success: Valid input");
            return true;
        }
    }

    public static void main(String[] args) {
        Parser parser = new Parser();

        // Test input strings
        String input1 = "c";
        String input2 = "{ c }";
        String input3 = "{ sub c }";
        String input4 = "{ c sup c }";
        String input5 = "{ sub c sup c }";
        String input6 = "{ sub c } sup c";
        String input7 = "{ sub { c sup c } }";
        String input8 = "{ sub { c sub c } sup { c sub c } }";

        parser.parse(input1);
        parser.parse(input2);
        parser.parse(input3);
        parser.parse(input4);
        parser.parse(input5);
        parser.parse(input6);
        parser.parse(input7);
        parser.parse(input8);
    }
}
