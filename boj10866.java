import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class boj10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N;
		LinkedList<Integer> que = new LinkedList<Integer>();

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp[] = new String[2];

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			if (inp[0].contains("push_front")) {
				que.addFirst(Integer.parseInt(inp[1]));
			}
			else if (inp[0].contains("push_back")) {
				que.addLast(Integer.parseInt(inp[1]));
			}
			else if (inp[0].contains("pop_front")) {
				sb.append(que.isEmpty() ? -1 : que.pollFirst()).append('\n');
			}
			else if (inp[0].contains("pop_back")) {
				sb.append(que.isEmpty()?-1:que.pollLast()).append('\n');
			}
			else if (inp[0].contains("size")) {
				sb.append(que.size()).append('\n');
			}
			else if (inp[0].contains("empty")) {
				sb.append(que.isEmpty()?1:0).append('\n');
			}
			else if (inp[0].contains("front")) {
				sb.append(que.isEmpty()?-1:que.peek()).append('\n');
			}
			else if (inp[0].contains("back")) {
				sb.append(que.isEmpty()?-1:que.peekLast()).append('\n');
			}
		}
		System.out.println(sb);
	}

}
