import java.io.*;

public class boj2422 {
	public static void main(String args[]) throws IOException {
		int N,M,i,j,k,cnt;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nm[] = br.readLine().split(" ");
		
		N=Integer.parseInt(nm[0]);
		M=Integer.parseInt(nm[1]);
				
		int comb[][] = new int[N+1][N+1];
		
		for(i=1;i<=N;i++) {
			for(j=1;j<=N;j++) {
				comb[i][j]=0;
			}
		}
		
		for(i=0;i<M;i++) {
			String inp[] = br.readLine().split(" ");
			comb[Integer.parseInt(inp[0])][Integer.parseInt(inp[1])]=1;
			comb[Integer.parseInt(inp[1])][Integer.parseInt(inp[0])]=1;
		}
		
		cnt=0;
		for(i=1;i<=N;i++) {
			for(j=i+1;j<=N;j++) {
				for(k=j+1;k<=N;k++) {
					if((comb[i][j]==1) || (comb[j][k]==1) ||(comb[k][i]==1)) {
						continue;
					}
					else {
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}