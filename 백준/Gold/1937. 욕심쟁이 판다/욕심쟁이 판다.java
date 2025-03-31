import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[][] bamboo;
    static int[][] dp;
    static int[] moveX = { -1, 1, 0, 0 }; // 상하좌우
    static int[] moveY = { 0, 0, -1, 1 };

    static public class Node {
        int x;
        int y;
        int dfs;

        public Node(int x, int y, int dfs) {
            this.x = x;
            this.y = y;
            this.dfs = dfs;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == -1) {
                    dfs(i, j);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }

    private static int dfs(int i, int j) {
        if (dp[i][j] == -1) {
            dp[i][j] = 1;
        }else{
            return dp[i][j];
        }
        for (int k = 0; k < 4; k++) {
            int x = i + moveX[k];
            int y = j + moveY[k];
            if (isValid(x, y) && bamboo[i][j] < bamboo[x][y]) {
                dp[i][j] = Math.max(dp[i][j], dfs(x, y) + 1);
            }
        }
        return dp[i][j];
    }

    private static boolean isValid(int x, int y) {

        if (x < 0 || x >= N || y < 0 || y >= N) {
            return false;
        }
        return true;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bamboo = new long[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                bamboo[i][j] = Long.parseLong(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }
    }
}