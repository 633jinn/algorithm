import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k, c; // 접시 수, 초밥 가짓수, 연속 접시 수, 쿠폰 번호
    static int[] plates;
    static int start, end; // 투포인터
    static Queue<Integer> eatPlates = new LinkedList<>();
    static HashSet<Integer> set;
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        plates = new int[N];
        for (int i = 0; i < N; i++) {
            plates[i] = Integer.parseInt(br.readLine());
        }

        start = 0;
        end = k - 1;
        for (int i = start; i <= end; i++) {
            eatPlates.offer(plates[i]);
        }
        set = new HashSet<>(eatPlates);
        set.add(c);
        maxCount = Math.max(maxCount, set.size());
        while (end != k-2) {
            start = start == N - 1 ? 0 : start + 1;
            end = end == N - 1 ? 0 : end + 1;
            
            eatPlates.poll();
            eatPlates.offer(plates[end]);
            set = new HashSet<>(eatPlates);
            set.add(c);
            
            maxCount = Math.max(maxCount, set.size());
            if (maxCount == d+1) {
                break;
            }
        }

        bw.write(maxCount + "\n");
        bw.flush();
        bw.close();
    }
}