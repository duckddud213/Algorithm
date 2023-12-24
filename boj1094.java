import java.io.*;
import java.util.*;

public class boj1094 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		int result=0;
		for(int i=0; i<7; i++) {
			if((length&(1<<i))>0) result++;
		}
		System.out.println(result);
	}
}