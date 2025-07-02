import java.util.*;
class Solution {
    static boolean[][] board;
    static int answer = 0;
    static class Queen{
        int x; 
        int y;
        public Queen(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Deque<Queen> deque = new LinkedList<>();
    public int solution(int n) {
        board = new boolean[n+1][n+1];
        backTracking(1,1,n);
        return answer;
    }
    public void backTracking(int x, int y, int n){
        if(deque.size() == n){
            answer += 1;
            return;
        }
        
        for(int j = 1; j<=n; j++){
            boolean flag = true;
            for(Queen q : deque){
                if(Math.abs(q.x-x) == Math.abs(q.y-j)) flag = false;
                if(q.x == x) flag = false;
                if(q.y == j) flag = false;
            }
            if(flag) {
                deque.offerLast(new Queen(x, j));
                backTracking(x+1, j, n);
                deque.pollLast();
             }
        }
    }
}