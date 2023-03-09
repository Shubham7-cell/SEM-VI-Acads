package Exp5;

import java.util.HashMap;

// rule class
class Rule {
    public String left;
    public String[] right;

    public Rule(String left, String[] right) {
        this.left = left;
        this.right = right;
    }
}

public class Grammar {
    public static Rule[] rules = {
            new Rule("E", new String[] { "E", "+", "T" }),
            new Rule("E", new String[] { "T" }),
            new Rule("T", new String[] { "T", "*", "F" }),
            new Rule("T", new String[] { "F" }),
            new Rule("F", new String[] { "(", "E", ")" }),
            new Rule("F", new String[] { "i" }),
    };

    public static HashMap<Integer, HashMap<String, String>> actionTable = new HashMap<Integer, HashMap<String, String>>() {
        {
            put(0, new HashMap<String, String>() {
                {
                    put("i", "s5");
                    put("(", "s4");
                }
            });
            put(1, new HashMap<String, String>() {
                {
                    put("$", "acc");
                    put("+", "s6");
                    put(")", "r3");
                }
            });
            put(2, new HashMap<String, String>() {
                {
                    put("$", "acc");
                    put("+", "r6");
                    put("*", "s7");
                    put(")", "r6");
                }
            });
            put(3, new HashMap<String, String>() {
                {
                    put("$", "acc");
                    put("+", "r8");
                    put("*", "r8");
                    put(")", "r8");
                }
            });
            put(4, new HashMap<String, String>() {
                {
                    put("i", "s5");
                    put("(", "s4");
                }
            });
            put(5, new HashMap<String, String>() {
                {
                    put("$", "acc");
                    put("+", "r2");
                    put("*", "r2");
                    put(")", "r2");
                }
            });
            put(6, new HashMap<String, String>() {
                {
                    put("i", "s5");
                    put("(", "s4");
                }
            });
            put(7, new HashMap<String, String>() {
                {
                    put("i", "s5");
                    put("(", "s4");
                }
            });
            put(8, new HashMap<String, String>() {
                {
                    put(")", "s11");
                }
            });
            put(9, new HashMap<String, String>() {
                {
                    put("$", "acc");
                    put("+", "s6");
                    put(")", "r1");
                }
            });
            put(10, new HashMap<String, String>() {
                {
                    put("$", "acc");
                    put("+", "r4");
                    put("*", "s7");
                    put(")", "r4");
                }
            });
            put(11, new HashMap<String, String>() {
                {
                    put("$", "acc");
                    put("+", "r7");
                    put("*", "r7");
                    put(")", "r7");
                }
            });
        }
    };
}
