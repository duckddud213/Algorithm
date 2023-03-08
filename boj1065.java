import java.util.Scanner;

public class boj1065 {
    public static void main(String args[]) {
        int x, i, cnt, diff1, diff2;

        Scanner sc = new Scanner(System.in);

        x = sc.nextInt();

        if (x < 100) {
            System.out.println(x);
        } else if (x < 111) {
            System.out.println(99);
        } else {
            cnt = 99;
            for (i = 111; i <= x; i++) {
                diff1 = (i / 100) - ((i % 100) / 10);
                diff2 = ((i / 10) % 10) - (i % 10);
                if (diff1 == diff2) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
