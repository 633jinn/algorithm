import java.util.*;
import java.util.Map.Entry;
class Solution {
    static List<Robot> robots = new ArrayList<>();
    static HashMap<Position, Integer> map = new HashMap<>();
    
    static class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Position point = (Position) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    static class Robot{
        Position position;
        
        Queue<Position> goals = new LinkedList();
        Robot(int[] arr){
            position = new Position(arr[0], arr[1]);
        }
        void setGoal(int[] arr){
            goals.offer(new Position(arr[0], arr[1]));
        }
        boolean move(){
            Position goal = goals.peek();
            int goalR = goal.x;
            int goalC = goal.y;
            if(position.x != goalR){
                position.x = position.x>goalR?position.x-1:position.x+1;
            }else if(position.y != goalC){
                position.y = position.y > goalC ? position.y-1:position.y+1;
            }
            return isGoal();
        }
        boolean isGoal(){
            Position goal = goals.peek();
            if(position.x == goal.x && position.y == goal.y){
                goals.poll();
                if(goals.isEmpty()){
                    return true;
                }
            }
            return false;
        }
        Position getPosition(){
            return position;
        }
    }
    public int solution(int[][] points, int[][] routes) {
        int count = routes[0].length;
        for(int i = 0; i<routes.length;i++){
            int[] arr = points[routes[i][0]-1];
            Robot r = new Robot(arr);
            for(int j = 0; j<count;j++){
                arr = points[routes[i][j]-1];
                r.setGoal(arr);
            }
            robots.add(r);
        }
        
        int answer = 0;
        List<Robot> lst = new ArrayList<>();
        for(int i = 0; i<count;i++){
            while(lst.size() != robots.size()){
                map.clear(); 
                for(int j = 0; j<robots.size();j++){
                    Robot robot = robots.get(j);
                    if(lst.contains(robot)){
                        continue;
                    }
                    
                    if(robot.move()){
                        lst.add(robot);
                    }
                    Position position = robot.getPosition();
                    map.put(position, map.getOrDefault(position, 0)+1);
                }
                for(Entry<Position, Integer> set: map.entrySet()){
                    if(set.getValue()>1){
                        answer++;
                    }
                }
            }
        }
        
        
        return answer;
    }
}