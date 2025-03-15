import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static AB[] dp;

    public static class AB {
        int a;
        int b;

        public AB(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public AB create(AB x) {
            return new AB(this.a + x.a, this.b + x.b);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new AB[46];
        dp[1] = new AB(0, 1);
        dp[2] = new AB(1, 0);
        dp[3] = new AB(0, 1);
        dp[4] = new AB(1, 1);
        dp[5] = new AB(1, 2);

        int a = 0;
        int b = 0;

        for (int i = 1; i <= N; i++) {
            if (i >= 6) {
                dp[i] = dp[i - 2].create(dp[i - 1]);
            }
            a += dp[i].a;
            b += dp[i].b;
        }
        bw.write(a + " " + b + "\n");
        bw.flush();
        bw.close();
    }
}