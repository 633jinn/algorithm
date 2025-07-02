import java.util.*;
class Solution {
    static class Mineral implements Comparable<Mineral>{
        ArrayList<String> list;
        int dia = 0;
        int iron = 0;
        int stone = 0;
        public Mineral(ArrayList<String> list, int dia, int iron, int stone){
            this.list = list;
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
        
        @Override
        public int compareTo(Mineral m){
            if(m.stone==this.stone){
                if(m.iron== this.iron){
                    // return m.dia - this.dia;
                    return this.dia - m.dia;
                }
                // return m.iron - this.iron;
                return this.iron - m.iron;
            }
            return m.stone - this.stone;
        }
    }
    // static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
    static PriorityQueue<Mineral> pq = new PriorityQueue<>();


    static int[][] work = {{1,1,1}, {5,1,1}, {25,5,1}};
    
    static int dia = 0;
    static int iron = 0;
    static int stone = 0;
    
    public int solution(int[] picks, String[] minerals) {
        //picks = 곡괭이 개수(dia, iron, stone), minerals = 광물의 순서
        int count = 0;
        ArrayList<String> list = new ArrayList<>();
        int sumPicks = picks[0]+picks[1]+picks[2];
        for(int i = 0; i<minerals.length; i++){
            if(pq.size()==sumPicks) break;
            if(i!=0 && i%5==0){
                pq.offer(new Mineral(list, dia, iron, stone));
                list = new ArrayList<>();
                dia = 0;
                iron = 0;
                stone = 0;
            }
            if(minerals[i].equals("diamond")) addCount(0);
            else if(minerals[i].equals("iron")) addCount(1);
            else addCount(2);
            list.add(minerals[i]);
        }
        if(pq.size()<sumPicks)       
            pq.offer(new Mineral(list, dia, iron, stone));
        int idx = 0;
        int answer = 0;
        while(!pq.isEmpty() && idx<3){
            if(picks[idx] == 0) {idx++; continue;}
            Mineral mineral = pq.poll();
            System.out.println(mineral.list);
            for(String m : mineral.list){
                if(m.equals("diamond")) answer += work[idx][0];
                else if(m.equals("iron")) answer += work[idx][1];
                else answer += work[idx][2];
            }
            picks[idx] -= 1;
        }
        
        return answer;
    }
    public void addCount(int idx){
        dia += work[0][idx];
        iron += work[1][idx];
        stone += work[2][idx];
    }
}