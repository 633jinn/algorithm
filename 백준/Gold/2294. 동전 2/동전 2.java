import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static Integer[] coins;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new Integer[N];
        dp = new Integer[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;
        
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(coins);

        find();
        if (dp[K]==Integer.MAX_VALUE-1) {
            dp[K] = -1;
        }
        bw.write(dp[K] + "\n");
        bw.flush();
        bw.close();
    }

    private static void find() {
        for (int i = 0; i < N; i++) { // 코인의 개수만큼
            for (int j = coins[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
    }

}