import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x;
        int y;
        int broken;

        public Node(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }

    static Deque<Node> deque = new LinkedList<>();
    static int n, m;
    static int[][] map;
    static int[][][] dist;// [x][y][0] : 이 칸에 벽을 부수지 않고 온 최단 거리, [x][y][1] : 이 칸에 벽을 한 번 부수고 온 최단 거리
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {
        input();
        dist[1][1][0] = 1;
        deque.offer(new Node(1, 1, 0));

        while (!deque.isEmpty()) {
            Node node = deque.poll();
            if (node.x == n && node.y == m) {
                System.out.println(dist[n][m][node.broken]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];

                int nextBroken = node.broken;
                if (isValid(x, y, node)) {
                    if (map[x][y] == 1) {
                        if (node.broken == 1)
                            continue;
                        nextBroken = 1;
                    }
                    if (dist[x][y][nextBroken] == 0) {
                        dist[x][y][nextBroken] = dist[node.x][node.y][node.broken] + 1;
                        deque.offer(new Node(x, y, nextBroken));
                    }
                }
            }
        }
        System.out.println("-1");
    }

    private static boolean isValid(int x, int y, Node node) {
        if (x < 1 || x > n || y < 1 || y > m) {// 맵의 범위를 넘어가면
            return false;
        }
        return true;
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        dist = new int[n + 1][m + 1][2];
        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = Integer.parseInt(strings[j]);
            }
        }
    }
}