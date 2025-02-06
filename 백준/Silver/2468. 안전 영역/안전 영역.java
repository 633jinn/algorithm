import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static List<Integer> rains = new ArrayList<>();
    static Stack<Position> stack = new Stack<Position>();

    static int[] moveX = { -1, 1, 0, 0 };
    static int[] moveY = { 0, 0, -1, 1 };

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int num : arr[i]) {
                set.add(num);
            }

        }
        rains.addAll(set);
        rains.sort(null);
        int result = findMaxArea();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static int findMaxArea() {
        int result = 0;
        for (int rain : rains) {
            visited = new boolean[N][N]; // 비 계산 할 때마다 초기화
            int area = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] > rain) {
                        stack.add(new Position(i, j));
                        visited[i][j] = true;
                        dfs(rain);
                        area++;
                    }
                }
            }
            result = Math.max(area, result);
        }
        // 모든 지역의 높이가 같을 때, 최대 영역은 0이 아닌 1

        if (result == 0) {
            result = 1;
        }
        return result;
    }

    private static void dfs(int rain) {
        while (!stack.isEmpty()) {
            Position position = stack.pop();
            for (int i = 0; i < 4; i++) {
                int x = position.x + moveX[i];
                int y = position.y + moveY[i];

                if (x >= 0 && x < N && y >= 0 && y < N) {
                    if (!visited[x][y] && arr[x][y] > rain) {
                        visited[x][y] = true;
                        stack.add(new Position(x, y));
                    }
                }
            }
        }
    }
}