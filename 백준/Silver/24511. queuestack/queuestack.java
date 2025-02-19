import java.io.*;
import java.util.*;

public class Main {
    /**
     * 시간 복잡도를 중요하게 생각해야하는 문제, On(NM)이면 시간초과가 뜬다.
     * Stack이 있을 경우 넣은 값이 바로 빠지기 때문에 없는 queuestack으로 간주한다.
     * 또한 idx를 이용해, 마지막 idx에 input값을 넣고 이전 값을 출력한 뒤,
     * idx를 옮겨주는 형태로 진행하면 속도를 최적화 할 수 있다.
     * 
     * StringBuilder를 이용해 더욱 최적화
     */

    static int N;// queeuestack 의 길이
    static String[] type;
    static ArrayList<String> queuestackList = new ArrayList<>();
    static int size = 0;
    static int M; // 삽입할 수열의 길이
    static String nums; // 수열

    static String result = "";

    public static void main(String[] args) throws IOException {

        input();
        solution();
        output();
    }

    private static void solution() {
        StringBuilder stringBuilder = new StringBuilder();

        if (size != 0) { // queuestack에 queue가 존재하면
            StringTokenizer st = new StringTokenizer(nums, " ");
            int lastIdx = size - 1;
            for (int i = 0; i < M; i++) {
                String num = st.nextToken();
                stringBuilder.append(queuestackList.get(lastIdx) + " ");
                queuestackList.set(lastIdx, num);
                lastIdx = lastIdx > 0 ? lastIdx - 1 : size - 1;
            }
            result = stringBuilder.toString();
        } else {
            result = nums;
        }
    }

    private static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        type = br.readLine().split(" ");

        queuestackList.ensureCapacity(N); // arrayList 크기 고정
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String string = st.nextToken();
            if (type[i].equals("0")) {
                queuestackList.add(string);
                size++;
            }
        }

        M = Integer.parseInt(br.readLine());
        nums = br.readLine();
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}