import java.util.*;

public class Parser {
    public static void main(String[] args) {
        // Production rules
        ArrayList<ArrayList<String>> production = new ArrayList<ArrayList<String>>();
        production.add(new ArrayList<String>(Arrays.asList("E", "E", "sub", "E", "sup", "E")));
        production.add(new ArrayList<String>(Arrays.asList("E", "E", "sub", "E")));
        production.add(new ArrayList<String>(Arrays.asList("E", "E", "sup", "E")));
        production.add(new ArrayList<String>(Arrays.asList("E", "{", "E", "}")));
        production.add(new ArrayList<String>(Arrays.asList("E", "c")));

        // Parsing table
        int[][] table = {
            { 2, 0, 0, 0, 3, 0, 1 },
            { 0, 0, 5, 4, 0, -1, 0 },
            { 2, 0, 0, 0, 3, 0, 6 },
            { 0, 5, 5, 5, 0, 5, -1 },
            { 2, 0, 0, 0, 3, 0, 7 },
            { 2, 0, 0, 0, 3, 0, 8 },
            { 0, 9, 5, 4, 0, 0, -1 },
            { 0, -2, 4, 10, 0, -2, -1 },
            { 0, -3, 5, 4, 0, -3, -1 },
            { 0, -4, -4, -4, 0, -4, -1 },
            { 2, 0, 0, 0, 3, 0, 11 },
            { 0, -1, 5, 4, 0, -1, -1 },
        };

        // Input string
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your input string: ");
        String[] input = scanner.nextLine().split(" ");
        input = Arrays.copyOf(input, input.length + 1);
        input[input.length - 1] = "$";
        System.out.println("Your input: " + Arrays.toString(input));

        // Parsing
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int ptr = 0;
        boolean error = false;

        while (true) {
            System.out.print("Stack: ");
            for (Integer s : stack) {
                System.out.print(s + " ");
            }
            System.out.println();

            int sd = stack.peek(); // stack data
            String bd = input[ptr]; // buffer data
            int ptd = table[sd][getInputIndex(bd)]; // parsing table data

            // Error occurrence
            if (ptd == 0) {
                error = true;
                break;
            }
            // String accepted
            else if (ptd == -1) {
                break;
            }
            // Reduce case
            else if (ptd > 0) {
                ArrayList<String> prod = production.get(ptd - 1);
                int l = prod.get(1).equals("") ? 1 : prod.get(1).split(" ").length;

                if (stack.size() < 2 * l) {
                    error = true;
                    break;
                }
