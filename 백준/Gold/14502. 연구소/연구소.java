import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static String[][] map;
    static int[] dx = { 0, 0, -1, 1 };// 왼쪽, 오른쪽, 위, 아래
    static int[] dy = { -1, 1, 0, 0 };
    static Queue<int[]> virus = new ArrayDeque<>();
    static int wallCount = 0;
    static int emptyCount = 0;
    static int virusCount = 64;

    public static void main(String[] args) throws Exception {
        input();
        if (emptyCount == 3) {
            System.out.println(0);
            return;
        }
        backTracking(0, 0, 0);
        System.out.println(n * m - virusCount - wallCount - 3);
    }

    private static void backTracking(int wall, int x, int y) {
        if (wall == 3) {
            countSafeArea();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < x && j < y)
                    continue;
                if (map[i][j].equals("0")) {
                    map[i][j] = "1";
                    backTracking(wall + 1, i, j);
                    map[i][j] = "0";
                }
            }
        }
    }

    private static void countSafeArea() {
        int count = virus.size();
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> virusForCount = new ArrayDeque<>(virus); // 내부 값이 바뀌지 않기 때문에 얕은 복사 문제 없음.
        while (!virusForCount.isEmpty()) {
            int[] v = virusForCount.poll();
            visited[v[0]][v[1]] = true;
            if (virusCount <= count)
                break;
            for (int i = 0; i < 4; i++) {
                int x = v[0] + dx[i];
                int y = v[1] + dy[i];
                if (x < 0 || y < 0 || x >= n || y >= m)
                    continue;
                if (!visited[x][y] && map[x][y].equals("0")) { // 접근한적 없고, 빈칸일 경우 offer
                    visited[x][y] = true;
                    virusForCount.offer(new int[] { x, y });
                    count++;
                }
            }
        }
        virusCount = Math.min(virusCount, count);
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = strings[j];
                switch (strings[j]) {
                    case "2":
                        virus.offer(new int[] { i, j });
                        break;
                    case "1":
                        wallCount++;
                        break;
                    case "0":
                        emptyCount++;
                }
            }
        }
    }
}