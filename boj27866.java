import java.io.*;

public class boj27866 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int i = Integer.parseInt(br.readLine());

        System.out.println(input.charAt(i - 1));
    }
}
