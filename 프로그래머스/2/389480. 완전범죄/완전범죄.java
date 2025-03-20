import java.io.*;
import java.util.*;
class Solution {
    static int[][] dp;
    public int solution(int[][] info, int n, int m) {
        dp = new int [info.length+1][m]; //물건 i에 따라, m개가 있을 때 n의 최솟값 저장 
        for(int i = 1; i<=info.length;i++){
            Arrays.fill(dp[i], n);
        }
        dp[0][0] = 0;
        
        find(info, n, m);
        int answer = Arrays.stream(dp[info.length]).min().getAsInt();
            
        if(answer == n){
            return -1;
        }
        return answer;
        // return 0;
    }
    public void find(int[][] info, int n, int m) {
        for(int i = 1; i<=info.length; i++){
            for(int j = 0; j < m; j++){
                // A도둑이 흔적 남겼을 때
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+info[i-1][0]);
                if(j+info[i-1][1]<m){
                    // B도둑이 흔적 남겼을 때
                    dp[i][j+info[i-1][1]] = Math.min(dp[i][j+info[i-1][1]], dp[i-1][j]);
                }
            }
        }
    }
}