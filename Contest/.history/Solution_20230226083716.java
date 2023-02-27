// Problem
// Given an integer NN, find four positive distinct integers aa, bb, cc and dd
// such that:
// ((a&b)∣c)⊕d=N
// Here &, ∣, and ⊕ represent bitwise AND, OR and XOR, respectively.
// If there are multiple answers, print any of them. If no answer exists, print
// -1.

// Input Format
// The first line of input will contain a single integer TT, denoting the number
// of test cases.
// Each test case consists of one line of input, containing a single integer NN.

// Output Format
// For each test case, output −1−1 if there is no way to find four distinct
// integers to satisfy the equation.
// Otherwise, print on a new line any four space-separated integers aa, bb, cc
// and dd that satisfy the conditions.


// class Solution {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int t = sc.nextInt();
// while (t-- > 0) {
// int n = sc.nextInt();
// // ((a&b)∣c)⊕d=N
// predict the pattern
// int a = 1;
// int b = 2;
// int c = 3;
// int d = n - 6;
// System.out.println(a + " " + b + " " + c + " " + d);
// }
// }
