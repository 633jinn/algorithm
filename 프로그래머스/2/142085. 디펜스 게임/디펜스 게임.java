import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)->o2-o1);
    
    public int solution(int n, int k, int[] enemy) {
        for(int i = 0; i<enemy.length; i++){
            pq.offer(enemy[i]);
            n-=enemy[i];
            if(n<0){
                if(k>0){
                    int bigEnemy = pq.poll();
                    n += bigEnemy;
                    k--;
                }else{
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}