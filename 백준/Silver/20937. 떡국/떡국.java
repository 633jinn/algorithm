import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] plates;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(plates);

        int current = 1;
        int max = 1;
        for (int i = 0; i < N - 1; i++) {
            // sort했을 때, 같은 크기의 개수가 가장 많은 만큼 탑이 생긴다.
            // 예를 들어, 4433321의 경우 아무리 쌓아도 최소 탑의 개수는 3개.(같은 크기의 접시는 겹치지 못하기 때문)
            if (plates[i] == plates[i + 1]) {
                current += 1;
                max = Math.max(max, current);
            } else {
                current = 1;
            }
        }
        System.out.println(max);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        plates = new int[N];
        plates = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}