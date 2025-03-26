import java.io.*;
import java.util.*;

public class Main {
    /**
     * DP, LIS 알고리즘을 이용해서 풀수도 있다고 함.
     */
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        int index = 0;
        int result = 0;
        for (String s : br.readLine().split(" ")) {
            arr[index] = Integer.parseInt(s);
            dp[index++] = 1;
        }
        for (int i = 0; i < N; i++) {
            // i기준 이전 값들과 비교
            for (int j = 0; j < i; j++) {
                if (arr[i]<arr[j]) { //이전 값이 더 클 경우
                    //현재 진행중인 수열 크기와 j의 수열의 크기를 비교(j가 i보다 크기 때문에 +1)
                    dp[i] = Math.max(dp[i], dp[j]+1); 
                }
            }
            result =  Math.max(dp[i], result); 
        }
        
        System.out.println(result);
    }
}