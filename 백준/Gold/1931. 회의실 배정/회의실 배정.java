import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        }
    });

    public static void main(String[] args) throws Exception {
        input();
        int end = 0;
        int count = 0;
        /**
         * for (int[] set : pq)
         * 이렇게 PriorityQueue를 foreach문으로 돌릴 경우
         * 우선순위정렬되어 나오지 않기 때문에 반드시 for문으로 poll()하여 값을 받아야 함.
         */
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            int[] set = pq.poll();
            if (end <= set[0]) {
                end = set[1];
                count++;
            }
        }

        System.out.println(count);
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            pq.offer(new int[] { key, value });
        }
    }
}