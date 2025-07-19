import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        input();
        backTracking(0, new int[n]);
        System.out.println(result);
    }

    // 한줄씩 백트래킹 수행
    // col = queen의 column값들을 가진 배열
    private static void backTracking(int r, int[] col) {
        if (r == n) {
            result++;
            return;
        }
        for (int column = 0; column < n; column++) {
            boolean flag = true;
            for (int i = 0; i < r; i++) {
                if (Math.abs(i - r) == Math.abs(col[i] - column)) {
                    flag = false;
                    break;
                }
                if (col[i] == column) {
                    flag = false;
                    break;
                }
            }
            // 이전의 queen들과 겹치지 않으면
            if (flag) {
                col[r] = column;
                backTracking(r + 1, col);
            }
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }
}