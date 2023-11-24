import java.io.*;
import java.util.*;

public class boj11478 {
    public static void main(String args[]) throws IOException {
        int i,j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> strMap = new HashMap<>();

        String input= br.readLine();
        for (i = 0; i < input.length(); i++) {
            for (j = i+1; j <= input.length(); j++) {
                String newStr = input.substring(i, j);
                strMap.put(newStr, 0);
            }
        }

        System.out.println(strMap.size());
    }
}
