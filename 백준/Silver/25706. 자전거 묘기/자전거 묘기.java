import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int N;
    static int[] jumps, count;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.fill(count, 1);
        for (int i = N - 1; i >= 0; i--) {
            if (i + jumps[i] + 1 <= N-1) {
                count[i] = count[i] + count[i + jumps[i] + 1];
            }
        }
        System.out.println(Arrays.stream(count)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        jumps = new int[N];
        count = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            jumps[i] = Integer.parseInt(st.nextToken());
        }
    }
}