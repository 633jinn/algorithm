import java.io.*;
import java.util.*;

public class Main {
    static int[][] maze;
    static boolean[][] visited;
    static PriorityQueue<Move> pq = new PriorityQueue<>((o1, o2) -> {
        return o1.wall - o2.wall;
    });
    static int n, m;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    static class Move {
        int x;
        int y;
        int wall;

        public Move(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        pq.offer(new Move(1, 1, 0));
        visited[1][1] = true;
        while (!pq.isEmpty()) {
            Move move = pq.poll();
            int x = move.x;
            int y = move.y;
            int wall = move.wall;
            if (x == n && y == m) {
                System.out.println(wall);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];
                if (isValid(moveX, moveY) && !visited[moveX][moveY]) {
                    visited[moveX][moveY] = true;
                    if (maze[moveX][moveY] == 1)
                        pq.offer(new Move(moveX, moveY, wall + 1));
                    else
                        pq.offer(new Move(moveX, moveY, wall));
                }
            }
        }
    }

    private static boolean isValid(int moveX, int moveY) {
        if (moveX > n || moveX < 1) {
            return false;
        }
        if (moveY > m || moveY < 1) {
            return false;
        }
        return true;
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        maze = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] string = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                maze[i][j + 1] = Integer.parseInt(string[j]);
            }
        }
    }
}