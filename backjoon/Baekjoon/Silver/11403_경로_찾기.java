package java_folder;

import java.io.*;
import java.util.*;


public class 경로_찾기 {
    private static final int MAX = 30;
    static int[][] arr = new int[MAX][MAX];
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        combination();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right=Integer.parseInt(st.nextToken());
            bw.write(arr[right][left] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void combination() {
        for (int m = 1; m < MAX; m++) {
            arr[m][1] = m;
        }
        for (int n = 2; n < MAX; n++) {
            for (int m = 2; m < MAX; m++) {
                arr[n][m] = arr[n - 1][m - 1] + arr[n - 1][m];
            }
        }

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}