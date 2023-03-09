import java.util.*;

public class LR0parser {
    // check validity for the input strind

    String input;
    HashMap<Integer, HashMap<String, String>> action;
    Stack<Integer> state;

    public LR0parser(String input, HashMap<Integer, HashMap<String, String>> action) {
        this.input = input;
        this.action = action;
        state = new Stack<Integer>();
        state.push(0);
    }

    public boolean parse() {
        String[] tokens = input.split(" ");
        int i = 0;
        while (true) {
            String token = tokens[i];
            int s = state.peek();
            HashMap<String, String> actionMap = action.get(s);
            String action = actionMap.get(token);
            if (action == null) {
                return false;
            }
            if (action.equals("acc")) {
                return true;
            }
            if (action.startsWith("s")) {
                state.push(Integer.parseInt(action.substring(1)));
                i++;
            } else if (action.startsWith("r")) {
                int rule = Integer.parseInt(action.substring(1));
                int pop = Grammar.rules.get(rule).right.length;
                while (pop > 0) {
                    state.pop();
                    pop--;
                }
                int newState = state.peek();
                state.push(Grammar.gotoTable.get(newState).get(Grammar.rules.get(rule).left));
            }
        }
    }

    public static void main(String[] args) {
        String input = "i + i * i $";
        LR0parser parser = new LR0parser(input, Grammar.actionTable);
        System.out.println(parser.parse());
    }

}
