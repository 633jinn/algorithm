import java.io.*;
import java.util.*;

public class Main {
    /**
     * 다익스트라를 이용한 알고리즘
     */

    static int M, N;
    static int[][] dist;
    static int[][] graph;
    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    static int[] moveX = { 0, 0, -1, 1 };// 상하좌우
    static int[] moveY = { 1, -1, 0, 0 };

    public static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][M + 1];
        graph = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i < N + 1; i++) {
            String[] str = br.readLine().split("");
            for (int j = 1; j < M + 1; j++) {
                if (str[j - 1].equals("1")) {
                    graph[i][j] = 1;
                }
            }
        }

        priorityQueue.add(new Node(1, 1, 0));
        if (!(N == 1 && M == 1)) {
            dijkstra();
            bw.write(dist[N][M] + "\n");
        }else{
            bw.write(0 + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void dijkstra() {
        while (!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();
            for (int i = 0; i < 4; i++) {
                int x = now.x + moveX[i];
                int y = now.y + moveY[i];
                if (checkPosition(x, y)) {
                    continue;
                }
                if (graph[x][y] == 0 && dist[x][y] > now.cost) { // 빈방일 때,
                    dist[x][y] = now.cost;
                    priorityQueue.offer(new Node(x, y, now.cost));
                } else if (graph[x][y] == 1 && dist[x][y] > now.cost + 1) {// 벽을 뚫어야할 떄,
                    dist[x][y] = now.cost + 1;
                    priorityQueue.offer(new Node(x, y, now.cost + 1));
                }
            }
        }
    }

    // 맵 밖으로 나갔는지 확인
    private static boolean checkPosition(int x, int y) {
        if (x < 1 || x > N) {
            return true;
        }
        if (y < 1 || y > M) {
            return true;
        }
        return false;
    }
}