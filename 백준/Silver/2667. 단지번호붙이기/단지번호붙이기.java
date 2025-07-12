import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static Queue<int[]> queue = new LinkedList<>();
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        input();
        int house = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                    bfs(house++);
                }
            }
        }
        System.out.println(hashMap.size());
        hashMap.values().stream().sorted().forEach(x -> System.out.println(x));
    }

    private static void bfs(int house) {
        int count = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < n && map[x][y] == 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[] { x, y });
                }
            }
        }
        hashMap.putIfAbsent(house, count);
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
    }
}