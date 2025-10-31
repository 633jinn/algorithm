import java.util.*;
class Solution {
    boolean[][] visit = new boolean[101][101];
    int[] movex = new int[]{0,0,1,-1};
    int[] movey = new int[]{1,-1,0,0};
    class Robot {
        int x;
        int y;
        int dir;
        int count;
        public Robot(int x, int y, int dir, int c){
            this.x = x;
            this.y = y;
            this.dir = dir;
            count = c;
        }
    }
    // Deque<Robot> q = new ArrayDeque<>();
    
    PriorityQueue<Robot> q = new PriorityQueue<>((r1, r2) -> (r1.count-r2.count));
    int Row, Column;
    char[][] Board;
    public int solution(String[] board) {
        Row = board.length;
        Column = board[1].length();
        Board = new char[Row][Column];
        
        for(int i =0; i<Row; i++){
            for(int j = 0; j<Column; j++){
                Board[i][j] = board[i].charAt(j);
            }
        }
        
        findStart();
        
        while(!q.isEmpty()){
            Robot robot = q.poll();
            if(Board[robot.x][robot.y] == 'G') return robot.count;
            
            
            for(int i =0; i<4;i++){
                if(i == robot.dir) continue;
                int x = robot.x;
                int y = robot.y;
                while(true){
                    x = x+movex[i];
                    y = y+movey[i];
                    if(x<0||y<0||x>=Row||y>=Column || Board[x][y] == 'D'){
                        x -= movex[i];
                        y -= movey[i];
                        if(!visit[x][y]){
                            visit[x][y] = true;
                            q.offer(new Robot(x, y, i, robot.count+1));
                        }
                        break;
                    }
                }
            }
            
        }
        
        return -1;
    }
    void findStart(){
        for(int i =0; i<Row; i++){
            for(int j = 0; j<Column; j++){
                if(Board[i][j] == 'R'){
                    q.offer(new Robot(i, j, -1, 0));
                    return;
                }
            }
        }
    }
}