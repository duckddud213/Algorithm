import java.util.Scanner;

public class boj1193 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int x, n, cnt_line, add_n, deno, nume;// deno 분모 , nume 분자

        x = sc.nextInt();

        n = 1;
        cnt_line = 0;
        add_n = 1;

        while (n <= x) {
            n += add_n;
            add_n++;
            cnt_line++;
        }

        deno = 1;
        nume = cnt_line;

        if (cnt_line % 2 == 0) {
            n--;
            while (n != x) {
                n--;
                deno++;
                nume--;
            }
        } else {
            n -= (add_n - 1);
            while (n != x) {
                n++;
                deno++;
                nume--;
            }
        }

        System.out.println(nume + "/" + deno);
    }
}