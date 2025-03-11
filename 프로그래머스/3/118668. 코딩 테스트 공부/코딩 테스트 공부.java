import java.util.*;
import java.io.*;

//정답 참고
class Solution {
    static int maxAlp = 0;
    static int maxCop = 0;
    static int[][] dp;
    
    public int solution(int alp, int cop, int[][] problems) {
        setMax(alp, cop, problems);
        dp = new int[maxAlp+1][maxCop+1];
        
        for(int i =0; i<dp.length; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        
        alp = Math.min(alp, maxAlp); // alp가 이미 maxAlp보다 더 클 수 있음 -> 오버플로우 발생 방지
        cop = Math.min(cop, maxCop); // cop도 동일
        dp[alp][cop] = 0;
        
        for(int i = alp;i<=maxAlp; i++){
            for(int j = cop;j<=maxCop;j++){
                if(i+1<=maxAlp){
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1); //알고리즘 공부
                }
                if(j+1<=maxCop){
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1); //코딩 공부
                }
                
                //문제풀기
                for(int p = 0; p<problems.length; p++){
                    int[] problem = problems[p];
                    if(problem[0]<=i && problem[1]<=j){
                        //현재 alp, cop로 문제를 풀 수 있다면
                        //문제를 풀어 얻은 알고력, 코딩력을 추가한 dp 값을 비교한다
                        int nextAlp = Math.min(maxAlp, i + problem[2]); // maxAlp 범위를 초과하는 경우 
                        int nextCop = Math.min(maxCop, j + problem[3]); // maxCop 범위를 초과하는 경우
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j]+problem[4]); 
                    }
                }
            }
        }
        
        
        return dp[maxAlp][maxCop];
    }
    
    public void setMax(int alp, int cop, int[][] problems){
        for(int i = 0; i < problems.length; i++){
            int[] problem = problems[i];
            maxAlp = maxAlp<problem[0]?problem[0]:maxAlp;
            maxCop = maxCop<problem[1]?problem[1]:maxCop;
        }
    }
}