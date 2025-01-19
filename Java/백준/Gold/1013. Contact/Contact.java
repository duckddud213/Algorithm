import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(t-->0) {
			String line = br.readLine();
			sb.append(solve(line) ? "YES\n" : "NO\n"); // line.matches("(100+1+|01+)+");
		}
		System.out.println(sb.toString());
	}
	
	static boolean solve(String pattern) {
		if(pattern.startsWith("01")) {
			if(pattern.length()==2) return true;
			if(solve(pattern.substring(2,pattern.length()))) return true;
		}
		else if(pattern.matches("100+1+[01]*")) {
			int s = pattern.indexOf('1', 1);
			int e = s;
			while(pattern.charAt(e)=='1') {
				if(pattern.length()==e+1) return true;
				e++;
			}
			for(int i=s; i<e; i++) {
				if(solve(pattern.substring(i+1,pattern.length()))) return true;
			}
		}
		return false;
	}
}