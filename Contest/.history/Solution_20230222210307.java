
// problem
//Given an integer NN, find four positive distinct integers aa, bb, cc and dd such that:
// ((a&b)∣c)⊕d=N
// Here &, ∣, and ⊕ represent bitwise AND, OR and XOR, respectively.
//If there are multiple answers, print any of them. If no answer exists, print -1.

//class Codechef
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a = 1;
            int b = 2;
            int c = 3;
            int d = n - 6;
            if (n < 6) {
                System.out.println(-1);
            } else {
                System.out.println(a + " " + b + " " + c + " " + d);
            }
        }
    }
}