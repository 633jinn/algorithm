import java.io.*;
import java.util.*;

public class Main {
    static int N, E;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static List<Node>[] graph;
    static int INF = 200000000;
    static int v1, v2;
    static int[] distance;

    public static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<Node>();
        }
        for (int i = 1; i < E + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        long result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
        long answer = Math.min(result1, result2);
        if (result1 >= INF || result2 >= INF) {
            answer = -1;
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    private static int dijkstra(int start, int end) {
        pq.add(new Node(start, 0));
        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int cost = node.cost;
            for (int i = 0; i < graph[index].size(); i++) {
                Node newNode = graph[index].get(i);
                int newIndex = newNode.index;
                if (distance[newIndex] > newNode.cost + cost) {
                    distance[newIndex] = newNode.cost + cost;
                    pq.add(new Node(newIndex, distance[newIndex]));
                }
            }
        }
        return distance[end];
    }

}