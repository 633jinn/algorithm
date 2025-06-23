import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list; // 인접 리스트
    static int[][] graph;
    static int n, m;

    public static void main(String[] args) throws Exception {
        input();
        for (int i = 1; i <= n; i++) {
            for (int node : list[i]) {
                dfs(2, i, node);
            }
        }
        int bacon = 1;
        int bacon_sum = Arrays.stream(graph[bacon]).skip(1).sum();
        for (int i = 2; i <= n; i++) {
            int sum =  Arrays.stream(graph[i]).skip(1).sum();
            
            if (bacon_sum>sum) {
                bacon = i;
                bacon_sum = sum;
            }
        }
        System.out.println(bacon);
    }

    private static void dfs(int depth, int startIdx, int endIdx) {
        if (depth == n) {
            return;
        }
        for (int node : list[endIdx]) {
            if (graph[startIdx][node] > graph[startIdx][endIdx] + graph[endIdx][node]) {
                graph[startIdx][node] = graph[startIdx][endIdx] + graph[endIdx][node];
                dfs(depth + 1, startIdx, node);
            }
        }

    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 유저의 수
        m = Integer.parseInt(st.nextToken()); // 친구 관계의 수
        list = new ArrayList[n + 1];
        graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            list[one].add(two);
            list[two].add(one);
            graph[one][two] = 1;
            graph[two][one] = 1;
        }
    }
}
