import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = n/2;
		int[] a = new int[1<<(n-size)];
		int[] b = new int[1<<(size)];
		for(int i=0; i<(1<<n-size); i++) {
			for(int j=0; j<n-size; j++) {
				if((i&(1<<j))==(1<<j)) {
					a[i] +=arr[j];
				}
			}
		}
		for(int i=0; i<(1<<size); i++) {
			for(int j=0; j<size; j++) {
				if((i&(1<<j))==(1<<j)) {
					b[i]+= arr[j+(n-size)];
				}
			}
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		long cnt=0;
		for(int i=0; i<a.length;) {
			int av = a[i];
			long aTerm = upper_bound(a, av) -lower_bound(a, av);
			long bTerm = upper_bound(b, s-av)-  lower_bound(b, s-av);
			cnt+= aTerm*bTerm;
			i+=aTerm;
		}
		if(s==0) cnt--;
		System.out.println(cnt);
	}
	
	static int upper_bound(int[] arr, int t) {
		int left = 0, right =arr.length; 
		while(left<right) {
			int mid = (left+right)/2;
			if(t >= arr[mid]) {
				left = mid+1;
			}else {
				right =mid;
			}
		}
		return right;
	}
	
	static int lower_bound(int[] arr, int t) {
		int left = 0, right =arr.length; 
		while(left<right) {
			int mid = (left+right)/2;
			if(t <= arr[mid]) {
				right =mid;
			}else {
				left = mid+1;
			}
		}
		return right;
	}
}