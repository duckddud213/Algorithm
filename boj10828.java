import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class boj10828 {
	public static void pushX(int idx[], int x, int[] stack) {
		stack[idx[0]] = x;
		idx[0]++;
	}

	public static void popNprint(int idx[], int[] stack) {
		StringBuilder sb = new StringBuilder();
		if (idx[0] == 0) {
			sb.append("-1");
		} else {
			sb.append(stack[idx[0] - 1]);
			idx[0]--;
		}
		System.out.println(sb);
	}

	public static void printSize(int idx[], int[] stack) throws IOException {
		StringBuilder sb = new StringBuilder();

		sb.append(idx[0]);
		System.out.println(sb);
	}

	public static void isEmpty(int idx[], int[] stack) throws IOException {
		StringBuilder sb = new StringBuilder();

		if (idx[0] == 0) {
			sb.append("1");
		} else {
			sb.append("0");
		}
		System.out.println(sb);

	}

	public static void printTop(int idx[], int[] stack) throws IOException {
		StringBuilder sb = new StringBuilder();

		if (idx[0] == 0) {
			sb.append("-1");
		} else {
			sb.append(stack[idx[0] - 1]);
		}
		System.out.println(sb);
	}

	public static void main(String args[]) throws IOException {
		int N, ord, in;
		int idx[] = new int[1];
		String inp, blnk;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int stack[] = new int[N];
		idx[0] = 0;
		for (int i = 0; i < N; i++) {
			inp = br.readLine();
			StringTokenizer st = new StringTokenizer(inp);
			if (inp.contains("push")) {
				blnk = st.nextToken();
				in = Integer.parseInt(st.nextToken());
				pushX(idx, in, stack);
			} else if (inp.contains("pop")) {
				popNprint(idx, stack);
			} else if (inp.contains("size")) {
				printSize(idx, stack);
			} else if (inp.contains("empty")) {
				isEmpty(idx, stack);
			} else if (inp.contains("top")) {
				printTop(idx, stack);
			}

		}
	}
}
