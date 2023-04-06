import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Blocks {

    // Write a program to find Basic blocks and generate flow graph for the given
    // three address code

    // 1. Read the input from the file
    // 2. Generate the flow graph
    // 3. Find the basic blocks
    // 4. Print the basic blocks

    // code for reading the input from the file

    // code for generating the flow graph write function

    public static void generateFlowGraph(List<String> input) {
        // TODO Auto-generated method stub
        for (String string : input) {
            System.out.println(string);
        }

    }

    // code for finding the basic blocks write function

    public static void findBasicBlocks(List<String> input) {

    }

    public static void main(String[] args) {
        // read the input from the file

        File file = new File("input.txt");
        try (Scanner sc = new Scanner(file)) {
            // read the input from the file and store it in a list
            List<String> input = new ArrayList<String>();
            while (sc.hasNextLine()) {
                input.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}