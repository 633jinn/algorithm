import java.util.*;
import java.io.*;

/**
1. 징검다리는 일렬, 한번 밟을 때마다 디딤돌 숫자 1씩 줄어든다.
2. 숫자가 0이되면 밟을 수 없다.
3. 가장 가까운 디딤돌로만 건널 수 있다.
4. 한번에 한명씩 이동
*/

class Solution {
    static Deque<Integer> deque = new ArrayDeque<>();
    public int solution(int[] stones, int k) {
        
        int min = 200_000_001;
        
        for(int i = 0; i < stones.length ; i++){
            while(!deque.isEmpty() && stones[deque.peekLast()]<=stones[i])
                deque.pollLast();
            
            deque.offerLast(i);
            
            // 현재 돌보다 값이 작거나 같은 인덱스는 덱 뒤에서 제거
            if(deque.peekFirst()<=i-k)
                deque.pollFirst();
            
            if (i >= k - 1) min = Math.min(min, stones[deque.peekFirst()]);
        }
        return min;
    }
}