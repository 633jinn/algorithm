import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] arr;
    static int[][] unite;
    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우 순
    static int[] dy = { 0, 0, -1, 1 };
    static int answer = 0;
    static boolean flag = false;
    static int uniteCount;
    static HashMap<Integer, Integer> people = new HashMap<>();
    static HashMap<Integer, Integer> country = new HashMap<>();
    static Deque<int[]> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        setArr(br, st);
        int move = 0;
        while (true) {
            // 인구 이동 시작
            unite = new int[N][N];
            deque = new LinkedList<>();

            // 인구 이동
            uniteCount = 0;
            flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (unite[i][j] == 0) {
                        deque.offer(new int[] { i, j });
                        uniteCount++;
                        unite[i][j] = uniteCount;
                        country.put(uniteCount, 1);
                        people.put(uniteCount, arr[i][j]);
                        bfs();
                    }
                }
            }
            // 인구 계산
            if (!flag) {
                break;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int u = unite[i][j];
                    arr[i][j] = (int) (people.get(u) / country.get((u)));
                }
            }
            move += 1;
        }
        System.out.println(move);
    }

    private static void setArr(BufferedReader br, StringTokenizer st) throws IOException {
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static boolean isValid(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return true;
        }
        return false;
    }

    private static void bfs() {
        while (!deque.isEmpty()) {
            int[] now = deque.poll();
            int i = now[0];
            int j = now[1];
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (isValid(x, y))
                    continue;
                if (unite[x][y] != 0) {
                    continue;
                }
                int abs = Math.abs(arr[x][y] - arr[i][j]);
                if (abs >= L && abs <= R) {
                    unite[x][y] = unite[i][j];
                    people.merge(unite[x][y], arr[x][y], Integer::sum);
                    country.merge(unite[x][y], 1, Integer::sum);
                    flag = true;
                    deque.offer(new int[] {x,y});
                }
            }
        }
        
    }
}