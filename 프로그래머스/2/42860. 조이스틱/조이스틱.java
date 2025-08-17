import java.io.*;
class Solution {
    static char A = (char) 65;
    static char Z = (char) 90;
    public int solution(String name) {
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        int count_A = 0;
        for(int i = 0; i<name.length();i++){
            if(name.charAt(i)==A){
                count_A++;
                continue;
            }
            if(Math.abs(name.charAt(i)-A)<Math.abs(name.charAt(i)-Z)){
                sum+=Math.abs(name.charAt(i)-A);
            }else{
                sum+=Math.abs(name.charAt(i)-Z)+1;
            }
        }
        if(name.length()==1) return sum;
        if(count_A == name.length()) return 0;
        
        System.out.println(sum);
        // 2. 좌우 이동 최적화
        int leftRight = 10000000;
        for (int i = 0; i < name.length(); i++) {
            int next = i + 1;
            
            // 연속된 A 구간 찾기
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            
            // 3가지 이동 패턴 비교
            // 패턴 1: 오른쪽으로만 (기본값 n-1)
            // 패턴 2: i까지 오른쪽 → 뒤로 돌아가서 끝에서 왼쪽으로
            // 패턴 3: 처음에 왼쪽으로 → 다시 오른쪽으로 i까지
            
            leftRight = Math.min(leftRight, 
                Math.min(
                    i * 2 + name.length() - next,        // 오른쪽 → 왼쪽
                    (name.length() - next) * 2 + i       // 왼쪽 → 오른쪽
                )
            );
        }
        
        return sum+leftRight;
    }
}