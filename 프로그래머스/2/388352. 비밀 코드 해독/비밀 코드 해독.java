import java.util.*;

class Solution {
    static List<Integer> secretCode = new ArrayList<>();
    static int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        boolean[] visited = new boolean[n+1];
        backTracking(1, secretCode, q, ans, n, visited);
        
        return answer;
    }
    //num_idx = [1, 2, 3, 4, 5]의 인덱스
    public void backTracking(int num, List<Integer> secretCode, int[][] q, int[] ans, int n, boolean[] visited){
        
        if(secretCode.size() == 5){
            answer++;
            // System.out.println(secretCode.toString());
            return;
        }
        for(int i = num; i <= n ; i++){
            // System.out.println(i);
            if(visited[i]) 
                continue;
            secretCode.add(i);
            boolean flag = true;
            // 비밀 코드 시도 체크
            for(int j = 0; j< q.length; j++){
                int correct = checkSecretCode(q[j], secretCode);
                if((secretCode.size()!= 5 && ans[j] < correct) || 
                        (secretCode.size() == 5 && ans[j] != correct)){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                secretCode.remove(secretCode.size()-1);
                continue;
            }
            visited[i] = true;
            backTracking(i+1, secretCode, q, ans, n, visited);
            visited[i] = false;
            secretCode.remove(secretCode.size()-1);
        }
    }
    public int checkSecretCode(int[] q, List<Integer> secretCode){
        int count = 0;
        for(int i = 0; i<5; i++){
            if(secretCode.contains(q[i]))
                count++;
        }
        
        return count;
    }
}