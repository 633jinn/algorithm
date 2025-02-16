import java.io.*;
import java.util.*;

public class Main {
    static int W;
    static int H;
    static int X;
    static int Y;
    static int P;
    static int answer = 0;
    static Position position;

    static class Position {
        int x;
        int y;

        public Position(int[] p) {
            this.x = p[0];
            this.y = p[1];
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        for (int i = 0; i < P; i++) {
            position = new Position(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());

            if (position.y >= Y && position.y <= Y + H) {
                if (position.x >= X && position.x <= X + W) {
                    // 직사각형 안에 x 위치
                    answer++;
                } else if (position.x >= X - H / 2 && position.x <= X) {
                    // 왼쪽 반원에 위치할 가능성이 있는 경우
                    checkCircle(X, Y + H / 2);
                } else if (position.x >= X + W && position.x <= X + W + H / 2) {
                    // 오른쪽 반원에 위치할 가능성이 있는 경우
                    checkCircle(X + W, H / 2 + Y);
                }
            }
        }
        bw.write(String.valueOf(answer) + "\n");
        bw.flush();
        bw.close();
    }

    private static void checkCircle(int x, int y) {
        double width = Math.pow(position.x - x, 2);
        double height = Math.pow(position.y - y, 2);
        if (Math.sqrt(width + height) <= H / 2) {
            answer++;
        }
    }
}