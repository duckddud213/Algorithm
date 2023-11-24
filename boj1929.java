import java.util.Scanner;

public class boj1929 {
    public static void main(String args[]){
        int N,M,i,j;

        Scanner sc = new Scanner(System.in);
        M=sc.nextInt();
        N=sc.nextInt();

        int sift[] = new int[N+1];

        sift[1]=0;
        for(i=2;i<=N;i++){
            if(sift[i]==-1){
                continue;
            }
            
            sift[i]=1;

            for(j=2;j<=N/i;j++){
                sift[i*j]=-1;
            }
        }

        for(i=M;i<=N;i++){
            if(sift[i]==1){
                System.out.println(i);
            }
        }
    }
}
