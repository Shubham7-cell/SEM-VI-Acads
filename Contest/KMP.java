public class KMP {
    // index at which string matches needle
    public static int search(String haystack, String needle) {
        int M = needle.length();
        int N = haystack.length();
        int[] lps = new int[M];
        int j = 0; // index for needle[]
        computeLPSArray(needle, M, lps);
        int i = 0; // index for haystack[]
        while (i < N) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                return i - j;
            } else if (i < N && needle.charAt(j) != haystack.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return -1;
    }

    // longest prefix which is also suffix
    public static void computeLPSArray(String needle, int M, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < M) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}