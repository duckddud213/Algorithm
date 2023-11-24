import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9079 {
    public static String reverse(String coin, int change[]) {
        String result = "";
        String newCoin = "";
        int i, idx;

        if (coin.length() < 9) {
            for (int j = 0; j < 9 - coin.length(); j++) {
                newCoin += "0";
            }
            newCoin += coin;
        } 
        else {
            newCoin = coin;
        }
        for (i = 0; i < 9; i++) {
            if (i == change[0] || i == change[1] || i == change[2]) {
                if (newCoin.charAt(i) == '0') {
                    result += "1";
                } else {
                    result += "0";
                }
            } 
            else {
                result += newCoin.charAt(i);
            }
        }

        return result;
    }

    public static String toBinary(int value) {
        return Integer.toBinaryString(value);
    }

    public static int toDecimal(String bin) {
        return Integer.parseInt(bin, 2);
    }

    public static void main(String args[]) throws NumberFormatException, IOException {
        int x, T, i, j, cnt, qi, idx, ins;
        int change[][] = { { 0, 1, 2 }, { 0, 3, 6 }, { 3, 4, 5 }, { 1, 4, 7 }, { 6, 7, 8 }, { 2, 5, 8 }, { 0, 4, 8 },
                { 2, 4, 6 } };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        int visited[] = new int[512];
        int que[] = new int[512];
        int depth[] = new int[512];

        for (x = 0; x < T; x++) {
            String coin = "";
            for (i = 0; i < 512; i++) {
                visited[i] = 0;// 만들어진적이 있는 경우 1
                que[i] = -1;
            }

            for (i = 0; i < 3; i++) { // coin[0]에 초기값 기록
                String input[] = br.readLine().split(" ");
                for (j = 0; j < 3; j++) {
                    if (input[j].equals("H")) {
                        coin += "1";
                    } else {
                        coin += "0";
                    }
                }
            }

            que[0] = Integer.parseInt(coin, 2);
            depth[que[0]] = 0;
            idx = 0;
            ins = 1;
            cnt = -1;

            while (que[idx] != -1) {
                qi = que[idx];

                if (qi == 0 || qi == 511) {
                    cnt = depth[qi];
                    break;
                }

                if (visited[toDecimal(reverse(toBinary(qi), change[0]))] == 0) { // qi를 change0 규칙대로 전환한 결과값이 not
                                                                                 // visited 인 경우
                    visited[toDecimal(reverse(toBinary(qi), change[0]))] = 1; // 전환한 값에 visited 표시
                    que[ins] = toDecimal(reverse(toBinary(qi), change[0])); // 다음 방문할 que 목록에 insert
                    depth[toDecimal(reverse(toBinary(qi), change[0]))] = depth[qi] + 1; // depth 갱신
                    ins++;
                }
                if (visited[toDecimal(reverse(toBinary(qi), change[1]))] == 0) {
                    visited[toDecimal(reverse(toBinary(qi), change[1]))] = 1;
                    que[ins] = toDecimal(reverse(toBinary(qi), change[1]));
                    depth[toDecimal(reverse(toBinary(qi), change[1]))] = depth[qi] + 1;
                    ins++;
                }
                if (visited[toDecimal(reverse(toBinary(qi), change[2]))] == 0) {
                    visited[toDecimal(reverse(toBinary(qi), change[2]))] = 1;
                    que[ins] = toDecimal(reverse(toBinary(qi), change[2]));
                    depth[toDecimal(reverse(toBinary(qi), change[2]))] = depth[qi] + 1;
                    ins++;
                }
                if (visited[toDecimal(reverse(toBinary(qi), change[3]))] == 0) {
                    visited[toDecimal(reverse(toBinary(qi), change[3]))] = 1;
                    que[ins] = toDecimal(reverse(toBinary(qi), change[3]));
                    depth[toDecimal(reverse(toBinary(qi), change[3]))] = depth[qi] + 1;
                    ins++;
                }
                if (visited[toDecimal(reverse(toBinary(qi), change[4]))] == 0) {
                    visited[toDecimal(reverse(toBinary(qi), change[4]))] = 1;
                    que[ins] = toDecimal(reverse(toBinary(qi), change[4]));
                    depth[toDecimal(reverse(toBinary(qi), change[4]))] = depth[qi] + 1;
                    ins++;
                }
                if (visited[toDecimal(reverse(toBinary(qi), change[5]))] == 0) {
                    visited[toDecimal(reverse(toBinary(qi), change[5]))] = 1;
                    que[ins] = toDecimal(reverse(toBinary(qi), change[5]));
                    depth[toDecimal(reverse(toBinary(qi), change[5]))] = depth[qi] + 1;
                    ins++;
                }
                if (visited[toDecimal(reverse(toBinary(qi), change[6]))] == 0) {
                    visited[toDecimal(reverse(toBinary(qi), change[6]))] = 1;
                    que[ins] = toDecimal(reverse(toBinary(qi), change[6]));
                    depth[toDecimal(reverse(toBinary(qi), change[6]))] = depth[qi] + 1;
                    ins++;
                }
                if (visited[toDecimal(reverse(toBinary(qi), change[7]))] == 0) {
                    visited[toDecimal(reverse(toBinary(qi), change[7]))] = 1;
                    que[ins] = toDecimal(reverse(toBinary(qi), change[7]));
                    depth[toDecimal(reverse(toBinary(qi), change[7]))] = depth[qi] + 1;
                    ins++;
                }

                idx++;
            }

            System.out.println(cnt);
        }

    }
}