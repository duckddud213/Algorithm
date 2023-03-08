import java.util.Scanner;

public class boj1316 {
    public static void main(String args[]) {
        int N, i, j, loc, cnt;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int alpha[] = new int[26];
        String words[] = new String[N];
        cnt = 0;

        for (i = 0; i < N; i++) {
            words[i] = sc.next();
            for (j = 0; j < 26; j++) {
                alpha[j] = 0;
            }

            for (j = 0; j < words[i].length(); j++) {
                loc = words[i].charAt(j) - 'a';
                if (alpha[loc] != 0) {
                    if (words[i].charAt(j - 1) != words[i].charAt(j)) { // ���ĺ� ù ������ �ƴѵ� ���� ���ĺ��� �ٸ� ���
                        break;
                    }
                } else {
                    alpha[loc]++;
                }
            }

            if (j == words[i].length()) {// break�� �ɸ��� �ʰ� �ݺ����� ����� ��� => �׷�ܾ��� ���
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
