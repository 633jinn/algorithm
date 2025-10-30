import java.util.*;
class Solution {
    PriorityQueue<Home> deliver, pick;
    class Home{
        int idx;
        int count;
        public Home(int idx, int count){
            this.idx = idx;
            this.count = count;
        }
    }
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        deliver = new PriorityQueue<>((o1, o2) -> o2.idx - o1.idx);
        pick = new PriorityQueue<>((o1, o2) -> o2.idx - o1.idx);
        for(int i =0; i<deliveries.length; i++){
            if(deliveries[i]!=0)
                deliver.offer(new Home(i, deliveries[i]));
            if(pickups[i]!=0)
                pick.offer(new Home(i, pickups[i]));
        }
        
        while((!deliver.isEmpty() || !pick.isEmpty())){
            int dcap = 0;
            int pcap = 0;
            int maxlength = 0;
            //배달할 것들 부터
            while(!deliver.isEmpty()){
                Home h = deliver.peek();
                maxlength = Math.max(maxlength, h.idx+1);
                if(dcap+h.count>cap){
                    h.count -= cap-dcap;
                    dcap = cap;
                    deliveries[h.idx] = h.count;
                    break;
                }else{
                    dcap += h.count;
                    deliver.poll();
                    deliveries[h.idx] = 0;
                }
            }
            while(!pick.isEmpty()){
                Home h = pick.peek();
                maxlength = Math.max(maxlength, h.idx+1);
                if(pcap+h.count>cap){
                    h.count -= cap-pcap;
                    pcap = cap;
                    pickups[h.idx] = h.count;
                    break;
                }else{
                    pcap += h.count;
                    pick.poll();
                    pickups[h.idx] = 0;
                }
            }
            answer += maxlength*2; 
        }
        
        return answer;
    }
}
