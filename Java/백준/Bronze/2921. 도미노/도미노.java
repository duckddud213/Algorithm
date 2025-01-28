import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		//0일때는 0밖에 없으니 1부터 시작한다. N까지.
		for(int i = 1; i <= N; i++) {
			//현재 값의 2배까지 증가하는 값
			for(int j = i; j <= i * 2; j++) {
				sum += j;
			}
		}
		System.out.println(sum);
	}

}