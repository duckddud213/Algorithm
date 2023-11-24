import java.util.Scanner;
public class boj2503 {	
	static int num[] = new int[1000];
	
	public static void compare(int i,int result[][],int N) {
		int inpH,inpT,inpO; //비교할 숫자의 자릿수
		int ansH,ansT,ansO; //민혁이 질문한 숫자의 자릿수
		int idx; //result배열의 인덱스
		int cnt_st,cnt_b; // 스트라이크 수랑 볼 수
		
		inpH=i/100;
		inpT=(i%100)/10;
		inpO=i%10;
		
		if((inpH==inpT)||(inpT==inpO)||(inpO==inpH)) { //비교할 숫자가 서로 다른 세자리 숫자가 아닌 경우
			num[i]=0;
			return;
		}
		else if((inpH==0)||(inpT==0)||(inpO==0)) {
			num[i]=0;
			return;
		}
		
		for(idx=0;idx<N;idx++) {
			cnt_st=0;
			cnt_b=0;
			ansH=result[0][idx]/100;
			ansT=(result[0][idx]%100)/10;
			ansO=result[0][idx]%10;
			
			if(inpH==ansH) {
				cnt_st++;
			}
			if(inpT==ansT) {
				cnt_st++;
			}
			if(inpO==ansO) {
				cnt_st++;
			}
			if(inpH==ansT) {
				cnt_b++;
			}
			if(inpH==ansO) {
				cnt_b++;
			}
			if(inpT==ansH) {
				cnt_b++;
			}
			if(inpT==ansO) {
				cnt_b++;
			}
			if(inpO==ansH) {
				cnt_b++;
			}
			if(inpO==ansT) {
				cnt_b++;
			}
			
			if((cnt_st!=result[1][idx])||(cnt_b!=result[2][idx])) { //숫자 i가 스트라이크-볼 조건 중 하나라도 만족 못하면 다음 i로 넘어감
				num[i]=0;
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		int N,i,j,cnt;
		
		for(i=123;i<1000;i++) {
			num[i]=1;
		}
		
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		
		int result[][] = new int[3][N]; // 대답한 숫자에 따른 결과값 저장 배열 result[0][i] : i번째 질문
										// result[1][i] : i번째 스트라이크 수
										// result[2][i] : i번째 볼 수
		
		for(i=0;i<N;i++) {
			result[0][i]=sc.nextInt();
			result[1][i]=sc.nextInt();
			result[2][i]=sc.nextInt();
		}
		
		for(i=123;i<1000;i++) {
			compare(i,result,N);
		}
		
		cnt=0;
		for(i=123;i<1000;i++) { 
			if(num[i]==1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}