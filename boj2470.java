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

        idxL = 0; // idxL�� ����Ʈ�� ���ʿ��� �߾����� �̵��ϸ鼭 �� get
        idxR = N - 1; // idxR�� ����Ʈ�� �����ʿ��� �߾����� �̵��ϸ鼭 �� get

        sum = Integer.MAX_VALUE;
        liq1 = 0;
        liq2 = 0;

        while (idxL >= 0 && idxR < N && idxL < idxR) {
            cur_sum = liquid.get(idxL) + liquid.get(idxR); // ���� �ε��� ��ġ������ ��
            if (Math.abs(sum) > Math.abs(cur_sum)) {
                liq1 = liquid.get(idxL);
                liq2 = liquid.get(idxR);
                sum = cur_sum;
            }

            if (cur_sum < 0) { // 0�� �����ϱ� ���� ������� �� Ŀ���� �ϴ� ���
                idxL++;
            } else if (cur_sum > 0) { // 0�� �����ϱ� ���� �������� �� Ŀ���� �ϴ� ���
                idxR--;
            } else { // �� ����� Ư���� ���� 0�� ��� => �ƹ� case�� ����ϰ� �ٷ� ����
                break;
            }
        }

        sb.append(liq1).append(" ").append(liq2).append('\n');
        System.out.println(sb);
    }

}