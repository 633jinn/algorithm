import java.util.*;

class Solution {
    static int start, end;
    static int difference = Integer.MAX_VALUE;
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, k};
        int sum = sequence[0];
        while(start<=end){
            
            if(sum<=k){
                if(sum==k && answer[1]-answer[0]>end-start){
                    answer[0] = start;
                    answer[1] = end;
                }
                end++;
                if(end==sequence.length) break;
                sum += sequence[end];
            }else{
                sum -= sequence[start];
                start++;
            }
        }
        
        return answer;
    }
}