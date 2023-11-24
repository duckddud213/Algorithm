import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class boj18258 {
	public static void main(String args[]) throws IOException {
		int N, idx;
		String inp[] = new String[2];
		LinkedList<Integer> que = new LinkedList<Integer>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		idx = 0;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");

			if (inp[0].contains("push")) {
				que.add(Integer.parseInt(inp[1]));
				idx++;
			}
			else if (inp[0].contains("pop")) {
				if (que.peek() == null) {
					sb.append(-1).append('\n');
					continue;
				}
				sb.append(que.peek()).append('\n');
				que.remove();

				idx--;
			}
			else if (inp[0].contains("size")) {
				sb.append(idx <= 0 ? 0 : idx).append('\n');
			}
			else if (inp[0].contains("empty")) {
				sb.append(que.isEmpty() ? 1 : 0).append('\n');
			}
			else if (inp[0].contains("front")) {
				sb.append(idx <= 0 ? -1 : que.peek()).append('\n');
			}
			else if (inp[0].contains("back")) {
				sb.append(idx <= 0 ? -1 : que.peekLast()).append('\n');
			}
		}
		System.out.print(sb);
	}
}
