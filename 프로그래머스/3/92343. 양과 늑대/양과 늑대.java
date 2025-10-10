import java.util.*;

class Solution {
    static ArrayList<Integer>[] node = new ArrayList[18];
    static int answer = 0;
    static int[] INFO;
    public int solution(int[] info, int[][] edges) {
        INFO = info;
        setEdges(edges);
        // for(int i = 0; i< 18 ; i++){
        //     System.out.println(node[i]);
        // }
        ArrayList<Integer> notVisited = new ArrayList<>();
        move(0, 0, 0,notVisited);
        return answer;
    }
    
    public void setEdges(int[][] edges){
        for(int i = 0; i< 18 ; i++)
            node[i] = new ArrayList<>(); 
        for(int[] edge: edges){
            node[edge[0]].add(edge[1]);       
        }
    }
    
    public void move(int now, int sheep, int wolf, ArrayList<Integer> notVisited){   
        if(INFO[now] == 0) sheep++;
        else wolf++;
        
        if(wolf>=sheep) return;
        answer = Math.max(answer, sheep);
        
        notVisited.addAll(node[now]);
        notVisited.remove(Integer.valueOf(now));
        
        for(int i = 0 ; i < notVisited.size() ; i++){
            ArrayList<Integer> nv = new ArrayList<>(notVisited);
            move(notVisited.get(i), sheep, wolf, nv);
        }
    }
}