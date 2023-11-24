import java.io.*;
import java.util.*;

public class boj2470 {
    public static void main(String[] args) throws IOException {
        int N, i, sum, idxL, idxR, liq1, liq2, cur_sum;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> liquid = new ArrayList<>();

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (i = 0; i < N; i++) {
            liquid.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(liquid);

        idxL = 0; // idxL은 리스트의 왼쪽에서 중앙으로 이동하면서 값 get
        idxR = N - 1; // idxR은 리스트의 오른쪽에서 중앙으로 이동하면서 값 get

        sum = Integer.MAX_VALUE;
        liq1 = 0;
        liq2 = 0;

        while (idxL >= 0 && idxR < N && idxL < idxR) {
            cur_sum = liquid.get(idxL) + liquid.get(idxR); // 현재 인덱스 위치에서의 합
            if (Math.abs(sum) > Math.abs(cur_sum)) {
                liq1 = liquid.get(idxL);
                liq2 = liquid.get(idxR);
                sum = cur_sum;
            }

            if (cur_sum < 0) { // 0에 근접하기 위해 양수값이 더 커져야 하는 경우
                idxL++;
            } else if (cur_sum > 0) { // 0에 근접하기 위해 음수값이 더 커져야 하는 경우
                idxR--;
            } else { // 두 용액의 특성값 합이 0인 경우 => 아무 case나 출력하고 바로 종료
                break;
            }
        }

        sb.append(liq1).append(" ").append(liq2).append('\n');
        System.out.println(sb);
    }

}