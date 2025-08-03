import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> indexList = new ArrayList<>();
    static int[] visited;
    static Queue<Integer> queue = new LinkedList<>();
        
    public int solution(String begin, String target, String[] words) {
        boolean flag = false;
        for(String s: words){
            if(s.equals(target)){
                flag = true;
                break;
            }
        }
        if(!flag) return 0;
        
        visited = new int[words.length];
        queue.offer(-1);
        while(!queue.isEmpty()){
            int index = queue.poll();
            String s;
            if(index == -1) s = begin;
            else s = words[index];
            System.out.println("S: "+ s);
            
            if(s.equals(target)) 
                return visited[index];
            
            for(int i = 0; i< words.length; i++){
                if(visited[i] == 0 && checkStrings(s, words[i])){
                    if(index == -1) visited[i]= 1;
                    else visited[i] = visited[index]+1;
                    queue.offer(i);
                }
            }
            
        }
        
        
        int answer = 0;
        return answer;
    }
    public boolean checkStrings(String first, String second){
        int count = 0;
        for(int i = 0; i<first.length(); i++){
            if(count>1) return false;
            if(first.charAt(i) != second.charAt(i) ) count++;
        }
        if(count==1) return true;
        return false;
    }
}