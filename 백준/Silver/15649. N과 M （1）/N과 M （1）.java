import java.io.*;
import java.util.*;

/**
 * 모든 노드에서 모든 노드로 가는 최단 경로 구하기 = 플로이드 와샬
 */
public class Main {
    static int n, m;
    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        input();
        visited = new boolean[n];
        solution(0, new int[m]);
    }

    private static void solution(int idx, int[] arr) {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + 1 + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = i;
                solution(idx + 1, arr);
                visited[i] = false;
            }
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }
}