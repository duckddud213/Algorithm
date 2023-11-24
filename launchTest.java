import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class launchTest {

	static int[] arr;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solve());

	}

	private static int solve() {
		int length = 1; // ����
		int maxLength = 0;

		boolean greater = false;
		boolean lower = false;
		int same = 1; // ������ ���ΰ� ����.
		for (int i = 1; i < n; i++) {
			// Ŀ������ ���
			if (arr[i - 1] < arr[i]) {
				if (!greater) { // Ŀ���� ���� �ƴϿ�����
					maxLength = Math.max(length, maxLength); // ���ݱ����� ���̿� �ִ���̸� ���� ������Ʈ
					length = 2; // ����+����
					length += same - 1; // ���ٰ�(?) ���� ����� ���̵� ó�����ش�.(���� same�� ������ �������� ����)
					if (same > 1)
						same = 1;
					greater = true;
					lower = false;
				} else {
					length++;
				}
				// �۾����� ���(���� ������ ����)
			} else if (arr[i - 1] > arr[i]) {
				if (!lower) {
					maxLength = Math.max(length, maxLength);
					length = 2; // ����+����
					length += same - 1;
					if (same > 1)
						same = 1;
					lower = true;
					greater = false;
				} else {
					length++;
				}

			} else {
				// ������
				length++;
				same++;
			}
			// System.out.println(arr[i]+" ���� "+length+" ���� "+same);
		}

		// ���ŵ��� ������ ��츦 ����� �ѹ� �� ����
		maxLength = Math.max(length, maxLength);

		return maxLength;
	}

}