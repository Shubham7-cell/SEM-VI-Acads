import java.util.ArrayList;

public class LeftRecursionRemover {
    public static void main(String[] args) {
        ArrayList<String> productions = new ArrayList<>();
        productions.add(0, "S -> Sa | aS | bS | Sbb");
        productions.add("A -> aA | All");
        removeDirectLeftRecursion(productions);
    }

    public static void removeDirectLeftRecursion(ArrayList<String> productions) {
        ArrayList<String> updatedProductions = new ArrayList<>();
        for (String production : productions) {
            ArrayList<String> betaProductions = new ArrayList<>();
            ArrayList<String> recursionProductions = new ArrayList<>();
            String[] productionArray = production.split("->", 0);
            String leftHandSide = productionArray[0];
            String primeLeftHandSide = leftHandSide + "'";
            String[] rightHandSideArray = productionArray[1].split(" \\| ", 0);
            for (String rightHandSide : rightHandSideArray) {
                if (rightHandSide.equals("|")) {
                    continue;
                }
                if (leftHandSide.charAt(0) == rightHandSide.charAt(0)) {
                    recursionProductions.add(rightHandSide);
                } else {
                    betaProductions.add(rightHandSide);
                }
            }
            String betaProductionString = "";
            for (String beta : betaProductions) {
                betaProductionString += " | " + beta + primeLeftHandSide;
            }
            updatedProductions.add(leftHandSide + " ->" + betaProductionString.substring(3));
            String primeProduction = "";
            for (String recursion : recursionProductions) {
                int counter = -1;
                while (leftHandSide.charAt(0) == recursion.charAt(++counter))
                    ;
                int counterCopy = counter;
                String primeString = "";
                while (counter != 0) {
                    primeString += primeLeftHandSide;
                    counter--;
                }
                primeProduction += recursion.substring(counterCopy) + primeString;
                primeProduction += " | ";
            }
            primeProduction += "epsilon";
            updatedProductions.add(primeLeftHandSide + "->" + primeProduction);
            System.out.println("Initial production: ");
            System.out.println(production);
            System.out.println("Final productions: ");
            for (String updatedProduction : updatedProductions) {
                System.out.println(updatedProduction);
            }
        }
    }
}
