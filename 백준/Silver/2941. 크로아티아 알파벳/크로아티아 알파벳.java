import java.io.*;
import java.util.*;

public class Main {

    static List<String> croatia = new ArrayList<>(Arrays.asList("c=", "c-", "d-", "lj", "nj", "s=", "z="));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        int answer = 0;
        while (str.length()>=2) {
            if (croatia.contains(str.substring(0, 2))) {
                answer++;
                str = str.substring(2);
            } else if(str.length()>=3 && str.substring(0, 3).equals("dz=")){
                answer++;
                str = str.substring(3);
            }else{
                sb.append(str.charAt(0));
                str = str.substring(1);
            }
        }
        String newStr = sb.append(str).toString();
        System.out.println(answer + newStr.length());
    }
}