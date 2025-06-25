import java.util.*;
class Solution {
    static int[][] tree;
    
    public int solution(int[][] triangle) {
        tree = new int[triangle.length][triangle.length];
        tree[0][0] = triangle[0][0];
        for(int i = 0; i< triangle.length-1;i++){
            for(int j = 0; j<triangle[i].length ;j++){
                tree[i+1][j] = Math.max(tree[i+1][j], triangle[i+1][j]+tree[i][j]);
                tree[i+1][j+1] = Math.max(tree[i+1][j+1], triangle[i+1][j+1]+tree[i][j]);
            }            
        }
        
        
        
        int answer = 0;
        for(int t: tree[triangle.length-1]){
            answer = Math.max(answer, t);
        }
        return answer;
    }
}