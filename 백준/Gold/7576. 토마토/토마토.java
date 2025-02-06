import java.io.*;
import java.util.*;

public class Main {
    static int M; // column
    static int N; // row
    static int[][] box; // 토마토의 상태 저장, visited로도 이용용
    static Queue<Tomato> queue = new LinkedList<Tomato>();

    static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new Tomato(i, j, 0));
                }
            }
        }

        int result = bfs();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static int bfs() {
        int day = 0;

        // bfs
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            int x = tomato.x;
            int y = tomato.y;
            day = tomato.day;
            if (x > 0 && box[x - 1][y] == 0) {
                queue.add(new Tomato(x - 1, y, day + 1));
                box[x-1][y] = 1;
            }
            if (x < N - 1 && box[x + 1][y] == 0) {
                queue.add(new Tomato(x + 1, y, day + 1));
                box[x+1][y] = 1;
            }
            if (y > 0 && box[x][y - 1] == 0) {
                queue.add(new Tomato(x, y - 1, day + 1));
                box[x][y-1] = 1;
            }
            if (y < M - 1 && box[x][y + 1] == 0) {
                queue.add(new Tomato(x, y + 1, day + 1));
                box[x][y+1] = 1;
            }
        }

        // 익지 않은 토마토가 있는지 확인
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    flag = false;
                }
            }
        }
        if (flag) {
            return day;
        } else {
            return -1;
        }
    }
}