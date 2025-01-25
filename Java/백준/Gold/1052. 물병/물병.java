import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int ans = solution(n, k);
		System.out.println(ans);
	}
	
	public static int solution(int n, int k) {
		int ans = 0;
		while(Integer.bitCount(n) > k) {
			n ++;
			ans ++;
		}
		return ans;
	}
}