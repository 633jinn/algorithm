import java.util.*;
class Solution {
    double[] y = new double[200];
    double[] dp = new double[200];
    public double[] solution(int k, int[][] ranges) {
        y[0] = k;
        int idx = 1;
        while(k!=1){
            if(k%2 == 0){
                k/=2;
            }else{
                k*=3;
                k+=1;
            }
            y[idx] = k;
            dp[idx] = dp[idx-1] + (y[idx-1]+y[idx])/2;
            idx++;
        }
        idx--;
        double[] answer = new double[ranges.length];
        for(int i = 0; i<ranges.length; i++){
            int a = ranges[i][0];
            int b = ranges[i][1]+idx;
            answer[i] = a>b?-1:dp[b]-dp[a];
        }
        return answer;
    }
}