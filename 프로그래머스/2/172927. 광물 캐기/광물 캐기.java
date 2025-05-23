import java.util.*;
class Solution {
    static class Mineral_5{
        // 곡괭이 별로 미네랄을 5개 캤을 때의 피로도
        private int dia;
        private int iron;
        private int stone;
        
        public Mineral_5(int dia, int iron, int stone){
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }

    static List<Mineral_5> list= new ArrayList<>();
    static int[][] scoreBoard;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        // 다이아, 철, 돌 순
        scoreBoard = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        int totalPicks = Arrays.stream(picks).sum();
        
        for(int i = 0; i<minerals.length;i+=5){
            if(totalPicks == 0) break;
            
            int dia = 0, iron = 0, stone = 0;
            for(int j = i; j<i+5; j++){
                if(j == minerals.length) break;
                
                String mineral = minerals[j];
                
                int val = mineral.equals("diamond")? 0:mineral.equals("iron")?1:2;
                dia += scoreBoard[0][val];
                iron += scoreBoard[1][val];
                stone += scoreBoard[2][val];
            }
            list.add(new Mineral_5(dia, iron, stone));
            totalPicks--;
        }
        
        Collections.sort(list, ((o1, o2) -> (o2.stone - o1.stone)));
        for(Mineral_5 m : list){
            int dia = m.dia;
            int iron = m.iron;
            int stone = m.stone;
            
            if(picks[0] > 0) {
                answer += dia;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0) {
                answer += iron;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0) {
                answer += stone;
                picks[2]--;
                continue;
            }
        }
        
        
        return answer;
    }
}