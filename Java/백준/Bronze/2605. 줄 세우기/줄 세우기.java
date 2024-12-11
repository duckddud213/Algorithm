import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deq = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num==0) deq.addLast(i);
			else {
				for(int j = 0; j<num; j++) {
					deq.addFirst(deq.pollLast());
				} //뽑은 번호만큼 poll
				deq.addLast(i); //사람 넣고
				for(int j = 0; j<num; j++) {
					deq.addLast(deq.pollFirst());
				} //원상복귀
			}
		}
		for(int i = 0; i < N; i++) {
			System.out.print(deq.poll() + " ");
		}
	}
}