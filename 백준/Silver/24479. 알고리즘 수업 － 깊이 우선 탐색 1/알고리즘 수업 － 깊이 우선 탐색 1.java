import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<Integer>[] graph;
    static int[] visited;
    static Deque<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        input();
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }
        queue.offerFirst(R);
        int count = 1;
        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            if(visited[now] != 0){
                continue;
            }
            visited[now] = count++;
            for (int i = 0; i < graph[now].size(); i++) {
                int node = graph[now].get(i);
                if (visited[node] == 0) {
                    queue.offerFirst(node);
                    continue;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            bw.append(Integer.toString(visited[i]) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
    }
}
