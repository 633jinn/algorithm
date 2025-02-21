import java.util.*;
import java.io.*;

class Solution {
    static int answer = 0;
    static Queue<Server> queue = new LinkedList();
    
    public class Server{
        int timer;
        int startTime;
        public Server(int timer, int startTime){
            this.timer = timer;
            this.startTime = startTime;
        }
    }
    
    public int solution(int[] players, int m, int k) {

        for(int i = 0; i < 24;i++){
            checkServer(i);
            int needServer = players[i]/m;
            int queueSize = queue.size();
            if(needServer>queueSize){
                for(int j = queueSize; j<needServer;j++){
                    queue.offer(new Server(k, i));
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    //시간이 끝난 서버를 정리한다.
    public void checkServer(int now){
        int size = queue.size();
        for(int i =0;i<size;i++){
            Server s = queue.peek();
            if(s.startTime+s.timer == now){
                queue.poll();
            }
        }
    } 
}