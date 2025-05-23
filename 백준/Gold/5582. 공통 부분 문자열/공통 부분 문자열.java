import java.io.*;
import java.util.*;

public class Main {
    static String first;
    static String second;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        input();

        int max = 0;
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if(first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine();
        second = br.readLine();

        dp = new int[first.length() + 1][second.length() + 1];
    }
}
