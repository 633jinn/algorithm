import java.util.*;
import java.util.Deque.*;

class Solution {
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static Deque<Node> deque = new LinkedList<>();
    
    static String[] answer;
    static int index = 0;
    
    static class Node implements Comparable<Node>{
        String name;
        String start;
        int playtime;
        public Node(String name, String start, String playtime){
            this.name = name;
            this.start = start;
            this.playtime = Integer.parseInt(playtime);
        }
        
        @Override
        public int compareTo(Node node){
            return this.start.compareTo(node.start);
        }
    }
    
    public String[] solution(String[][] plans) {
        answer = new String[plans.length];
        for(String[] plan : plans){
            pq.offer(new Node(plan[0], plan[1], plan[2]));
        }
        
        //시작해야하는 과제 처리
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(pq.isEmpty()){
                answer[index] = now.name;
                index++;
                continue;
            }
            Node next = pq.peek();
            System.out.println(now.name);
            System.out.println(now.start);
            System.out.println(next.start);
            
            int leftTime = calculateTime(now.start, next.start);
            if(now.playtime<=leftTime){
                answer[index] = now.name;
                index++;
                leftTime -= now.playtime;
                while(leftTime>0 && !deque.isEmpty()){
                    Node left = deque.pollFirst();
                    if(left.playtime<=leftTime){
                        answer[index] = left.name;
                        index++;
                        leftTime -= left.playtime;
                    }else{
                        left.playtime-=leftTime;
                        deque.offerFirst(left);
                        leftTime = 0;
                    }
                }
            }else{
                now.playtime-=leftTime;
                deque.offerFirst(now);
            }
//             for(Node o: pq){
//                 System.out.println(o.name);
//             }
            
//             System.out.println("------");
//             for(Node o: deque){
//                 System.out.println(o.name);
//             }
            
        }
        //남은 과제 처리
        while(!deque.isEmpty()){
            Node now = deque.pollFirst();
            answer[index] = now.name;
            index++;
        }
        
        
        return answer;
    }
    public int calculateTime(String str1, String str2){
        String[] time1 = str1.split(":");
        String[] time2 = str2.split(":");
        return (Integer.parseInt(time2[0])*60+Integer.parseInt(time2[1])) - (Integer.parseInt(time1[0])*60+Integer.parseInt(time1[1]));
    }
}