import java.io.*;
import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    public int solution(int[] diffs, int[] times, long limit) {
        
        binarySearch(diffs, times, limit);
        
        return answer;
    }
    public void binarySearch(int[] diffs, int[] times, long limit){
        int size = diffs.length;
        int start = 1;
        int end = Arrays.stream(diffs).max().getAsInt();
        int level;
        while(start<=end){
            level = (start + end) / 2;
            long timer = times[0];
            int i = 1;
            while(i<size && timer<=limit){
                timer += calculateTime(times[i], times[i-1], diffs[i]-level);
                i++;
            }
            System.out.println("level : " + level);
            System.out.println("timer : " + timer);
            if(timer>limit){
                start = level+1;
            }else{
                answer = Math.min(answer, level);
                end = level-1;
            }
        }       
    }
    public int calculateTime(int now, int prev, int frequency){
        frequency = frequency > 0 ? frequency : 0;
        return (now+prev)*frequency+now;
    }
}