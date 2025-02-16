import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] line;
    static List<Integer> indexList = new ArrayList<>();
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        line = new int[N];
        for (int i = 0; i < N; i++) {
            indexList.add(i);
        }
        int[] counts = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N; i++) {
            index = indexList.get(counts[i]);
            line[index] = i;
            indexList.remove(counts[i]);
        }

        for (int index : line) {
            bw.write(index + 1 + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}