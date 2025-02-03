import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int firstNum = Integer.parseInt(st.nextToken());
        int secondNum = Integer.parseInt(st.nextToken());

        int result= 0;

        for (int round = 0; round < calculate(N); round++) {
            if (firstNum == secondNum) {
                break;
            }
            firstNum = calculate(firstNum);
            secondNum = calculate(secondNum);
            result++;
        }
        if (result == 0) {
            result = -1;
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static int calculate(int num) {
        return num / 2 + num % 2;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}