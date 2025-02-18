import java.io.*;
import java.util.*;

public class Main {
    /**
     * 최대 사용할 수 있는 회의가 최대 => 끝나는 시간이 짧은 순으로 정렬이 필요
     * Comparator를 재정의하여 이용
     */

    static int N;
    static List<int[]> meetingList = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            meetingList.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        // 끝나는 시간이 짧은 순으로 sort
        Collections.sort(meetingList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) { // 종료 시간이 같을 때,
                    return o1[0] - o2[0]; // 오름차순 o1[0] - o2[0] 내림차순 o2[0] - o1[0]
                }
                return o1[1] - o2[1];
            }
        });

        greedy();

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static void greedy() {
        int lastTime = 0;
        for (int i = 0; i < N; i++) {
            int[] meeting = meetingList.get(i);
            if (lastTime <= meeting[0]) {
                lastTime = meeting[1];
                result++;
            }
        }
    }
}