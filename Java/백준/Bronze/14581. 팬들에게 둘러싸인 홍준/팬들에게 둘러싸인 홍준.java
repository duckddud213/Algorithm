import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append(":fan::fan::fan:").append('\n');
        String input = br.readLine();
        sb.append(":fan::").append(input).append("::fan:").append('\n');
        sb.append(":fan::fan::fan:").append('\n');
        System.out.print(sb);
    }
}