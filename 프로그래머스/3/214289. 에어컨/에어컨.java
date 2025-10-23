import java.util.*;
class Solution {
    static int[][] dp;
    static int size, T1, T2, MAXIMUM = 1000000, Temperature;
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {   
        size = onboard.length;
        T1 = t1+10; T2 = t2+10; Temperature = temperature+10;
        dp = new int[size][51];
        for(int i = 0; i<size; i++){
            for(int j = 0; j<51; j++)
                dp[i][j] = MAXIMUM;
        }
        dp[0][Temperature] = 0;
        
        for(int i = 0; i<size-1; i++){
            for(int j = 0; j<51; j++){
                if(onboard[i] == 1 && (j<T1 || j>T2)) continue;
                
                //에어컨 킬 때
                //온도 유지
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+b);
                
                //온도 상승
                if(j<50) dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]+a);
                //온도 하강
                if(j>0) dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j]+a);
                
                //에어컨 끌 때
                //온도 유지
                if(j == Temperature)
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
                else if(j<Temperature && j<50){
                    //온도 상승
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]);
                }else if(j>Temperature && j>0){
                    //온도 하강
                    dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j]);
                }
            }
        }
        
        int answer = MAXIMUM;
        for(int i = 0 ; i< 51; i++){
            if(onboard[size-1] == 1 && (i < T1 || T2 < i)) continue; 
            answer=Math.min(answer,dp[size-1][i]);
        }
       
        return answer;
    }
}