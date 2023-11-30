import java.io.*;
import java.util.*;

public class boj12015 {
    static int N, len;
    static int arr[], min[];

    public static int BinarySearch(int l, int r, int val) {
        int left, right, mid;

        left = l;
        right = r;
        mid = (left + right) / 2;
        
        while (left < right) {
            if (min[mid] < val) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        
        return right;
    }

    public static void LIS() {
        for (int i = 1; i <= N; i++) {
            if (arr[i] > min[len]) {
                min[++len] = arr[i];
            } 
            else {
                min[BinarySearch(0, len, arr[i])] = arr[i];
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        len = 0;
        arr = new int[N + 1];
        min = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        LIS();
        System.out.println(len);
    }
}
