package java_folder;

import java.io.*;
import java.util.*;

public class 단어_정렬 {
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            boolean isExist = words.contains(word);
            if (!isExist) {
                words.add(word);
            }
        }
        int arrListSize = words.size();
        String[] arrList = words.toArray(new String[arrListSize]);
        Arrays.sort(arrList, (o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());
        for (String word : arrList) {
            bw.write(word + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
