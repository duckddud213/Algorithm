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
		int length = 1; // 본인
		int maxLength = 0;

		boolean greater = false;
		boolean lower = false;
		int same = 1; // 본인은 본인과 같다.
		for (int i = 1; i < n; i++) {
			// 커져가는 경우
			if (arr[i - 1] < arr[i]) {
				if (!greater) { // 커지는 중이 아니였으면
					maxLength = Math.max(length, maxLength); // 지금까지의 길이와 최대길이를 비교해 업데이트
					length = 2; // 이전+본인
					length += same - 1; // 같다가(?) 왔을 경우의 길이도 처리해준다.(직전 same은 위에서 합해져서 빼줌)
					if (same > 1)
						same = 1;
					greater = true;
					lower = false;
				} else {
					length++;
				}
				// 작아지는 경우(위와 동일한 로직)
			} else if (arr[i - 1] > arr[i]) {
				if (!lower) {
					maxLength = Math.max(length, maxLength);
					length = 2; // 이전+본인
					length += same - 1;
					if (same > 1)
						same = 1;
					lower = true;
					greater = false;
				} else {
					length++;
				}

			} else {
				// 같으면
				length++;
				same++;
			}
			// System.out.println(arr[i]+" 길이 "+length+" 같은 "+same);
		}

		// 갱신되지 못했을 경우를 대비해 한번 더 해줌
		maxLength = Math.max(length, maxLength);

		return maxLength;
	}

}