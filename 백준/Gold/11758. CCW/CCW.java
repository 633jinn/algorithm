import java.io.*;
import java.util.*;

public class Main {

    /**
     * CCW란? Counter-ClockWise의 줄임말, 평면상의 3개의 점의 위치 관계를 판하는 알고리즘
     * 세 점 A(X1, Y1), B(X2, Y2), C(X3, Y3) 이 있다고 가정했을 때
     * CCW = ( X1*Y2 + X2*Y3 + X3*Y1 ) - ( X2*Y1 + X3*Y2 + X1*Y3 )
     * => CCW>0: 반시계, CCW==0: 일직선, CCW<0: 시계방향
     */
    static Pointer pointer1;
    static Pointer pointer2;
    static Pointer pointer3;
    static int answer;

    public static class Pointer {
        int x;
        int y;

        public Pointer(String[] p) {
            this.x = Integer.parseInt(p[0]);
            this.y = Integer.parseInt(p[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        pointer1 = new Pointer(br.readLine().split(" "));
        pointer2 = new Pointer(br.readLine().split(" "));
        pointer3 = new Pointer(br.readLine().split(" "));

        answer = CCW();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    private static int CCW() {

        int first = pointer1.x * pointer2.y + pointer2.x * pointer3.y + pointer3.x * pointer1.y;
        int second = pointer1.y * pointer2.x + pointer2.y * pointer3.x + pointer3.y * pointer1.x;

        if (first - second > 0) {
            return 1; // 반시계
        } else if (first - second == 0) {
            return 0; // 일직선
        } else {
            return -1;// 시계
        }
    }
}