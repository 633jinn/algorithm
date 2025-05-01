import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] boxes;
    static int[] count;
    static int maxCount = 0;

    public static void main(String[] args) throws Exception {
        input();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) { // 이전 박스들이랑 비교
                if (boxes[i] > boxes[j]) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
            maxCount = Math.max(maxCount, count[i]);
        }
        System.out.println(maxCount);
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        boxes = new int[n];
        count = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
            count[i] = 1;
        }
    }

}