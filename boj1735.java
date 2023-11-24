import java.io.*;
import java.util.*;

public class boj1735 {
    static int A1, B1, A2, B2, sumA, sumB;
    
    public static void Euclidean() {
        int p, q; //q < p 인 값 저장
        int div,tmp;
        if (sumA > sumB) {
            p = sumA;
            q = sumB;
        }
        else {
            p = sumB;
            q = sumA;
        }

        while (true) {
            tmp = p % q;
            if (tmp == 0) {
                div = q;
                break;
            }
            p = q;
            q = tmp;
        }

        sumA /= div;
        sumB /= div;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A1 = Integer.parseInt(st.nextToken());
        B1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A2 = Integer.parseInt(st.nextToken());
        B2 = Integer.parseInt(st.nextToken());

        A1 *= B2;
        A2 *= B1;
        sumA = A1 + A2;
        sumB = B1*B2;
    }

    public static void main(String args[]) throws IOException {
        pre();
        Euclidean();
        System.out.println(sumA+" "+sumB);
    }
}
