import java.util.*;
class Solution {
    static class Bridge{
        int land1;
        int land2;
        int cost;
        public Bridge(int l1, int l2, int cost){
            land1 = l1;
            land2 = l2;
            this.cost = cost;
        }
    }
    static PriorityQueue<Bridge> pq = new PriorityQueue<Bridge>((o1,o2) -> o1.cost - o2.cost);
    static int[] parents;
    public int solution(int n, int[][] costs) {
        if(n==1) return 0;
        
        parents = new int[n];
        for(int i = 0; i<n;i++) parents[i] = i;
        for(int i = 0; i<costs.length; i++){
            pq.offer(new Bridge(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        int answer = 0;
        
        while(!pq.isEmpty()){
            Bridge b = pq.poll();
            
            int land1_P = findParent(b.land1);
            int land2_P = findParent(b.land2);
            if(land1_P != land2_P){
                union(b.land1, b.land2);
                answer += b.cost;
            }
        }
        
        return answer;
    }
    public int findParent(int children){
        if(parents[children] == children) return children;
        parents[children] = findParent(parents[children]);
        return parents[children];
    }
    
    // 같은 그룹에 속하도록 parents 수정
	public void union(int x, int y) {
		x = findParent(x); 
		y = findParent(y); 
		// 더 find 값으로 부모 노드 설정
	    if (x < y) { 
	    	parents[y] = x; 
	    } 
	    else { 
	    	parents[x] = y; 
	    } 
	}
}