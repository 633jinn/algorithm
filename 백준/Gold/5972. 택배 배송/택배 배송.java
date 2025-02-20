import java.io.*;
import java.util.*;

public class Main {
    /**
     * 음수 가중치가 없는 문제기 때문에 속도가 빠른 다익스트라를 이용한다.
     * 이때 비교를 위해 Comparable을 사용한다.
     * (Comparable = 자기 자신과 다른 객체 비교, Comparator = 두 객체를 비교)
     * 
     */
    static int N, M;
    static List<Node>[] graph;// 그래프, index를 A_i로 하는 그래프를 만든다.
    static int[] dist; // 시작점에서 각 index까지의 최소 distance를 저장

    // 우선순위 큐
    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

    public static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        // 비교 함수 커스텀
        // PriorityQueue에서 우선순위를 비교하는데 사용.
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // dist를 최대 값으로 초기화
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // graph에 M개만큼 Node가 들어갈 ArrayList 추가
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph에 값 집어넣기
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A_i = Integer.parseInt(st.nextToken()); // 시작 노드
            int B_i = Integer.parseInt(st.nextToken()); // 도착 노드
            int C_i = Integer.parseInt(st.nextToken()); // cost
            //양방향 길 추가
            graph[A_i].add(new Node(B_i, C_i));
            graph[B_i].add(new Node(A_i, C_i));
        }

        Dijkstra();

        bw.write(dist[N] + "\n");
        bw.flush();
        bw.close();
    }

    private static void Dijkstra() {
        dist[1] = 0; // 시작 위치인 1의 distance를 0으로 초기화
        priorityQueue.add(new Node(1, 0));

        while (!priorityQueue.isEmpty()) {

            Node now = priorityQueue.poll();

            for (Node nextNode : graph[now.index]) {
                // now까지의 cost와 nextNode의 cost의 합을 dist의 값과 비교
                int addCost = now.cost + nextNode.cost;
                if (dist[nextNode.index] > addCost) {
                    dist[nextNode.index] = addCost;
                    priorityQueue.add(new Node(nextNode.index, addCost));
                }
            }
        }
    }
}