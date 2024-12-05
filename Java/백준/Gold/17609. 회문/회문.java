import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            String current = arr[i];
            System.out.println(palindrome(0, current.length() - 1, current, 0));
        }
    }

    private static int palindrome(int s, int e, String s1, int check) {
        // 시간초과를 해결하기 위해 아래 조건을 추가함
        if(check >=2) return 2;

        while (s < e) {
            if (s1.charAt(s) == s1.charAt(e)) {
                s++;
                e--;
            } else {
                return Math.min(palindrome(s + 1, e, s1, check + 1), palindrome(s, e - 1, s1, check + 1));
            }
        }
        return check;
    }
}