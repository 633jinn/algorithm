import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Deque<Point> list = new LinkedList<>();

    public static class Point {
        long start;
        long end;

        public Point(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public boolean comparePoint(long start, long end) {
            if (start <= this.end) {
                this.end = this.end > end ? this.end : end;
                return true;
            }
            return false;
        }

        public long calculate() {
            return end - start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        Point now = list.peekLast();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            if (!now.comparePoint(x, y)) {
                Point p = new Point(x, y);
                now = p;
                list.offer(p);
            }
        }
        long result = 0;
        for (Point point : list) {
            result += point.calculate();
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}