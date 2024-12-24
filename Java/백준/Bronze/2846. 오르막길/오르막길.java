import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        int min=Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;

        for(int i=0;i<N-1;i++){
            if(arr[i]<arr[i+1]){
                min = Math.min(min,arr[i]);
                res = Math.max(res,arr[i+1]-min);
            }
            else{
                min = Integer.MAX_VALUE;
            }
        }

        System.out.println((res==Integer.MIN_VALUE)?"0":res);
    }
}