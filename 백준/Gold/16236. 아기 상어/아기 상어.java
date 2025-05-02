import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static PriorityQueue<Shark> queue = new PriorityQueue<>();

    static int x, y, move;
    static int size = 2;
    static int eat = 0;
    static int[] moveX = { -1, 0, 1, 0 };// 상,좌,하,우
    static int[] moveY = { 0, -1, 0, 1 };

    public static class Shark implements Comparable<Shark> {
        int move = 0;
        int row;
        int column;

        public Shark(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public Shark(int row, int column, int move) {
            this.row = row;
            this.column = column;
            this.move = move;
        }

        @Override
        public int compareTo(Shark s) {
            if (this.move != s.move) return this.move - s.move;
            if (this.row != s.row) return this.row - s.row;
            return this.column - s.column;
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        while (true) {
            boolean[][] visited = new boolean[n][n];
            queue.clear();
            queue.offer(new Shark(x, y));
            visited[x][y] = true;
            boolean flag = false;
            while (!queue.isEmpty()) {
                Shark shark = queue.poll();
                x = shark.row;
                y = shark.column;
                if (arr[x][y] != 0 && arr[x][y] < size) { // 먹이가 있으면서 상어의 사이즈가 작을 때
                    arr[x][y] = 0;
                    eat++;
                    move += shark.move;
                    flag = true;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nowX = x + moveX[i];
                    int nowY = y + moveY[i];

                    if (nowX < 0 || nowY < 0 || nowX >= n || nowY >= n || visited[nowX][nowY]
                            || arr[nowX][nowY] > size) {
                        continue;
                    }
                    queue.add(new Shark(nowX, nowY, shark.move + 1));
                    visited[nowX][nowY] = true;
                }
            }
            if (!flag) {
                break;
            }

            if (size == eat) {
                eat = 0;
                size++;
            }

        }
        System.out.println(move);
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    // queue.offer(new Shark(i, j));
                    x = i;
                    y = j;
                    arr[i][j] = 0;
                }
            }
        }

    }

    public static boolean checkPosition(int row, int column) {
        if (0 > row || row >= n) {
            return false;
        }
        if (0 > column || column >= n) {
            return false;
        }
        return true;
    }
}
