import java.io.*;
import java.util.*;

public class boj25206 {
    static Double avg;

    public static Double gradeReturn(String input) {
        if (input.equals("A+")) {
            return 4.5;
        }
        else if (input.equals("A0")) {
            return 4.0;
        }
        else if (input.equals("B+")) {
            return 3.5;
        }
        else if (input.equals("B0")) {
            return 3.0;
        }
        else if (input.equals("C+")) {
            return 2.5;
        }
        else if (input.equals("C0")) {
            return 2.0;
        }
        else if (input.equals("D+")) {
            return 1.5;
        }
        else if (input.equals("D0")) {
            return 1.0;
        }
        else {
            return 0.0;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        avg = 0.0;
        Double totalPoint = 0.0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            Double point = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (!grade.equals("P")) {
                avg += point * gradeReturn(grade);
                totalPoint += point;
            }
        }

        avg /= totalPoint;
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.printf("%.6f", avg);
    }
}
