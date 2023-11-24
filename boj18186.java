import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj18186 {
	static int N;
	static long B, C, cost;
	static int ramen[];

	public static void greedy() {
		int i, tmp;

		if (B < C) {
			C = B;
		}

		for (i = 1; i <= N; i++) {
			if (ramen[i + 1] > ramen[i + 2]) {
				// �ι�° ����� ����°���� ���� ���
				// 7�� ���Ÿ� �ִ��� �ϱ� ���� �ּ������� 5�� ���Ÿ� ��
				tmp = Math.min(ramen[i], ramen[i + 1] - ramen[i + 2]);
				cost += ((B + C) * tmp);
				ramen[i] -= tmp;
				ramen[i + 1] -= tmp;

				tmp = Math.min(ramen[i], Math.min(ramen[i + 1], ramen[i + 2]));
				cost += ((B + 2 * C) * tmp);
				ramen[i] -= tmp;
				ramen[i + 1] -= tmp;
				ramen[i + 2] -= tmp;
			} else {
				// �ι�° ����� ����°���� ���� ���
				// 7�� ���Ÿ� �ִ��� �� �� 5�� ���Ÿ� ��
				tmp = Math.min(ramen[i], ramen[i + 1]);
				cost += ((B + 2 * C) * tmp);
				ramen[i] -= tmp;
				ramen[i + 1] -= tmp;
				ramen[i + 2] -= tmp;

				tmp = Math.min(ramen[i], ramen[i + 1]);
				cost += ((B + C) * tmp);
				ramen[i] -= tmp;
				ramen[i + 1] -= tmp;
			}
			cost += (B * ramen[i]);
		}
	}

	public static void pre() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		ramen = new int[N + 3]; // N��° ������ �ѹ��� ����ϱ� ���� N+3�� ũ��� ����
		cost = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			ramen[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String args[]) throws IOException {
		pre();
		greedy();
		System.out.println(cost);
	}
}
