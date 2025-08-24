import java.util.*;
class Solution {
    public HashMap<String, Integer> map = new HashMap<>();
    public int[] solution(String[] gems) {
        int types = findTypes(gems, 0, gems.length-1);
        
        int start = 0;
        int end = 0;
        int[] answer = new int[]{0, gems.length};
        map.put(gems[0], 1);
        int gemCount = 1;
        while(start<=end){
            if(gemCount != types){
                if(end>=gems.length-1) break;
                
                end++;
                int before = map.get(gems[end]);
                if(before == 0)
                    gemCount++;
                map.put(gems[end], before+1);
            }else{
                if(end-start < answer[1]-answer[0]){
                    answer[0] = start;
                    answer[1] = end;
                }
                if(end-start+1 == types) break;
                
                int before = map.get(gems[start]);
                if(before==1)
                    gemCount--;
                map.put(gems[start], before-1);
                start++;
            }
        }
        answer[0]++;
        answer[1]++;
        return answer;
    }
    public int findTypes(String[] gems,int start, int end){
        HashSet<String> set = new HashSet<>();
        for(int i = start; i<= end; i++){
            if(!map.containsKey(gems[i])) map.put(gems[i], 0);
        }
        return map.size();
    }
}