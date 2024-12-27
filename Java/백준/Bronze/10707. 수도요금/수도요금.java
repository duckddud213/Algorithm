import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		//X사 Y사의 총 기릅값을 저장할 변수를 선언
		int X = A * P;
		//Y사는 쓰는 기름양의 따른 연산이 다르기에 0으로 초기화
		int Y = 0;
		
		//쓰는 기름 값에 따를 Y사 기름값 측정
		if(C >= P) {
			Y = B;
		}else {
			Y = B + ((P - C) * D);
		}
		//더 적게 내는 회사 기름값 출력
		if(X < Y) {
			System.out.println(X);
		}else {
			System.out.println(Y);
		}
	}

}